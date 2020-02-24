package tr.com.tsmd.cengiz.models;

public class News {

  private Long id;
  private String picture;
  private String newsTitle;
  private String newsExplain;

  public News() {
  }

  public News(Long id, String picture, String newsTitle, String newsExplain) {
    this.id = id;
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

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
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
}
