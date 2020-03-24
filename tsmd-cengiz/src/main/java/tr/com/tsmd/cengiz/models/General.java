package tr.com.tsmd.cengiz.models;

public class General {
  private String message;
  private Long id;

  public General(String message, Long id) {
    this.message = message;
    this.id = id;
  }

  public General() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
