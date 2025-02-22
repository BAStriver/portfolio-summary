package com.bas.detector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Security {
    @Id
    private String ticker;
    private String type; // "stock", "call", or "put"
    private double strike;
    private LocalDate maturity;
    private double volatility;

    public Security() {
    }

    public Security(String ticker, String type, double strike, LocalDate maturity, double volatility) {
        this.ticker = ticker;
        this.type = type;
        this.strike = strike;
        this.maturity = maturity;
        this.volatility = volatility;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getStrike() {
        return strike;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public LocalDate getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDate maturity) {
        this.maturity = maturity;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }
}
