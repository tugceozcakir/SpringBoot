package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaxEntityRepository extends IBaseRepository<TaxEntity> {


}