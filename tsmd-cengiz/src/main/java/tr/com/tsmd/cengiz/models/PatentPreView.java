package tr.com.tsmd.cengiz.models;

public class PatentPreView {

  private Long id;
  private String patentPreExplain;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public PatentPreView() {
  }

  public PatentPreView(Long id, String patentPreExplain) {
    this.id = id;
    this.patentPreExplain = patentPreExplain;
  }
  public PatentPreView(Long id, byte[] picture, String patentPreExplain) {
    this.id = id;
    this.picture = picture;
    this.patentPreExplain = patentPreExplain;
  }

  public PatentPreView(byte[] picture, String patentPreExplain, String fileName, String fileType) {
    this.picture = picture;
    this.patentPreExplain = patentPreExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public PatentPreView(Long id, String patentPreExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.patentPreExplain = patentPreExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public PatentPreView(Long id, byte[] picture, String patentPreExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.patentPreExplain = patentPreExplain;
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

  public String getPatentPreExplain() {
    return patentPreExplain;
  }

  public void setPatentPreExplain(String patentPreExplain) {
    this.patentPreExplain = patentPreExplain;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
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
