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
@Table(name = Const.TABLE_INVALIDATIONASSESSMENT, schema = Const.SCHEMA)
public class InvalidationAssessmentEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String appNo;
  private String name_surname;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private boolean kvvk;

  private String trackingNumber;


  public InvalidationAssessmentEntity() {
  }

  public InvalidationAssessmentEntity(String appNo, String name_surname, String tc,
                                      String address, String tel,
                                      @NotBlank @Size(max = 50) @Email String email,
                                      boolean kvvk) {

    this.appNo = appNo;
    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.kvvk = kvvk;
  }

  public InvalidationAssessmentEntity(String appNo, String name_surname, String tc,
                                      String address, String tel,
                                      @NotBlank @Size(max = 50) @Email String email,
                                      boolean kvvk , String trackingNumber) {

    this.appNo = appNo;
    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.kvvk = kvvk;
    this.trackingNumber = trackingNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getAppNo() {
    return appNo;
  }

  public void setAppNo(String appNo) {
    this.appNo = appNo;
  }

  public boolean isKvvk() {
    return kvvk;
  }

  public void setKvvk(boolean kvvk) {
    this.kvvk = kvvk;
  }

  public String getName_surname() {
    return name_surname;
  }

  public void setName_surname(String name_surname) {
    this.name_surname = name_surname;
  }

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }
}
