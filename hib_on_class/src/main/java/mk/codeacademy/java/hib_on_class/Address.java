package mk.codeacademy.java.hib_on_class;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
  private String city;
  private String street; 
}