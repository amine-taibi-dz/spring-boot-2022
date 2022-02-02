package dz.acs.boot.first;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;

@SpringBootTest
class DemoFirstApplicationTests {
	@Autowired
	private LdapTemplate ldapTemplate;
	@Test
	void contextLoads() {
		ldapTemplate.authenticate("", "", "ataibi");
		
	}

}
