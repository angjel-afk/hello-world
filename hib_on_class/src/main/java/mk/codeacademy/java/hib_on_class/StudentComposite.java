package mk.codeacademy.java.hib_on_class;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StudentComposite {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long studentId;
  
  private String name;
  @Embedded
  private Address address;
  
}