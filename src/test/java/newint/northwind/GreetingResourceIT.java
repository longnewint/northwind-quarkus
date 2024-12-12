package newint.northwind;

import org.junit.jupiter.api.Disabled;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@Disabled
class GreetingResourceIT extends GreetingResourceTest {
    // Execute the same tests but in packaged mode.
}
