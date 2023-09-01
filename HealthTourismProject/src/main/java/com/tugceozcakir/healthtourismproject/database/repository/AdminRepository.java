package com.tugceozcakir.healthtourismproject.database.repository;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends BaseRepository<AdminEntity> {


}
