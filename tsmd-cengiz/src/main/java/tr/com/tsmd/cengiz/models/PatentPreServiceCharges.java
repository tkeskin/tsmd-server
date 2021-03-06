package tr.com.tsmd.cengiz.models;

public class PatentPreServiceCharges {

  private Long id;


  private String explain;
  private String explainEn;

  public PatentPreServiceCharges() {
  }

  public PatentPreServiceCharges(Long id, String explain) {
    this.id = id;
    this.explain = explain;
  }

  public PatentPreServiceCharges(Long id, String explain, String explainEn) {
    this.id = id;
    this.explain = explain;
    this.explainEn = explainEn;
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

  public String getExplainEn() {
    return explainEn;
  }

  public void setExplainEn(String explainEn) {
    this.explainEn = explainEn;
  }
}
