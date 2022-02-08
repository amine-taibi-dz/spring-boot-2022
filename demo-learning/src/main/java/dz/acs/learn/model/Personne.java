package dz.acs.learn.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="person")
public class Personne {
	@Id
	private Long personId;
	private String name;
	private int age;


	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Personne(){}

	@PersistenceConstructor
	public Personne(Long personId, String name, int age)
	{
		super();
		this.personId = personId;
		this.name = name;
		this.age = age;
	}
}
