# TestNG CI/CD Demo Project

A simple demonstration of TestNG features with CI/CD pipeline.

## TestNG Features Demonstrated

- ✅ Test Annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`)
- ✅ Test Groups (`smoke`, `unit`, `error-handling`)
- ✅ Data Providers
- ✅ Expected Exceptions
- ✅ Test Dependencies
- ✅ Parallel Execution
- ✅ CI/CD Integration (GitHub Actions)

## How to Run Tests

```bash
# Run all tests
mvn clean test

# Run smoke tests only
mvn test -Dgroups=smoke

# Run unit tests only
mvn test -Dgroups=unit

# Run with testng.xml
mvn test -Dsurefire.suiteXmlFiles=testng.xml