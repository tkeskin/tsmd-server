package tr.com.tsmd.cengiz.models;

public class TrademarkPreServiceCharges {

  private Long id;


  private String explain;

  public TrademarkPreServiceCharges() {
  }

  public TrademarkPreServiceCharges(Long id, String explain) {
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
