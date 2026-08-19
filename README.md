# BestPrice

BestPrice is a full-stack price comparison application for technology peripherals. It compares offers from multiple stores and displays historical price changes through interactive charts.

> This portfolio project currently uses demonstration data. Prices and availability do not represent live store information.

## Features

- Search products by name or brand
- Filter products by category
- Compare store offers ordered by lowest price
- Highlight the best available offer
- View historical prices in an interactive chart
- Persist products, stores, offers and price records in MySQL
- Responsive interface for desktop and mobile
- Keep database credentials outside version control

## Tech stack

- Java 21
- Spring Boot 4
- Spring MVC and Thymeleaf
- Spring Data JPA and Hibernate
- MySQL 8
- Chart.js
- HTML5 and CSS3
- Maven

## Architecture

```text
Browser
   ↓
Spring MVC Controllers
   ↓
Spring Data JPA Repositories
   ↓
MySQL
```

Main domain relationships:

```text
Product 1 ── N Offer N ── 1 Store
                 │
                 └── 1 ── N PriceHistory
```

## Running locally

### Requirements

- Java 21
- Maven 3.9+
- MySQL 8

### Database

Create the database and a dedicated application user:

```sql
CREATE DATABASE best_price
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE USER 'bestprice_app'@'localhost' IDENTIFIED BY 'your-password';
GRANT ALL PRIVILEGES ON best_price.* TO 'bestprice_app'@'localhost';
```

### Environment variables

PowerShell:

```powershell
$env:DB_PASSWORD = "your-password"
```

Optionally override the default database username:

```powershell
$env:DB_USERNAME = "bestprice_app"
```

### Start the application

```powershell
mvn spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080).

The application inserts a small demonstration dataset when no offers exist.

## Security note

Database passwords are read from environment variables and are never committed to the repository.

## Future improvements

- Administrative product and offer management
- Automated price ingestion through authorized APIs
- User accounts, favorites and price alerts
- Database migrations with Flyway
- Automated integration tests
- Cloud deployment
