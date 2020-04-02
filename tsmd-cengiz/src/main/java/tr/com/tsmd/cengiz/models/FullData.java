package tr.com.tsmd.cengiz.models;

public class FullData {

  private String Id;
  private String deferencechoose;
  private String deferenceno;
  private String deferencepriority;

  public FullData() {
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getDeferencechoose() {
    return deferencechoose;
  }

  public void setDeferencechoose(String deferencechoose) {
    this.deferencechoose = deferencechoose;
  }

  public String getDeferenceno() {
    return deferenceno;
  }

  public void setDeferenceno(String deferenceno) {
    this.deferenceno = deferenceno;
  }

  public String getDeferencepriority() {
    return deferencepriority;
  }

  public void setDeferencepriority(String deferencepriority) {
    this.deferencepriority = deferencepriority;
  }
}
