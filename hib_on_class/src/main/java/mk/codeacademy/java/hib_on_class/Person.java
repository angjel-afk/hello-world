package mk.codeacademy.java.hib_on_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THE_PERSONS")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long personId;
  private String firstname;
  private String lastname;
  private String email;
  private int age;
  private int hight;
  private Integer weight;
  @Column(nullable = false)
  private Integer length;
  
  public Person(String firstname, String email) {
    super();
    this.firstname = firstname;
    this.email = email;
  }

  public long getPersonId() {
    return personId;
  }

  public void setPersonId(long personId) {
    this.personId = personId;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
}
