package tr.com.tsmd.cengiz.models;

public class PatentPreRelatedPictures {


  private Long id;

  private String pictureBase64;

  private String fileName;

  private String fileType;

  private Long patentPreId;


  public PatentPreRelatedPictures() {
  }

  public PatentPreRelatedPictures( String fileName, String fileType, Long patentPreId) {
    this.fileName = fileName;
    this.fileType = fileType;
    this.patentPreId = patentPreId;
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

  public Long getPatentPreId() {
    return patentPreId;
  }

  public void setPatentPreId(Long patentPreId) {
    this.patentPreId = patentPreId;
  }

  public String getPictureBase64() {
    return pictureBase64;
  }

  public void setPictureBase64(String pictureBase64) {
    this.pictureBase64 = pictureBase64;
  }
}
