package com.example.coinmarket.controllers;

import com.example.coinmarket.dto.CoinDTO;
import com.example.coinmarket.entity.Coin;
import com.example.coinmarket.entity.Market;
import com.example.coinmarket.services.CoinService;
import com.example.coinmarket.services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/coins")
@CrossOrigin
public class CoinController {
    @Autowired
    private CoinService coinService;
    @Autowired
    private MarketService marketService;

    @GetMapping
    public ResponseEntity getList(){
        List<Coin> coinList = coinService.getList();
        List<CoinDTO> coinDTOS = new ArrayList<>();
        for (Coin coin: coinList) {
            coinDTOS.add(new CoinDTO(coin));
        }
        return new ResponseEntity( coinDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CoinDTO coinDTO){
        Coin coin = new Coin(coinDTO);
        System.out.println(coin);
        Market market = marketService.getById(coinDTO.getMarketId());
        System.out.println(coinDTO.getMarketId());
        coin.setMarket(market);
        market.addCoin(coin);
        Coin savedCoin = coinService.store(coin);
        return new ResponseEntity(savedCoin, HttpStatus.OK);
    }
}
