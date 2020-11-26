package mk.codeacademy.java.hib_on_class;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Guide {

	@Id
	private long id;
	private String name;

	@OneToMany(mappedBy = "guide")
	private List<Student> students;
}
