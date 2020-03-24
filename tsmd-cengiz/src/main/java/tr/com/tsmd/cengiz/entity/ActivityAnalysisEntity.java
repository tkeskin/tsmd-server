package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_ACTIVITYANALYSIS, schema = Const.SCHEMA)
public class ActivityAnalysisEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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



  public ActivityAnalysisEntity() {
  }

  public ActivityAnalysisEntity(String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email, String keyWord, String opponent, String technicalcomponent, String image, String otherpoint) {
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
}
