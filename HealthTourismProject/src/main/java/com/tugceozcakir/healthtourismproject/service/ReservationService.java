package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.*;
import com.tugceozcakir.healthtourismproject.database.repository.ReservationRepository;
import com.tugceozcakir.healthtourismproject.database.specification.ReservationSpecification;
import com.tugceozcakir.healthtourismproject.mapper.BankAccountMapper;
import com.tugceozcakir.healthtourismproject.mapper.ReservationMapper;
import com.tugceozcakir.healthtourismproject.model.ReservationDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReservationRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService extends BaseService<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationRepository,
        ReservationSpecification
        > {

    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationSpecification reservationSpecification;

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    protected ReservationRepository getRepository() {
        return reservationRepository;
    }

    @Override
    protected ReservationSpecification getSpecification() {
        return reservationSpecification;
    }

    public boolean makeReservation(UserEntity user, RoomEntity room, DoctorEntity doctor, AirplaneEntity airplane) {
        BankAccountEntity userBankAccount = user.getBankAccounts().get(0);

        BigDecimal roomPrice = room.getPrice();
        BigDecimal doctorFee = doctor.getDoctorFee();
        BigDecimal airplaneTicketPrice = airplane.getAirplaneTicketPrice();

        BigDecimal totalCost = roomPrice.add(doctorFee).add(airplaneTicketPrice);

        BigDecimal userBalance = userBankAccount.getAmount();

        if (userBalance.compareTo(totalCost) >= 0) {
            ReservationEntity reservation = new ReservationEntity();
            reservation.setUser(user);
            reservation.setRoom(room);
            reservation.setDoctor(doctor);
            reservation.setAirplane(airplane);
            reservation.setReservationTime(LocalDateTime.now());

            reservationRepository.save(reservation);

            userBankAccount.setAmount(userBalance.subtract(totalCost));
            airplane.makeReservation();

            return true;
        }

        return false;
    }

    public ReservationEntity makeReservationForRoom(RoomEntity room) {
        ReservationEntity reservation = new ReservationEntity();
        reservation.setRoom(room);
        reservationRepository.save(reservation);
        return reservation;
    }

    public ReservationEntity makeReservationForDoctor(DoctorEntity doctor) {
        ReservationEntity reservation = new ReservationEntity();
        reservation.setDoctor(doctor);
        reservationRepository.save(reservation);
        return reservation;
    }

    public ReservationEntity makeReservationForAirplane(AirplaneEntity airplane) {
        ReservationEntity reservation = new ReservationEntity();
        reservation.setAirplane(airplane);
        reservationRepository.save(reservation);
        return reservation;
    }

    @Scheduled(fixedDelay = 600000)
    public void checkAndCancelExpiredReservations() {
        LocalDateTime cancellationTimeLimit = LocalDateTime.now().minusMinutes(10);

        List<ReservationEntity> reservationsToCancel = reservationRepository.findByReservationTimeBeforeAndCancellationTimeIsNull(cancellationTimeLimit);

        for (ReservationEntity reservation : reservationsToCancel) {
            reservationRepository.delete(reservation);
        }
    }
}
