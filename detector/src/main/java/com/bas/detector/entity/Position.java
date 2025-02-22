package com.bas.detector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Position {
    @Id
    private String symbol;
    private int positionSize;

    public Position(String symbol, int positionSize) {
        this.symbol = symbol;
        this.positionSize = positionSize;
    }

    public Position() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPositionSize() {
        return positionSize;
    }

    public void setPositionSize(int positionSize) {
        this.positionSize = positionSize;
    }

    @Override
    public String toString() {
        return "Position [symbol=" + symbol + ", positionSize=" + positionSize + "]";
    }
}

