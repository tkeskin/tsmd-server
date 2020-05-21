package tr.com.tsmd.cengiz.models;

public class TrademarkPreViewPdf {


  private Long id;

  private byte[] pdf;

  private String fileName;

  private String fileType;

  private Long trademarkPreViewId;

  private String base64Pdf;


  public TrademarkPreViewPdf() {
  }

  public TrademarkPreViewPdf(Long id, byte[] pdf, String fileName, String fileType, Long trademarkPreViewId) {
    this.id = id;
    this.pdf = pdf;
    this.fileName = fileName;
    this.fileType = fileType;
    this.trademarkPreViewId = trademarkPreViewId;
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

  public Long getTrademarkPreViewId() {
    return trademarkPreViewId;
  }

  public void setTrademarkPreViewId(Long trademarkPreViewId) {
    this.trademarkPreViewId = trademarkPreViewId;
  }

  public String getBase64Pdf() {
    return base64Pdf;
  }

  public void setBase64Pdf(String base64Pdf) {
    this.base64Pdf = base64Pdf;
  }
}
