package travelator;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailAddressTests {

  @Test
  void parsing() {
    assertEquals(
        new EmailAddress("fred", "example.com"),
        EmailAddress.parse("fred@example.com")
    );
  }

  @Test
  void parsingFailures() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EmailAddress.parse("@")
    );
  }
}
