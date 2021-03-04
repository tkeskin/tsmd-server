package tr.com.tsmd.cengiz.models;

public class TrademarkPreView {

  private Long id;
  private String trademarkPreExplain;
  private String trademarkPreExplainEn;
  private byte[] picture;
  private String pictureBase64;
  private String fileName;
  private String fileType;
  private byte[] nice;
  private String niceBase64;
  private String niceFileName;
  private String niceFileType;

  public TrademarkPreView() {
  }

  public TrademarkPreView(Long id, String trademarkPreExplain) {
    this.id = id;
    this.trademarkPreExplain = trademarkPreExplain;
  }
  public TrademarkPreView(Long id, byte[] picture, String trademarkPreExplain) {
    this.id = id;
    this.picture = picture;
    this.trademarkPreExplain = trademarkPreExplain;
  }

  public TrademarkPreView(byte[] picture, String trademarkPreExplain, String fileName, String fileType) {
    this.picture = picture;
    this.trademarkPreExplain = trademarkPreExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public TrademarkPreView(Long id, String trademarkPreExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.trademarkPreExplain = trademarkPreExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public TrademarkPreView(Long id, byte[] picture, String trademarkPreExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.trademarkPreExplain = trademarkPreExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public TrademarkPreView(Long id, String trademarkPreExplain, byte[] picture, String pictureBase64, String fileName, String fileType, byte[] nice, String niceBase64, String niceFileName, String niceFileType) {
    this.id = id;
    this.trademarkPreExplain = trademarkPreExplain;
    this.picture = picture;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
    this.nice = nice;
    this.niceBase64 = niceBase64;
    this.niceFileName = niceFileName;
    this.niceFileType = niceFileType;
  }

  public TrademarkPreView(Long id, String trademarkPreExplain,String trademarkPreExplainEn, byte[] picture, String pictureBase64, String fileName, String fileType, byte[] nice, String niceBase64, String niceFileName, String niceFileType) {
    this.id = id;
    this.trademarkPreExplain = trademarkPreExplain;
    this.trademarkPreExplainEn = trademarkPreExplainEn;
    this.picture = picture;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
    this.nice = nice;
    this.niceBase64 = niceBase64;
    this.niceFileName = niceFileName;
    this.niceFileType = niceFileType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTrademarkPreExplain() {
    return trademarkPreExplain;
  }

  public void setTrademarkPreExplain(String trademarkPreExplain) {
    this.trademarkPreExplain = trademarkPreExplain;
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

  public byte[] getNice() {
    return nice;
  }

  public void setNice(byte[] nice) {
    this.nice = nice;
  }

  public String getNiceBase64() {
    return niceBase64;
  }

  public void setNiceBase64(String niceBase64) {
    this.niceBase64 = niceBase64;
  }

  public String getNiceFileName() {
    return niceFileName;
  }

  public void setNiceFileName(String niceFileName) {
    this.niceFileName = niceFileName;
  }

  public String getNiceFileType() {
    return niceFileType;
  }

  public void setNiceFileType(String niceFileType) {
    this.niceFileType = niceFileType;
  }

  public String getTrademarkPreExplainEn() {
    return trademarkPreExplainEn;
  }

  public void setTrademarkPreExplainEn(String trademarkPreExplainEn) {
    this.trademarkPreExplainEn = trademarkPreExplainEn;
  }
}
