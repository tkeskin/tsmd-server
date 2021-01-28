package tr.com.tsmd.cengiz.models;

public class PatentPreServiceCharges {

  private Long id;


  private String explain;

  public PatentPreServiceCharges() {
  }

  public PatentPreServiceCharges(Long id, String explain) {
    this.id = id;
    this.explain = explain;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }
}
