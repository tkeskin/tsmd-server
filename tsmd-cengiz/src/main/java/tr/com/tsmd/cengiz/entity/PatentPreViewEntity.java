package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_PATENTPRE_VIEW, schema = Const.SCHEMA)
public class PatentPreViewEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentPreExplain;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentPreExplainEn;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;


  public PatentPreViewEntity() {
  }

  public PatentPreViewEntity(Long id, String patentPreExplain) {
    this.id = id;
    this.patentPreExplain = patentPreExplain;
  }


  public PatentPreViewEntity(byte[] picture, @NotBlank String patentPreExplain, String fileName, String fileType) {
    this.picture = picture;
    this.patentPreExplain = patentPreExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPatentPreExplain() {
    return patentPreExplain;
  }

  public void setPatentPreExplain(String patentPreExplain) {
    this.patentPreExplain = patentPreExplain;
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

  public String getPatentPreExplainEn() {
    return patentPreExplainEn;
  }

  public void setPatentPreExplainEn(String patentPreExplainEn) {
    this.patentPreExplainEn = patentPreExplainEn;
  }
}
