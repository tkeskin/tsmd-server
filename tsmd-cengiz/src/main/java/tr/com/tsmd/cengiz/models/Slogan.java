package tr.com.tsmd.cengiz.models;


import tr.com.tsmd.cengiz.entity.AuditModel;


public class Slogan extends AuditModel {

  private Long id;

  private String slogan;


  public Slogan() {
  }

  public Slogan(Long id, String slogan) {
    this.id = id;
    this.slogan = slogan;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }
}
