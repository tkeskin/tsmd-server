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
@Table(name = Const.TABLE_PATENTPRE_SERVICE_CHARGES, schema = Const.SCHEMA)
public class PatentPreServiceChargesEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String explain;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String explainEn;

  public PatentPreServiceChargesEntity() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }

  public String getExplainEn() {
    return explainEn;
  }

  public void setExplainEn(String explainEn) {
    this.explainEn = explainEn;
  }
}
