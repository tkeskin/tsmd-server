package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_EVALUATIONINVALIDATION_VIEW_PDF, schema = Const.SCHEMA)
public class EvaluationInvalidationViewPdfEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] pdfFile;

  private String fileName;

  private String fileType;

  private Long evaluationInvalidationViewId;


  public EvaluationInvalidationViewPdfEntity() {
  }

  public EvaluationInvalidationViewPdfEntity(byte[] pdfFile, String fileName, String fileType, Long evaluationInvalidationViewId) {
    this.pdfFile = pdfFile;
    this.fileName = fileName;
    this.fileType = fileType;
    this.evaluationInvalidationViewId = evaluationInvalidationViewId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public byte[] getPdfFile() {
    return pdfFile;
  }

  public void setPdfFile(byte[] pdfFile) {
    this.pdfFile = pdfFile;
  }

  public Long getEvaluationInvalidationViewId() {
    return evaluationInvalidationViewId;
  }

  public void setEvaluationInvalidationViewId(Long evaluationInvalidationViewId) {
    this.evaluationInvalidationViewId = evaluationInvalidationViewId;
  }
}
