package mk.codeacademy.java.hib_on_class;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "vodic_id")
	private Guide guide;

	@OneToOne
	@JoinColumn(name = "passport_id")
	private Passport passport;
	@ManyToMany
	@JoinTable(name = "students_courses", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private List<Course> courses;
	
	@ElementCollection
	@CollectionTable(name = "student_nicknames", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "nick_name")
	private List<String>  nicknames;
}
