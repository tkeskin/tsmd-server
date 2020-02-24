package tr.com.tsmd.cengiz.models;

public class Notice {

  private Long id;
  private String picture;
  private String noticeTitle;
  private String noticeExplain;

  public Notice() {
  }

  public Notice(Long id, String picture, String noticeTitle, String noticeExplain) {
    this.id = id;
    this.picture = picture;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
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

  public String getNoticeTitle() {
    return noticeTitle;
  }

  public void setNoticeTitle(String noticeTitle) {
    this.noticeTitle = noticeTitle;
  }

  public String getNoticeExplain() {
    return noticeExplain;
  }

  public void setNoticeExplain(String noticeExplain) {
    this.noticeExplain = noticeExplain;
  }
}
