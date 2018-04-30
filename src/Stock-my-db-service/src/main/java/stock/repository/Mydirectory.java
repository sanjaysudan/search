package stock.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;



@Entity
public class Mydirectory {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Mydirectory() {}

	public Mydirectory(String name) {
		this.name = name;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	}
