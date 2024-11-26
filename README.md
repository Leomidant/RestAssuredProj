
# Technical Task

This repository contains a test automation framework for API and Mobile testing. It leverages **Cucumber** with **JUnit** to define and execute tests in a BDD format. The framework supports both API and Mobile test scenarios, with clear separation using tags (`@api` and `@mobile`). Test reports are generated using **Allure** for easy visualization.

---

## Prerequisites

Ensure the following tools are installed on your system:

- **Java 8+**
- **Maven 3.6+**
- **Node.js** (for mobile testing dependencies)
- **Appium Server** (for Mobile testing setup)
- **Allure CLI** (for serving reports):
  ```bash
  npm install -g allure-commandline
  ```

---

## How to Run the Tests

### 1. Clone the Repository
Clone the repository and navigate to the project directory:
```bash
git clone https://github.com/Leomidant/Technical-Task.git
cd Technical-Task
```

### 2. Install Dependencies
Use Maven to download and install the necessary dependencies:
```bash
mvn clean install
```

### 3. Run Tests
#### Run All Tests
Execute all tests (API and Mobile):
```bash
mvn clean test
```

#### Run API Tests Only
To execute API tests, use the `@api` tag:
```bash
mvn clean test -Dcucumber.filter.tags="@api"
```

#### Run Mobile Tests Only
To execute Mobile tests, use the `@mobile` tag:
```bash
mvn clean test -Dcucumber.filter.tags="@mobile"
```

---

## View Test Reports

After running the tests, generate and view the Allure report:
1. Serve the report locally:
   ```bash
   allure serve allure-results
   ```
2. This command will open the Allure report in your default browser.

---

---

## Notes

- The `@api` and `@mobile` tags must be added to feature files or scenarios to correctly filter the tests.
- Ensure your Appium server is running and configured properly for Mobile tests.

---
