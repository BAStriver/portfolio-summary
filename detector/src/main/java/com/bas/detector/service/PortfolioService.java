package com.bas.detector.service;

import com.bas.detector.entity.Portfolio;
import com.bas.detector.entity.Position;
import com.bas.detector.entity.Security;
import com.bas.detector.repository.PortfolioRepository;
import com.bas.detector.repository.SecurityRepository;
import com.bas.detector.util.MarketDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    private List<Position> positionList;

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public void updatePortfolio() {
        double totalNav = 0;
//        List<Position> positionList = CSVLoader.readPositionsFromCSV("input.csv");
        System.out.println("## Portfolio");
        System.out.printf("%-25s %-10s %-10s %-15s%n", "symbol", "price", "qtv", "value");
        for (Position position : positionList) {
            Security security = securityRepository.findByTicker(position.getSymbol());
            Portfolio portfolio = portfolioRepository.findByTicker(position.getSymbol());
            if (security == null || portfolio == null) continue;
            double price = MarketDataProvider.calculateNewPrice(portfolio.getPrice(), security.getVolatility());
            double marketValue = position.getPositionSize() * price;
            totalNav += marketValue;

            if (Double.compare(price, portfolio.getPrice()) != 0) {
                portfolio.setPrice(price);
                portfolioRepository.saveAndFlush(portfolio);
//                System.out.printf("%-10s change to %-10s%n", position.getSymbol(), String.format("%.2f", price));
            }

            System.out.printf("%-25s %-10s %-10s %-15s%n", position.getSymbol(), String.format("%.2f", price), position.getPositionSize(), String.format("%.2f", marketValue));
        }
        System.out.printf("%-25s %-20s%n", "#Total portfolio", String.format("%.2f", totalNav));
    }

    public void subscribe() {
        int index = 1;
        while (true) {
            System.out.printf("%n%-5s %-10s%n", "## " + index, "Market Data Update");
            updatePortfolio();
            try {
                Thread.sleep(2000); // Sleep for 1 second between updates
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                index++;
            }
        }
    }
}
