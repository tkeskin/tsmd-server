package tr.com.tsmd.auth.models;

public class User {

  private String name;
  private String surname;
  private String extensionNumber;

  public User() {
  }

  public User(String name, String surname, String extensionNumber) {
    this.name = name;
    this.surname = surname;
    this.extensionNumber = extensionNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getExtensionNumber() {
    return extensionNumber;
  }

  public void setExtensionNumber(String extensionNumber) {
    this.extensionNumber = extensionNumber;
  }
}
