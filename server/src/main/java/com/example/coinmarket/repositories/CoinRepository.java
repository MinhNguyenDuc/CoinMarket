package com.example.coinmarket.repositories;

import com.example.coinmarket.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Integer> {
}
