package com.example.salesproject.database.entity;

import com.example.salesproject.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class SettingEntity extends BaseEntity {
    @Column
    private String key;

    @Column
    private String value;
}
