package com.example.salesproject;

import com.example.salesproject.database.entity.CategoryEntity;
import com.example.salesproject.database.entity.ProductEntity;
import com.example.salesproject.database.repository.CategoryRepository;
import com.example.salesproject.database.repository.ProductRepository;
import com.example.salesproject.service.CategoryService;
import com.example.salesproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SalesProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesProjectApplication.class, args);
    }

    // Uygulama ayağa kalktıktan sonra çalışır, CLI gibi.
    /*
    @Override
    public void run(String... args) throws Exception {


    }
     */
}

