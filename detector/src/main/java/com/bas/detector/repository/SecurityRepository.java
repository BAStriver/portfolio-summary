package com.bas.detector.repository;

import com.bas.detector.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, String> {

    Security findByTicker(String ticker);

}
