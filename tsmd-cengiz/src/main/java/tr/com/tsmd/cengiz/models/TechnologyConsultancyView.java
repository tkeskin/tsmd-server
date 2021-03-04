package tr.com.tsmd.cengiz.models;

public class TechnologyConsultancyView {

  private Long id;
  private String technologyConsultancyExplain;
  private String technologyConsultancyExplainEn;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public TechnologyConsultancyView() {
  }

  public TechnologyConsultancyView(Long id, String technologyConsultancyExplain) {
    this.id = id;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
  }
  public TechnologyConsultancyView(Long id, byte[] picture, String technologyConsultancyExplain) {
    this.id = id;
    this.picture = picture;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
  }

  public TechnologyConsultancyView(byte[] picture, String technologyConsultancyExplain, String fileName, String fileType) {
    this.picture = picture;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public TechnologyConsultancyView(Long id, String technologyConsultancyExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public TechnologyConsultancyView(Long id, byte[] picture, String technologyConsultancyExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public TechnologyConsultancyView(Long id, byte[] picture, String technologyConsultancyExplain,String technologyConsultancyExplainEn, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.technologyConsultancyExplain = technologyConsultancyExplain;
    this.technologyConsultancyExplainEn = technologyConsultancyExplainEn;
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

  public String getTechnologyConsultancyExplain() {
    return technologyConsultancyExplain;
  }

  public void setTechnologyConsultancyExplain(String technologyConsultancyExplain) {
    this.technologyConsultancyExplain = technologyConsultancyExplain;
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

  public String getTechnologyConsultancyExplainEn() {
    return technologyConsultancyExplainEn;
  }

  public void setTechnologyConsultancyExplainEn(String technologyConsultancyExplainEn) {
    this.technologyConsultancyExplainEn = technologyConsultancyExplainEn;
  }
}
