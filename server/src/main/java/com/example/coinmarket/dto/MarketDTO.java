package com.example.coinmarket.dto;

import com.example.coinmarket.entity.Market;
import com.example.coinmarket.utils.ObjectUtil;

import java.util.List;

public class MarketDTO {
    private int id;
    private String name;
    private String description;
    private List<CoinDTO> coins;
    private long createdAt;
    private long updatedAt;
    private int status;


    public MarketDTO() {
    }

    public MarketDTO(Market market){
        ObjectUtil.cloneObject(this, market);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CoinDTO> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinDTO> coins) {
        this.coins = coins;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
