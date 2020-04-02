package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_CONTACT_MAIL, schema = Const.SCHEMA)
public class ContactMailEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;



  @Email
  private String email;

  private String nameSurname;

  @NotBlank
  private String message;

  public ContactMailEntity() {
  }

  public ContactMailEntity(@Email String email, String nameSurname, @NotBlank String message) {
    this.email = email;
    this.nameSurname = nameSurname;
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
