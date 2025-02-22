package com.bas.detector.repository;

import com.bas.detector.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, String> {

    Portfolio findByTicker(String ticker);

}
