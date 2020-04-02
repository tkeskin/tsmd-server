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
@Table(name = Const.TABLE_PATENTPRE_TABLE_DATA, schema = Const.SCHEMA)
public class PatentPreTableEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long patentPreId;
  private String deferencechoose;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String deferenceno;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String deferencepriority;


  public PatentPreTableEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPatentPreId() {
    return patentPreId;
  }

  public void setPatentPreId(Long patentPreId) {
    this.patentPreId = patentPreId;
  }

  public String getDeferencechoose() {
    return deferencechoose;
  }

  public void setDeferencechoose(String deferencechoose) {
    this.deferencechoose = deferencechoose;
  }

  public String getDeferenceno() {
    return deferenceno;
  }

  public void setDeferenceno(String deferenceno) {
    this.deferenceno = deferenceno;
  }

  public String getDeferencepriority() {
    return deferencepriority;
  }

  public void setDeferencepriority(String deferencepriority) {
    this.deferencepriority = deferencepriority;
  }
}
