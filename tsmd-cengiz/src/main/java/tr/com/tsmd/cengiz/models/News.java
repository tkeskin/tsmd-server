package tr.com.tsmd.cengiz.models;

public class News {

  private Long id;
  private byte[] picture;
  private String newsTitle;
  private String newsExplain;
  private String pictureBase64;

  public News() {
  }

  public News(Long id, byte[] picture, String newsTitle, String newsExplain) {
    this.id = id;
    this.picture = picture;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
  }

  public News(byte[] picture, String newsTitle, String newsExplain) {
    this.picture = picture;
    this.newsTitle = newsTitle;
    this.newsExplain = newsExplain;
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
}
