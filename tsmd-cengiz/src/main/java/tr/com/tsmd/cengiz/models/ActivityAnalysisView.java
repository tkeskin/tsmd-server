package tr.com.tsmd.cengiz.models;

public class ActivityAnalysisView {

  private Long id;
  private String activityAnalysisExplain;
  private String activityAnalysisExplainEn;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public ActivityAnalysisView() {
  }

  public ActivityAnalysisView(Long id, String activityAnalysisExplain) {
    this.id = id;
    this.activityAnalysisExplain = activityAnalysisExplain;
  }
  public ActivityAnalysisView(Long id, byte[] picture, String activityAnalysisExplain) {
    this.id = id;
    this.picture = picture;
    this.activityAnalysisExplain = activityAnalysisExplain;
  }

  public ActivityAnalysisView(byte[] picture, String activityAnalysisExplain, String fileName, String fileType) {
    this.picture = picture;
    this.activityAnalysisExplain = activityAnalysisExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public ActivityAnalysisView(Long id, String activityAnalysisExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.activityAnalysisExplain = activityAnalysisExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public ActivityAnalysisView(Long id, byte[] picture, String activityAnalysisExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.activityAnalysisExplain = activityAnalysisExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public ActivityAnalysisView(Long id, byte[] picture, String activityAnalysisExplain,String activityAnalysisExplainEn, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.activityAnalysisExplain = activityAnalysisExplain;
    this.activityAnalysisExplainEn = activityAnalysisExplainEn;
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

  public String getActivityAnalysisExplain() {
    return activityAnalysisExplain;
  }

  public void setActivityAnalysisExplain(String activityAnalysisExplain) {
    this.activityAnalysisExplain = activityAnalysisExplain;
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

  public String getActivityAnalysisExplainEn() {
    return activityAnalysisExplainEn;
  }

  public void setActivityAnalysisExplainEn(String activityAnalysisExplainEn) {
    this.activityAnalysisExplainEn = activityAnalysisExplainEn;
  }
}
