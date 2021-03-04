package tr.com.tsmd.cengiz.models;


import tr.com.tsmd.cengiz.entity.AuditModel;


public class Slogan extends AuditModel {

  private Long id;

  private String slogan;
  private String sloganEn;


  public Slogan() {
  }

  public Slogan(Long id, String slogan) {
    this.id = id;
    this.slogan = slogan;
  }

  public Slogan(Long id, String slogan, String sloganEn) {
    this.id = id;
    this.slogan = slogan;
    this.sloganEn = sloganEn;
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

  public String getSloganEn() {
    return sloganEn;
  }

  public void setSloganEn(String sloganEn) {
    this.sloganEn = sloganEn;
  }
}
