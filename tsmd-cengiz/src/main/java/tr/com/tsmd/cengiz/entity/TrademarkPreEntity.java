package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_TRADEMARKPRE, schema = Const.SCHEMA)
public class TrademarkPreEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String trademarktype;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String trademarkimage;

  private String trademarkimagename;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] trademarkimagebyte;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String trademarktext;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String trademarkclass;
  private String name_surname;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] dekont;
  private String dekontName;
  private String dekontFileType;



  public TrademarkPreEntity() {
  }

  public TrademarkPreEntity( String trademarktype, String trademarkimage, String trademarktext, String trademarkclass, String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email) {

    this.trademarktype = trademarktype;
    this.trademarkimage = trademarkimage;
    this.trademarktext = trademarktext;
    this.trademarkclass = trademarkclass;
    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTrademarktype() {
    return trademarktype;
  }

  public void setTrademarktype(String trademarktype) {
    this.trademarktype = trademarktype;
  }

  public String getTrademarkimage() {
    return trademarkimage;
  }

  public void setTrademarkimage(String trademarkimage) {
    this.trademarkimage = trademarkimage;
  }

  public String getTrademarktext() {
    return trademarktext;
  }

  public void setTrademarktext(String trademarktext) {
    this.trademarktext = trademarktext;
  }

  public String getTrademarkclass() {
    return trademarkclass;
  }

  public void setTrademarkclass(String trademarkclass) {
    this.trademarkclass = trademarkclass;
  }

  public String getName_surname() {
    return name_surname;
  }

  public void setName_surname(String name_surname) {
    this.name_surname = name_surname;
  }

  public String getTc() {
    return tc;
  }

  public void setTc(String tc) {
    this.tc = tc;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTrademarkimagename() {
    return trademarkimagename;
  }

  public void setTrademarkimagename(String trademarkimagename) {
    this.trademarkimagename = trademarkimagename;
  }

  public byte[] getTrademarkimagebyte() {
    return trademarkimagebyte;
  }

  public void setTrademarkimagebyte(byte[] trademarkimagebyte) {
    this.trademarkimagebyte = trademarkimagebyte;
  }


  public byte[] getDekont() {
    return dekont;
  }

  public void setDekont(byte[] dekont) {
    this.dekont = dekont;
  }

  public String getDekontName() {
    return dekontName;
  }

  public void setDekontName(String dekontName) {
    this.dekontName = dekontName;
  }

  public String getDekontFileType() {
    return dekontFileType;
  }

  public void setDekontFileType(String dekontFileType) {
    this.dekontFileType = dekontFileType;
  }
}
