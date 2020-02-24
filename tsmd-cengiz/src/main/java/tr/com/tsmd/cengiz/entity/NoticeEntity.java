package tr.com.tsmd.cengiz.entity;


import tr.com.tsmd.cengiz.util.Const;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Const.TABLE_NOTICE, schema = Const.SCHEMA)
public class NoticeEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String picture;

  @NotBlank
  private String noticeTitle;

  @NotBlank
  private String noticeExplain;



  public NoticeEntity() {
  }

  public NoticeEntity(Long id, String picture, String username, String noticeTitle, String noticeExplain) {
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
