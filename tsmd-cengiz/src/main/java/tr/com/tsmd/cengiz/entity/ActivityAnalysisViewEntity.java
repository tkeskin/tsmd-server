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
@Table(name = Const.TABLE_ACTIVITYANALYSIS_VIEW, schema = Const.SCHEMA)
public class ActivityAnalysisViewEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String activityAnalysisExplain;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;


  public ActivityAnalysisViewEntity() {
  }

  public ActivityAnalysisViewEntity(Long id, String activityAnalysisExplain) {
    this.id = id;
    this.activityAnalysisExplain = activityAnalysisExplain;
  }


  public ActivityAnalysisViewEntity(byte[] picture, @NotBlank String activityAnalysisExplain, String fileName, String fileType) {
    this.picture = picture;
    this.activityAnalysisExplain = activityAnalysisExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getActivityAnalysisExplain() {
    return activityAnalysisExplain;
  }

  public void setActivityAnalysisExplain(String activityAnalysisExplain) {
    this.activityAnalysisExplain = activityAnalysisExplain;
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
}
