package tr.com.tsmd.cengiz.models;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ActivityAnalysis {

  private Long id;
  private String name_surname;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private String keyWord;
  private String opponent;
  private String technicalcomponent;
  private String image;
  private String otherpoint;

  private Date createdAt;
//  private String dekontBase64;

  private String legalPerson;

  private boolean kvvk;

  public ActivityAnalysis() {
  }

  public ActivityAnalysis(String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email, String keyWord, String opponent, String technicalcomponent, String image, String otherpoint, String legalPerson,boolean kvvk) {

    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.keyWord = keyWord;
    this.opponent = opponent;
    this.technicalcomponent = technicalcomponent;
    this.image = image;
    this.otherpoint = otherpoint;
    this.legalPerson = legalPerson;
    this.kvvk = kvvk;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getKeyWord() {
    return keyWord;
  }

  public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
  }

  public String getOpponent() {
    return opponent;
  }

  public void setOpponent(String opponent) {
    this.opponent = opponent;
  }

  public String getTechnicalcomponent() {
    return technicalcomponent;
  }

  public void setTechnicalcomponent(String technicalcomponent) {
    this.technicalcomponent = technicalcomponent;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getOtherpoint() {
    return otherpoint;
  }

  public void setOtherpoint(String otherpoint) {
    this.otherpoint = otherpoint;
  }


  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

//  public String getDekontBase64() {
//    return dekontBase64;
//  }
//
//  public void setDekontBase64(String dekontBase64) {
//    this.dekontBase64 = dekontBase64;
//  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public boolean isKvvk() {
    return kvvk;
  }

  public void setKvvk(boolean kvvk) {
    this.kvvk = kvvk;
  }
}
