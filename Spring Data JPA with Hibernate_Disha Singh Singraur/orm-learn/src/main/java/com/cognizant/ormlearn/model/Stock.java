package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * File 2, Hands on 2: Stock Entity Class
 */
@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code", length = 10)
    private String code;

    @Column(name = "st_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "st_open", precision = 10, scale = 2)
    private BigDecimal open;

    @Column(name = "st_close", precision = 10, scale = 2)
    private BigDecimal close;

    @Column(name = "st_volume")
    private Long volume;
}
