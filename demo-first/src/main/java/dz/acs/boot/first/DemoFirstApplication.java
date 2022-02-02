package dz.acs.boot.first;

import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;

@SpringBootApplication
public class DemoFirstApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoFirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//create("amine","amine");
	}
	
	@Autowired
	private LdapTemplate ldapTemplate;
	
	public void create(String username, String password) {
	    LdapName dn = LdapNameBuilder
	      .newInstance()
	      .add("ou", "users")
	      .add("cn", username)
	      .build();
    DirContextAdapter context = new DirContextAdapter(dn);

	    context.setAttributeValues("objectclass",new String[]{ "top","person","organizationalPerson","inetOrgPerson" });
	    context.setAttributeValue("cn", username);
	    context.setAttributeValue("sn", username);
	    context.setAttributeValue("userPassword", password);

	    ldapTemplate.bind(context);
	}

}
