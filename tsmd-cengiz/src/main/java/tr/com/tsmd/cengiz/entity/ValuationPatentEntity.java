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
@Table(name = Const.TABLE_VALUATIONPATENT, schema = Const.SCHEMA)
public class ValuationPatentEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String address;

  private String name_surname;
  private String tc;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private String legalPerson;


  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentpurpose;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentappno;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentcountry;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentmarket;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String patentcontribution;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentsector;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String patentothersector;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String marketshare;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String percentageturnover;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String overseasmarketshare;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String exportcountry;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String exportturnover;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String royaltyrate;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String competingmarketshare;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String competitordate;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String competinggrowthrate;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String turnovertarget;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String turnoverpercent;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String incomepercent;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String license;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String licenseroyalt;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String contract;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String advertisement;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String totalexpenditure;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String spending;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String developmentspending;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String worldspending;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String caseexpense;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String countryoutside;

  @Lob
  @Type(type="org.hibernate.type.TextType")
  private String europeanunio;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] dekont;
  private String dekontFileName;
  private String dekontFileType;

  private String licenseChoose;

  private boolean kvvk;


  public ValuationPatentEntity() {
  }

  public ValuationPatentEntity(String address, String patentpurpose, String patentappno, String patentcountry, String patentmarket, String patentsector, String patentothersector, String marketshare, String overseasmarketshare, String exportcountry, String exportturnover, String competingmarketshare, String competitordate, String turnovertarget, String turnoverpercent, String incomepercent, String license, String licenseroyalt, String contract, String advertisement, String totalexpenditure, String spending, String worldspending, String caseexpense, String countryoutside, String europeanunio, String name_surname, String tc, String tel, @NotBlank @Size(max = 50) @Email String email,String legalPerson,String licenseChoose, boolean kvvk) {
    this.address = address;
    this.patentpurpose = patentpurpose;
    this.patentappno = patentappno;
    this.patentcountry = patentcountry;
    this.patentmarket = patentmarket;
//    this.patentcontribution = patentcontribution;
    this.patentsector = patentsector;
    this.patentothersector = patentothersector;
    this.marketshare = marketshare;
//    this.percentageturnover = percentageturnover;
    this.overseasmarketshare = overseasmarketshare;
    this.exportcountry = exportcountry;
    this.exportturnover = exportturnover;
//    this.royaltyrate = royaltyrate;
    this.competingmarketshare = competingmarketshare;
    this.competitordate = competitordate;
//    this.competinggrowthrate = competinggrowthrate;
    this.turnovertarget = turnovertarget;
    this.turnoverpercent = turnoverpercent;
    this.incomepercent = incomepercent;
    this.license = license;
    this.licenseroyalt = licenseroyalt;
    this.contract = contract;
    this.advertisement = advertisement;
    this.totalexpenditure = totalexpenditure;
    this.spending = spending;
//    this.developmentspending = developmentspending;
    this.worldspending = worldspending;
    this.caseexpense = caseexpense;
    this.countryoutside = countryoutside;
    this.europeanunio = europeanunio;
    this.name_surname = name_surname;
    this.tc = tc;
    this.tel = tel;
    this.email = email;
    this.legalPerson = legalPerson;
    this.licenseChoose = licenseChoose;
    this.kvvk = kvvk;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPatentpurpose() {
    return patentpurpose;
  }

  public void setPatentpurpose(String patentpurpose) {
    this.patentpurpose = patentpurpose;
  }

  public String getPatentappno() {
    return patentappno;
  }

  public void setPatentappno(String patentappno) {
    this.patentappno = patentappno;
  }

  public String getPatentcountry() {
    return patentcountry;
  }

  public void setPatentcountry(String patentcountry) {
    this.patentcountry = patentcountry;
  }

  public String getPatentmarket() {
    return patentmarket;
  }

  public void setPatentmarket(String patentmarket) {
    this.patentmarket = patentmarket;
  }

  public String getPatentsector() {
    return patentsector;
  }

  public void setPatentsector(String patentsector) {
    this.patentsector = patentsector;
  }

  public String getPatentothersector() {
    return patentothersector;
  }

  public void setPatentothersector(String patentothersector) {
    this.patentothersector = patentothersector;
  }

  public String getMarketshare() {
    return marketshare;
  }

  public void setMarketshare(String marketshare) {
    this.marketshare = marketshare;
  }

  public String getOverseasmarketshare() {
    return overseasmarketshare;
  }

  public void setOverseasmarketshare(String overseasmarketshare) {
    this.overseasmarketshare = overseasmarketshare;
  }

  public String getExportcountry() {
    return exportcountry;
  }

  public void setExportcountry(String exportcountry) {
    this.exportcountry = exportcountry;
  }

  public String getExportturnover() {
    return exportturnover;
  }

  public void setExportturnover(String exportturnover) {
    this.exportturnover = exportturnover;
  }

  public String getCompetingmarketshare() {
    return competingmarketshare;
  }

  public void setCompetingmarketshare(String competingmarketshare) {
    this.competingmarketshare = competingmarketshare;
  }

  public String getCompetitordate() {
    return competitordate;
  }

  public void setCompetitordate(String competitordate) {
    this.competitordate = competitordate;
  }

  public String getTurnovertarget() {
    return turnovertarget;
  }

  public void setTurnovertarget(String turnovertarget) {
    this.turnovertarget = turnovertarget;
  }

  public String getTurnoverpercent() {
    return turnoverpercent;
  }

  public void setTurnoverpercent(String turnoverpercent) {
    this.turnoverpercent = turnoverpercent;
  }

  public String getIncomepercent() {
    return incomepercent;
  }

  public void setIncomepercent(String incomepercent) {
    this.incomepercent = incomepercent;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getLicenseroyalt() {
    return licenseroyalt;
  }

  public void setLicenseroyalt(String licenseroyalt) {
    this.licenseroyalt = licenseroyalt;
  }

  public String getContract() {
    return contract;
  }

  public void setContract(String contract) {
    this.contract = contract;
  }

  public String getAdvertisement() {
    return advertisement;
  }

  public void setAdvertisement(String advertisement) {
    this.advertisement = advertisement;
  }

  public String getTotalexpenditure() {
    return totalexpenditure;
  }

  public void setTotalexpenditure(String totalexpenditure) {
    this.totalexpenditure = totalexpenditure;
  }

  public String getSpending() {
    return spending;
  }

  public void setSpending(String spending) {
    this.spending = spending;
  }

  public String getWorldspending() {
    return worldspending;
  }

  public void setWorldspending(String worldspending) {
    this.worldspending = worldspending;
  }

  public String getCaseexpense() {
    return caseexpense;
  }

  public void setCaseexpense(String caseexpense) {
    this.caseexpense = caseexpense;
  }

  public String getCountryoutside() {
    return countryoutside;
  }

  public void setCountryoutside(String countryoutside) {
    this.countryoutside = countryoutside;
  }

  public String getEuropeanunio() {
    return europeanunio;
  }

  public void setEuropeanunio(String europeanunio) {
    this.europeanunio = europeanunio;
  }

  public byte[] getDekont() {
    return dekont;
  }

  public void setDekont(byte[] dekont) {
    this.dekont = dekont;
  }

  public String getDekontFileName() {
    return dekontFileName;
  }

  public void setDekontFileName(String dekontFileName) {
    this.dekontFileName = dekontFileName;
  }

  public String getDekontFileType() {
    return dekontFileType;
  }

  public void setDekontFileType(String dekontFileType) {
    this.dekontFileType = dekontFileType;
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

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getLicenseChoose() {
    return licenseChoose;
  }

  public void setLicenseChoose(String licenseChoose) {
    this.licenseChoose = licenseChoose;
  }

  public boolean isKvvk() {
    return kvvk;
  }

  public void setKvvk(boolean kvvk) {
    this.kvvk = kvvk;
  }
}
