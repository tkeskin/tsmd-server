package tr.com.tsmd.cengiz.models;

public class ContactMail {

  private Long id;

  private String email;
  private String message;
  private String nameSurname;


  public ContactMail() {
  }

  public Long getId() {
    return id;
  }

  public String getNameSurname() {
    return nameSurname;
  }

  public void setNameSurname(String nameSurname) {
    this.nameSurname = nameSurname;
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
