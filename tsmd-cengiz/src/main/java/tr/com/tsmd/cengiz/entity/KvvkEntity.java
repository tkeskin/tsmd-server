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
@Table(name = Const.TABLE_KVVK, schema = Const.SCHEMA)
public class KvvkEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] kvvk;

  private String fileName;

  private String fileType;

  private String language;


  public KvvkEntity() {
  }

  public KvvkEntity(byte[] kvvk, String fileName, String fileType) {
    this.kvvk = kvvk;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public KvvkEntity(byte[] kvvk, String fileName, String fileType,String language) {
    this.kvvk = kvvk;
    this.fileName = fileName;
    this.fileType = fileType;
    this.language = language;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getKvvk() {
    return kvvk;
  }

  public void setKvvk(byte[] kvvk) {
    this.kvvk = kvvk;
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

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
