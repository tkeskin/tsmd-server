package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_GENERATOR_APP_TRAKING_NO, schema = Const.SCHEMA)
public class GeneratorPatentPreEntity extends AuditModel {

  @Id
  @GeneratedValue(generator = "string_id",strategy = GenerationType.AUTO)
  @GenericGenerator(name = "string_id",
      parameters = @Parameter(name = "prefix", value = "PA"),
      strategy = "tr.com.tsmd.cengiz.util.StringPrefixedSequenceIdGenerator")
  private String id;

  private String servicesType;

  private String type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getServicesType() {
    return servicesType;
  }

  public void setServicesType(String servicesType) {
    this.servicesType = servicesType;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
