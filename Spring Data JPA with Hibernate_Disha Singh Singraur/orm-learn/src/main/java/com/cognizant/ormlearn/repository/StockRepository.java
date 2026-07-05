package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * File 2, Hands on 2: StockRepository
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Get stock details by code and date range (e.g., September 2019)
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Get stock details where stock price is greater than a value
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // 3. Find top 3 stocks by volume descending (highest volume)
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Find top 3 stocks by code and close ascending (lowest stock prices)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
