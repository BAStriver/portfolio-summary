package com.bas.detector;

import com.bas.detector.service.PortfolioService;
import com.bas.detector.util.CSVLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DetectorApplicationTests {

    @Autowired
    public PortfolioService portfolioService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws IOException {
        portfolioService.setPositionList(CSVLoader.readPositionsFromCSV("input.csv"));
        portfolioService.subscribe();
    }

}
