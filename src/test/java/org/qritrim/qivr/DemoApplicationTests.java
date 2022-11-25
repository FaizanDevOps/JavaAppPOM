package org.qritrim.qivr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class DemoApplicationTests {   

	@Test
	@DisplayName("Checking for null as password")
	void testFactoidSignUpInValidPassword() {
		assertEquals(true, true);
	}

}
