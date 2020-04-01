package tr.com.tsmd.cengiz.models;

public class Notice {

  private Long id;
  private byte[] picture;
  private String noticeTitle;
  private String noticeExplain;
  private String pictureBase64;
  private String fileName;
  private String fileType;


  public Notice() {
  }

  public Notice(Long id, byte[] picture, String noticeTitle, String noticeExplain) {
    this.id = id;
    this.picture = picture;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
  }

  public Notice(byte[] picture, String noticeTitle, String noticeExplain, String fileName, String fileType) {
    this.picture = picture;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public Notice(Long id, String noticeTitle, String noticeExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
    this.pictureBase64 = pictureBase64;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public Notice(Long id, byte[] picture, String noticeTitle, String noticeExplain, String pictureBase64, String fileName, String fileType) {
    this.id = id;
    this.picture = picture;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
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
