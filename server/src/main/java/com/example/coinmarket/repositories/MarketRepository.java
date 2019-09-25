package com.example.coinmarket.repositories;

import com.example.coinmarket.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Integer> {
}
