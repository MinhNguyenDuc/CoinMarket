package com.example.coinmarket.services;

import com.example.coinmarket.entity.Coin;
import com.example.coinmarket.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getList(){
        return coinRepository.findAll();
    }

    public Coin getById(int id){
        return coinRepository.findById(id).orElse(null);
    }

    public Coin store(Coin coin){
        return coinRepository.save(coin);
    }
}
