package tr.com.tsmd.cengiz.models;

public class EvaluationInvalidationView {

  private Long id;
  private String evaluationInvalidationExplain;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public EvaluationInvalidationView() {
  }

  public EvaluationInvalidationView(Long id, String evaluationInvalidationExplain) {
    this.id = id;
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
  }
  public EvaluationInvalidationView(Long id, byte[] picture, String evaluationInvalidationExplain) {
    this.id = id;
    this.picture = picture;
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
  }

  public EvaluationInvalidationView(byte[] picture, String evaluationInvalidationExplain, String fileName, String fileType) {
    this.picture = picture;
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public EvaluationInvalidationView(Long id, String evaluationInvalidationExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public EvaluationInvalidationView(Long id, byte[] picture, String evaluationInvalidationExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
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

  public String getEvaluationInvalidationExplain() {
    return evaluationInvalidationExplain;
  }

  public void setEvaluationInvalidationExplain(String evaluationInvalidationExplain) {
    this.evaluationInvalidationExplain = evaluationInvalidationExplain;
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
