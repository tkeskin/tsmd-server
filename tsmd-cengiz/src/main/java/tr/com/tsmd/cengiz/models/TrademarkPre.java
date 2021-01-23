package tr.com.tsmd.cengiz.models;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TrademarkPre {

  private Long id;
  private String trademarktype;
  private String trademarkimage;
  private String trademarktext;
  private String trademarkclass;
  private String name_surname;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Date createdAt;
  private String dekontBase64;
  private String dekontFileType;
  private String trademarkImageFileType;

  private String legalPerson;
  private String trademarkItemList;
  private boolean kvvk;

  public TrademarkPre() {
  }

  public TrademarkPre(Long id, String trademarktype, String trademarkimage, String trademarktext, String trademarkclass, String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email, String legalPerson, String trademarkItemList,
                      boolean kvvk) {
    this.id = id;
    this.trademarktype = trademarktype;
    this.trademarkimage = trademarkimage;
    this.trademarktext = trademarktext;
    this.trademarkclass = trademarkclass;
    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.legalPerson = legalPerson;
    this.trademarkItemList = trademarkItemList;
    this.kvvk = kvvk;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTrademarktype() {
    return trademarktype;
  }

  public void setTrademarktype(String trademarktype) {
    this.trademarktype = trademarktype;
  }

  public String getTrademarkimage() {
    return trademarkimage;
  }

  public void setTrademarkimage(String trademarkimage) {
    this.trademarkimage = trademarkimage;
  }

  public String getTrademarktext() {
    return trademarktext;
  }

  public void setTrademarktext(String trademarktext) {
    this.trademarktext = trademarktext;
  }

  public String getTrademarkclass() {
    return trademarkclass;
  }

  public void setTrademarkclass(String trademarkclass) {
    this.trademarkclass = trademarkclass;
  }

  public String getName_surname() {
    return name_surname;
  }

  public void setName_surname(String name_surname) {
    this.name_surname = name_surname;
  }

  public String getTc() {
    return tc;
  }

  public void setTc(String tc) {
    this.tc = tc;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDekontBase64() {
    return dekontBase64;
  }

  public void setDekontBase64(String dekontBase64) {
    this.dekontBase64 = dekontBase64;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getTrademarkItemList() {
    return trademarkItemList;
  }

  public void setTrademarkItemList(String trademarkItemList) {
    this.trademarkItemList = trademarkItemList;
  }

  public boolean isKvvk() {
    return kvvk;
  }

  public void setKvvk(boolean kvvk) {
    this.kvvk = kvvk;
  }

  public String getDekontFileType() {
    return dekontFileType;
  }

  public void setDekontFileType(String dekontFileType) {
    this.dekontFileType = dekontFileType;
  }

  public String getTrademarkImageFileType() {
    return trademarkImageFileType;
  }

  public void setTrademarkImageFileType(String trademarkImageFileType) {
    this.trademarkImageFileType = trademarkImageFileType;
  }
}
