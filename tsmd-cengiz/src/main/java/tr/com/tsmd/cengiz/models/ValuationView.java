package tr.com.tsmd.cengiz.models;

public class ValuationView {

  private Long id;
  private String valuationExplain;
  private String valuationExplainEn;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public ValuationView() {
  }

  public ValuationView(Long id, String valuationExplain) {
    this.id = id;
    this.valuationExplain = valuationExplain;
  }
  public ValuationView(Long id, byte[] picture, String valuationExplain) {
    this.id = id;
    this.picture = picture;
    this.valuationExplain = valuationExplain;
  }

  public ValuationView(byte[] picture, String valuationExplain, String fileName, String fileType) {
    this.picture = picture;
    this.valuationExplain = valuationExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public ValuationView(Long id, String valuationExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.valuationExplain = valuationExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public ValuationView(Long id, byte[] picture, String valuationExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.valuationExplain = valuationExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public ValuationView(Long id, byte[] picture, String valuationExplain,String valuationExplainEn,String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.valuationExplain = valuationExplain;
    this.valuationExplainEn = valuationExplainEn;
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

  public String getValuationExplain() {
    return valuationExplain;
  }

  public void setValuationExplain(String valuationExplain) {
    this.valuationExplain = valuationExplain;
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

  public String getValuationExplainEn() {
    return valuationExplainEn;
  }

  public void setValuationExplainEn(String valuationExplainEn) {
    this.valuationExplainEn = valuationExplainEn;
  }
}
