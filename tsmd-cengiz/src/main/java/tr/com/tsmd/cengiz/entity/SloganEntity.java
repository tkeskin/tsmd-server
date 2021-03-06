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
@Table(name = Const.TABLE_SLOGAN, schema = Const.SCHEMA)
public class SloganEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String slogan;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String sloganEn;


  public SloganEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }

  public String getSloganEn() {
    return sloganEn;
  }

  public void setSloganEn(String sloganEn) {
    this.sloganEn = sloganEn;
  }
}
