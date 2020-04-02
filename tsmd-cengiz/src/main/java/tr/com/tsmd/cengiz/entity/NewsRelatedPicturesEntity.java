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
@Table(name = Const.TABLE_NEWS_RELATED_PICTURES, schema = Const.SCHEMA)
public class NewsRelatedPicturesEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;

  private Long newsId;


  public NewsRelatedPicturesEntity() {
  }

  public NewsRelatedPicturesEntity(byte[] picture, String fileName, String fileType, Long newsId) {
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
}
