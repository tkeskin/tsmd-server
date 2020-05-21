package tr.com.tsmd.cengiz.models;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvalidationAssessment {

  private Long id;
  private String appNo;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Date createdAt;



  public InvalidationAssessment() {
  }

  public InvalidationAssessment(Long id, String appNo, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email) {
    this.id = id;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.appNo = appNo;
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
}
