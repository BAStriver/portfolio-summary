package com.bas.detector.util;

public class MarketDataProvider {
    public static double calculateNewPrice(double currentPrice, double volatility) {
        double mu = 0.05;
        double dt = System.currentTimeMillis() / 7257600.0 / 1000.0;
        if (dt > 1) {
            dt = 1;
        }
        double randomValue = Math.random();
        return currentPrice * Math.exp((mu - 0.5 * volatility * volatility) * dt + volatility * Math.sqrt(dt) * randomValue);
    }
}