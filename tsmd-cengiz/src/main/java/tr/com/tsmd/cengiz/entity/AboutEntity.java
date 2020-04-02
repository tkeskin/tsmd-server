package tr.com.tsmd.cengiz.entity;


import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Const.TABLE_ABOUT, schema = Const.SCHEMA)
public class AboutEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String aboutExplain;



  public AboutEntity() {
  }

  public AboutEntity(Long id, String aboutExplain) {
    this.id = id;
    this.aboutExplain = aboutExplain;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAboutExplain() {
    return aboutExplain;
  }

  public void setAboutExplain(String aboutExplain) {
    this.aboutExplain = aboutExplain;
  }
}
