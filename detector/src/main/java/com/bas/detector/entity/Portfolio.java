package com.bas.detector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Portfolio {
    @Id
    private String ticker;
    private double price;
    private double marketValue;

    public Portfolio() {
    }

    public Portfolio(String ticker, double price, double marketValue) {
        this.ticker = ticker;
        this.price = price;
        this.marketValue = marketValue;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }
}
