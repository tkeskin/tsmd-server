package tr.com.tsmd.cengiz.models;

public class EvaluationInvalidationViewPdf {


  private Long id;

  private byte[] pdf;

  private String fileName;

  private String fileType;

  private Long evaluationInvalidationViewId;

  private String base64Pdf;


  public EvaluationInvalidationViewPdf() {
  }

  public EvaluationInvalidationViewPdf(Long id, byte[] pdf, String fileName, String fileType, Long evaluationInvalidationViewId) {
    this.id = id;
    this.pdf = pdf;
    this.fileName = fileName;
    this.fileType = fileType;
    this.evaluationInvalidationViewId = evaluationInvalidationViewId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getPdf() {
    return pdf;
  }

  public void setPdf(byte[] pdf) {
    this.pdf = pdf;
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

  public Long getEvaluationInvalidationViewId() {
    return evaluationInvalidationViewId;
  }

  public void setEvaluationInvalidationViewId(Long evaluationInvalidationViewId) {
    this.evaluationInvalidationViewId = evaluationInvalidationViewId;
  }

  public String getBase64Pdf() {
    return base64Pdf;
  }

  public void setBase64Pdf(String base64Pdf) {
    this.base64Pdf = base64Pdf;
  }
}
