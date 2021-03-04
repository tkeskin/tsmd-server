package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_COMPANY_PROFILE, schema = Const.SCHEMA)
public class CompanyProfileEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  @NotBlank
  private String companyPresident;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String companyProfileExplain;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String companyProfileExplainEn;

  private String fileName;

  private String fileType;


  public CompanyProfileEntity() {
  }

  public CompanyProfileEntity(byte[] picture, @NotBlank String companyPresident, @NotBlank String companyProfileExplain, String fileName, String fileType) {
    this.picture = picture;
    this.companyPresident = companyPresident;
    this.companyProfileExplain = companyProfileExplain;
    this.fileName = fileName;
    this.fileType = fileType;

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getCompanyPresident() {
    return companyPresident;
  }

  public void setCompanyPresident(String companyPresident) {
    this.companyPresident = companyPresident;
  }

  public String getCompanyProfileExplain() {
    return companyProfileExplain;
  }

  public void setCompanyProfileExplain(String companyProfileExplain) {
    this.companyProfileExplain = companyProfileExplain;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getCompanyProfileExplainEn() {
    return companyProfileExplainEn;
  }

  public void setCompanyProfileExplainEn(String companyProfileExplainEn) {
    this.companyProfileExplainEn = companyProfileExplainEn;
  }
}
