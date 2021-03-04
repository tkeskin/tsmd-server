package tr.com.tsmd.cengiz.models;

public class About {

  private Long id;
  private String aboutExplain;
  private String aboutExplainEn;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public About() {
  }

  public About(Long id, String aboutExplain) {
    this.id = id;
    this.aboutExplain = aboutExplain;
  }
  public About(Long id, byte[] picture, String aboutExplain) {
    this.id = id;
    this.picture = picture;
    this.aboutExplain = aboutExplain;
  }

  public About(byte[] picture, String aboutExplain, String fileName, String fileType) {
    this.picture = picture;
    this.aboutExplain = aboutExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public About(Long id, String aboutExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.aboutExplain = aboutExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public About(Long id, byte[] picture, String aboutExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.aboutExplain = aboutExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public About(Long id, String aboutExplain, String aboutExplainEn, byte[] picture, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.aboutExplain = aboutExplain;
    this.aboutExplainEn = aboutExplainEn;
    this.picture = picture;
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

  public String getAboutExplain() {
    return aboutExplain;
  }

  public void setAboutExplain(String aboutExplain) {
    this.aboutExplain = aboutExplain;
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

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getAboutExplainEn() {
    return aboutExplainEn;
  }

  public void setAboutExplainEn(String aboutExplainEn) {
    this.aboutExplainEn = aboutExplainEn;
  }
}
