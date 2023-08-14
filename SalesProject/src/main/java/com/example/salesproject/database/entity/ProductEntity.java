package com.example.salesproject.database.entity;

import com.example.salesproject.model.enums.ColorEnum;
import com.example.salesproject.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {


    @Column
    private String name;

    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column
    private BigDecimal sellPrice;

    @Column
    private BigDecimal buyPrice;

    @Column
    private Integer quantity;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "productList")
    @JsonIgnore
    private Set<CategoryEntity> categoryList;


    @ManyToOne(fetch = FetchType.EAGER)
    private TaxEntity tax;


}
