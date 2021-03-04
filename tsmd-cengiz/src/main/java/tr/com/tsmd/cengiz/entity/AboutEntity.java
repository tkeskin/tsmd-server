package tr.com.tsmd.cengiz.entity;


import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Const.TABLE_ABOUT, schema = Const.SCHEMA)
public class AboutEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String aboutExplain;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String aboutExplainEn;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;


  public AboutEntity() {
  }

  public AboutEntity(Long id, String aboutExplain) {
    this.id = id;
    this.aboutExplain = aboutExplain;
  }


  public AboutEntity(byte[] picture, @NotBlank String aboutExplain, String fileName, String fileType) {
    this.picture = picture;
    this.aboutExplain = aboutExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAboutExplain() {
    return aboutExplain;
  }

  public void setAboutExplain(String aboutExplain) {
    this.aboutExplain = aboutExplain;
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

  public String getAboutExplainEn() {
    return aboutExplainEn;
  }

  public void setAboutExplainEn(String aboutExplainEn) {
    this.aboutExplainEn = aboutExplainEn;
  }
}
