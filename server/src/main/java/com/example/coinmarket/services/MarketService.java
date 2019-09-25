package com.example.coinmarket.services;

import com.example.coinmarket.entity.Market;
import com.example.coinmarket.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public List<Market> getList(){
        return marketRepository.findAll();
    }

    public Market getById(int id){
        return marketRepository.findById(id).orElse(null);
    }

    public Market store(Market market){
        return marketRepository.save(market);
    }


}
