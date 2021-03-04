package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_GENERATOR_APP_TRAKING_NO, schema = Const.SCHEMA)
public class GeneratorTrademarkPreEntity extends AuditModel {

  @Id
  @GeneratedValue(generator = "string_id",strategy = GenerationType.AUTO)
  @GenericGenerator(name = "string_id",
      parameters = @Parameter(name = "prefix", value = "MA"),
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
