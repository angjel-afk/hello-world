package mk.codeacademy.java.hib_on_class;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long studentid;
	private String name;
	@Embedded
	private Address address;
	public void setAddress(Address a1) {
		
		
	}
	public void setName(String string) {
		
		
	}
	

}
