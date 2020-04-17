package tr.com.tsmd.cengiz.models;

public class CompanyProfile {

  private Long id;
  private byte[] picture;
  private String companyPresident;
  private String companyProfileExplain;
  private String pictureBase64;
  private String fileName;
  private String fileType;


  public CompanyProfile() {
  }

  public CompanyProfile(Long id, byte[] picture, String companyPresident, String companyProfileExplain) {
    this.id = id;
    this.picture = picture;
    this.companyPresident = companyPresident;
    this.companyProfileExplain = companyProfileExplain;
  }

  public CompanyProfile(byte[] picture, String companyPresident, String companyProfileExplain, String fileName, String fileType) {
    this.picture = picture;
    this.companyPresident = companyPresident;
    this.companyProfileExplain = companyProfileExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }



  public CompanyProfile(Long id, String companyPresident, String companyProfileExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.companyPresident = companyPresident;
    this.companyProfileExplain = companyProfileExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public CompanyProfile(Long id, byte[] picture, String companyPresident, String companyProfileExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.companyPresident = companyPresident;
    this.companyProfileExplain = companyProfileExplain;
    this.pictureBase64 = pictureBase64;
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

  public String getPictureBase64() {
    return pictureBase64;
  }

  public void setPictureBase64(String pictureBase64) {
    this.pictureBase64 = pictureBase64;
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
}
