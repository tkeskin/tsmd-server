package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
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

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String keyWord;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String opponent;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String technicalcomponent;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String image;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String otherpoint;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] dekont;
  private String dekontFileName;
  private String dekontFileType;

  private String legalPerson;



  public ActivityAnalysisEntity() {
  }

  public ActivityAnalysisEntity(String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email, String keyWord, String opponent, String technicalcomponent, String image, String otherpoint, String legalPerson) {
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

  public byte[] getDekont() {
    return dekont;
  }

  public void setDekont(byte[] dekont) {
    this.dekont = dekont;
  }

  public String getDekontFileName() {
    return dekontFileName;
  }

  public void setDekontFileName(String dekontFileName) {
    this.dekontFileName = dekontFileName;
  }

  public String getDekontFileType() {
    return dekontFileType;
  }

  public void setDekontFileType(String dekontFileType) {
    this.dekontFileType = dekontFileType;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }
}
