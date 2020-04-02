package tr.com.tsmd.cengiz.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import tr.com.tsmd.cengiz.entity.AuditModel;
import tr.com.tsmd.cengiz.util.Const;


public class NewsRelatedPictures extends AuditModel {

  private Long id;

  private byte[] picture;

  private String fileName;

  private String fileType;

  private Long newsId;

  private String base64Picture;


  public NewsRelatedPictures() {
  }

  public NewsRelatedPictures(Long id, byte[] picture, String fileName, String fileType, Long newsId) {
    this.id = id;
    this.picture = picture;
    this.fileName = fileName;
    this.fileType = fileType;
    this.newsId = newsId;
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

  public Long getNewsId() {
    return newsId;
  }

  public void setNewsId(Long newsId) {
    this.newsId = newsId;
  }

  public String getBase64Picture() {
    return base64Picture;
  }

  public void setBase64Picture(String base64Picture) {
    this.base64Picture = base64Picture;
  }
}
