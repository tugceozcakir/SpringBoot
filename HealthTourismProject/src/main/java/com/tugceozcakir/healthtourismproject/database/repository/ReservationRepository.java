package com.tugceozcakir.healthtourismproject.database.repository;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends BaseRepository<ReservationEntity> {
    List<ReservationEntity> findByCancellationTimeBefore(LocalDateTime cancellationTime);
    List<ReservationEntity> findByReservationTimeBeforeAndCancellationTimeIsNull(LocalDateTime time);

}
