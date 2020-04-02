package tr.com.tsmd.cengiz.entity;


import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Const.TABLE_NOTICE, schema = Const.SCHEMA)
public class NoticeEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  @NotBlank
  private String noticeTitle;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String noticeExplain;

  private String fileName;

  private String fileType;

  public NoticeEntity() {
  }

  public NoticeEntity(byte[] picture, @NotBlank String noticeTitle, @NotBlank String noticeExplain, String fileName, String fileType) {
    this.picture = picture;
    this.noticeTitle = noticeTitle;
    this.noticeExplain = noticeExplain;
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
