package tr.com.tsmd.cengiz.entity;


import tr.com.tsmd.cengiz.util.Const;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Const.TABLE_NEWS, schema = Const.SCHEMA)
public class NewsEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private byte[] picture;

  @NotBlank
  private String newsTitle;

  @NotBlank
  private String newsExplain;


  public NewsEntity() {
  }

  public NewsEntity(@NotBlank byte[] picture, @NotBlank String newsTitle, @NotBlank String newsExplain) {
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
}
