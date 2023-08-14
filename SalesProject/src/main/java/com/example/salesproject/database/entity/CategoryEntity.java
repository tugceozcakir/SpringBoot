package com.example.salesproject.database.entity;

import com.example.salesproject.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class CategoryEntity extends BaseEntity {

    @Column
    private String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private Set<ProductEntity> productList = new HashSet<>();


}
