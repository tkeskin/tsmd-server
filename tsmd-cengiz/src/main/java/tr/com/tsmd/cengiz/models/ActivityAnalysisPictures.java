package tr.com.tsmd.cengiz.models;

public class ActivityAnalysisPictures {


  private Long id;

  private String pictureBase64;

  private String fileName;

  private String fileType;

  private Long activityAnalysisId;


  public ActivityAnalysisPictures() {
  }

  public ActivityAnalysisPictures(String fileName, String fileType, Long activityAnalysisId) {

    this.fileName = fileName;
    this.fileType = fileType;
    this.activityAnalysisId = activityAnalysisId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Long getActivityAnalysisId() {
    return activityAnalysisId;
  }

  public void setActivityAnalysisId(Long activityAnalysisId) {
    this.activityAnalysisId = activityAnalysisId;
  }

  public String getPictureBase64() {
    return pictureBase64;
  }

  public void setPictureBase64(String pictureBase64) {
    this.pictureBase64 = pictureBase64;
  }
}
