package com.bas.detector;

import com.bas.detector.entity.Portfolio;
import com.bas.detector.entity.Security;
import com.bas.detector.repository.PortfolioRepository;
import com.bas.detector.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class DetectorApplication {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DetectorApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return (args) -> {
            // init Security data
            Security security1 = new Security("AAPL", "stock", 0, LocalDate.now(), 0.1);
            Security security2 = new Security("AAPL-OCT-2020-110-C", "call", 110, LocalDate.of(2025, 2, 21), 0.3);
            Security security3 = new Security("AAPL-OCT-2020-110-P", "put", 110, LocalDate.of(2025, 2, 21), 1);
            Security security4 = new Security("TELSA", "stock", 0, LocalDate.now(), 0.1);
            Security security5 = new Security("TELSA-NOV-2020-400-C", "call", 110, LocalDate.of(2025, 2, 21), 0.2);
            Security security6 = new Security("TELSA-DEC-2020-400-P", "put", 110, LocalDate.of(2025, 2, 21), 1);

            securityRepository.save(security1);
            securityRepository.save(security2);
            securityRepository.save(security3);
            securityRepository.save(security4);
            securityRepository.save(security5);
            securityRepository.save(security6);

            // init Portfolio data
            Portfolio portfolio1 = new Portfolio("AAPL", 110, 110000);
            Portfolio portfolio2 = new Portfolio("AAPL-OCT-2020-110-C", 5.55, -111000);
            Portfolio portfolio3 = new Portfolio("AAPL-OCT-2020-110-P", 0.55, 11000);
            Portfolio portfolio4 = new Portfolio("TELSA", 450, -225000);
            Portfolio portfolio5 = new Portfolio("TELSA-NOV-2020-400-C", 27.25, 272500);
            Portfolio portfolio6 = new Portfolio("TELSA-DEC-2020-400-P", 6.35, -63500);

            portfolioRepository.save(portfolio1);
            portfolioRepository.save(portfolio2);
            portfolioRepository.save(portfolio3);
            portfolioRepository.save(portfolio4);
            portfolioRepository.save(portfolio5);
            portfolioRepository.save(portfolio6);

            System.out.println("Initial data loaded into the database.");
        };
    }

}
