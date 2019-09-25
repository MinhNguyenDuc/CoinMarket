package com.example.coinmarket.controllers;

import com.example.coinmarket.dto.MarketDTO;
import com.example.coinmarket.entity.Market;
import com.example.coinmarket.services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/markets")
@CrossOrigin
public class MarketController {
    @Autowired
    private MarketService marketService;

    @GetMapping
    public ResponseEntity getList(){
        List<Market> markets = marketService.getList();
        List<MarketDTO> marketDTOS = new ArrayList<>();
        for (Market market: markets) {
            marketDTOS.add(new MarketDTO(market));
        }
        return new ResponseEntity(marketDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Market market){
        if(market == null){
            return new ResponseEntity("nothing", HttpStatus.BAD_REQUEST);
        }
        Market savedMarket = marketService.store(market);
        return new ResponseEntity(savedMarket, HttpStatus.OK);
    }
}
