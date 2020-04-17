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
@Table(name = Const.TABLE_TRADEMARKPRE_VIEW, schema = Const.SCHEMA)
public class TrademarkPreViewEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String trademarkPreExplain;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String fileName;

  private String fileType;


  public TrademarkPreViewEntity() {
  }

  public TrademarkPreViewEntity(Long id, String trademarkPreExplain) {
    this.id = id;
    this.trademarkPreExplain = trademarkPreExplain;
  }


  public TrademarkPreViewEntity(byte[] picture, @NotBlank String trademarkPreExplain, String fileName, String fileType) {
    this.picture = picture;
    this.trademarkPreExplain = trademarkPreExplain;
    this.fileName = fileName;
    this.fileType = fileType;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTrademarkPreExplain() {
    return trademarkPreExplain;
  }

  public void setTrademarkPreExplain(String trademarkPreExplain) {
    this.trademarkPreExplain = trademarkPreExplain;
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
