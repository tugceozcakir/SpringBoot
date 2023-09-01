package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "report")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "report_uuid"
        )
)
public class ReportEntity extends BaseEntity {
    @Column
    private String report;
}
