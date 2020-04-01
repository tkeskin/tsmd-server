package tr.com.tsmd.cengiz.models;

public class News {

  private Long id;
  private byte[] picture;
  private String newsTitle;
  private String newsExplain;
  private String pictureBase64;
  private String fileName;
  private String fileType;

  public News() {
  }

  public News(Long id, byte[] picture, String newsTitle, String newsExplain) {
    this.id = id;
    this.picture = picture;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
  }

  public News(byte[] picture, String newsTitle, String newsExplain,String fileName,String fileType) {
    this.picture = picture;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public News(Long id, String newsTitle, String newsExplain, String pictureBase64,String fileName, String fileType) {
    this.id = id;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public News(Long id, byte[] picture, String newsTitle, String newsExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
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

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getNewsTitle() {
    return newsTitle;
  }

  public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
  }

  public String getNewsExplain() {
    return newsExplain;
  }

  public void setNewsExplain(String newsExplain) {
    this.newsExplain = newsExplain;
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
