# Portfolio summary Management
A system to show the real-time value of her portfolio which consist of three types of products:   
1. Common stocks.  
2. European Call options on common stocks.   
3. European Put options on common stocks.

This project simulates the real-time pricing of stocks.

The system allows for real-time updates of stock prices, with each stock having a random update interval. The portfolio's value is calculated and displayed after every price update, providing an overview of the portfolio's current state.

## 1.Features
- Simulates real-time stock price updates.
- Each stock price has a random update interval.
- Option pricing is calculated.
- Portfolio value is updated and displayed in real-time.
- Stocks with different volatilises and update frequencies can be simulated.

## 2.Project Structure
The project consists of several key components:
1. **MarketDataProvider**: Generates real-time stock price updates based on GBM.
2. **PortfolioService**: Listens for stock price updates and recalculates the portfolio's value, and to print the portfolio's value and individual stock prices.
3. **CSVLoader**: Get the positions from a mock CSV position file.
4. **DetectorApplication**: Load the initial data for security and price.
5. **DetectorApplicationTests**: Start the app to print the stock price in real-time.

## 3.Requirements
- Java 8 or higher
- Gradle 8.12.1 (for building the project)
- Dependencies: Guava, H2 Database (for data storing), JUnit (for testing)

## 4.Repository
```bash
git clone https://github.com/BAStriver/portfolio-summary.git
