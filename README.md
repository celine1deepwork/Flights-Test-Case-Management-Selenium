# Flight Booking Test Automation

This project contains automated test cases for a flight booking application using Selenium WebDriver with Java. The tests verify various functionalities of the flight booking process including search, filtering, and form submission.

## Prerequisites

- Java JDK 8 or higher
- Maven
- Chrome/Firefox WebDriver
- Selenium WebDriver
- JUnit

## Project Structure

```
├── src
│   ├── test
│   │   ├── java
│   │   │   └── case1
│   │   │       └── com
│   │   │           └── enuygundemo
│   │   │               ├── base
│   │   │               │   └── BaseTest.java
│   │   │               ├── pages
│   │   │               │   ├── FlightsPage.java
│   │   │               │   └── Filters.java
│   │   │               └── tests
│   │   │                   └── flights
│   │   │                       └── FlightsTest.java
```

## Test Cases

### CASE 1: Basic Flight Search with Time Filter
Tests the basic flight search functionality with time-based filtering.

**Steps:**
1. Close initial popup
2. Set departure city to Istanbul
3. Set arrival city to Ankara
4. Select departure date (Nov 5, 2024)
5. Select return date (Dec 1, 2024)
6. Click search button
7. Filter flights between 10:00 and 18:00

**Assertions:**
- Verifies URL contains correct cities
- Validates time filter application

### CASE 2: Flight Search with Airline Filter
Tests flight search with specific airline filtering and price sorting.

**Steps:**
1. Perform basic flight search (steps 1-6 from CASE 1)
2. Apply Turkish Airlines filter
3. Sort flights by price (lowest first)

**Assertions:**
- Verifies URL contains correct cities
- Validates price sorting is applied
- Checks airline filter is active

### CASE 3: Complete Booking Flow
Tests the entire booking flow including form submission.

**Steps:**
1. Perform basic flight search (steps 1-6 from CASE 1)
2. Apply Turkish Airlines filter
3. Sort by price
4. Select a flight
5. Fill in passenger form details

**Assertions:**
- Verifies URL parameters
- Validates flight selection
- Checks form submission

## Key Functions

### FlightsPage Class
- `setFromDestination(String city)`: Sets departure city
- `setToDestination(String city)`: Sets arrival city
- `selectDepartureDate(String month, String day)`: Selects departure date
- `selectArrivalDate(String month, String day)`: Selects return date
- `clickSearchButton()`: Initiates flight search

### Filters Class
- `closePopUp()`: Handles initial popup
- `adjustSliders()`: Sets time range filter
- `flightFilter()`: Applies airline filter
- `priceSort()`: Sorts flights by price
- `selectFlight()`: Selects first available flight
- `formSelect()`: Fills passenger information form

## Running the Tests

Execute individual test cases:

```bash
# Run Case 1
mvn test -Dtest=FlightsTest#case01

# Run Case 2
mvn test -Dtest=FlightsTest#case02

# Run Case 3
mvn test -Dtest=FlightsTest#case03

# Run all tests
mvn test
```

## Test Execution Flow

Each test case follows this general pattern:
1. Extends BaseTest for common setup
2. Initializes page objects
3. Executes test steps with logging
4. Performs assertions
5. Handles exceptions with detailed error messages

## Error Handling

- All test cases are wrapped in try-catch blocks
- Detailed error messages are logged to console
- Test failures throw RuntimeException with cause

## Notes

- Tests use explicit waits for better reliability
- Thread.sleep() is used in some places to ensure stability
- All selectors are maintained in respective page objects
- Tests run in sequence but are independent of each other

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request
