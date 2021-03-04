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
@Table(name = Const.TABLE_VALUATION_VIEW, schema = Const.SCHEMA)
public class ValuationViewEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String valuationExplain;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String valuationExplainEn;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;


  public ValuationViewEntity() {
  }

  public ValuationViewEntity(Long id, String valuationExplain) {
    this.id = id;
    this.valuationExplain = valuationExplain;
  }


  public ValuationViewEntity(byte[] picture, @NotBlank String valuationExplain, String fileName, String fileType) {
    this.picture = picture;
    this.valuationExplain = valuationExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValuationExplain() {
    return valuationExplain;
  }

  public void setValuationExplain(String valuationExplain) {
    this.valuationExplain = valuationExplain;
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

  public String getValuationExplainEn() {
    return valuationExplainEn;
  }

  public void setValuationExplainEn(String valuationExplainEn) {
    this.valuationExplainEn = valuationExplainEn;
  }
}
