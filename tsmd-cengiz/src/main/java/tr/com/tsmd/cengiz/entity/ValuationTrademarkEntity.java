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
@Table(name = Const.TABLE_VALUATIONTRADEMARK, schema = Const.SCHEMA)
public class ValuationTrademarkEntity extends AuditModel {

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
  private String valuationTrademarkAppNo;
  private String licenseChoose;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String trademarkclass;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String trademarkpurpose;

//  @Lob
//  @Type(type="org.hibernate.type.TextType")
//  private String registrationdate;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String commonusage;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String targetcountry;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String trademarktime;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String markettime;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String trademarkcontribution;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String mainsector;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String othersector;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String marketshare;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String overseasmarketshare;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String exportcountry;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String turnoverpercent;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String competingmarketshare;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String markethistory;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String turnovertarget;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String trademarkturnoverpercent;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String incomeincreasepercent;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String license;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String licenseroyalt;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String contract;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String advertisement;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String totalexpenditure;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String countryoutside;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String europeanunion;


  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] dekont;
  private String dekontFileName;
  private String dekontFileType;
  private boolean kvvk;
  private String trackingNumber;


  public ValuationTrademarkEntity() {
  }

  public ValuationTrademarkEntity(String address, String trademarkpurpose, String commonusage, String targetcountry, String trademarktime, String markettime, String trademarkcontribution, String mainsector, String othersector, String marketshare, String overseasmarketshare, String exportcountry, String turnoverpercent, String competingmarketshare, String markethistory, String turnovertarget, String trademarkturnoverpercent, String incomeincreasepercent, String license, String licenseroyalt, String contract, String advertisement, String totalexpenditure, String countryoutside, String europeanunion, String name_surname, String tc, String tel, @NotBlank @Size(max = 50) @Email String email, String legalPerson, String valuationTrademarkAppNo, String licenseChoose, boolean kvvk) {
    this.address = address;
    this.trademarkpurpose = trademarkpurpose;
    this.commonusage = commonusage;
//    this.dominanttrademark = dominanttrademark;
    this.targetcountry = targetcountry;
    this.trademarktime = trademarktime;
    this.markettime = markettime;
    this.trademarkcontribution = trademarkcontribution;
//    this.incomepercent = incomepercent;
    this.mainsector = mainsector;
    this.othersector = othersector;
    this.marketshare = marketshare;
//    this.totalturnover = totalturnover;
    this.overseasmarketshare = overseasmarketshare;
    this.exportcountry = exportcountry;
    this.turnoverpercent = turnoverpercent;
//    this.percentroyalt = percentroyalt;
    this.competingmarketshare = competingmarketshare;
    this.markethistory = markethistory;
//    this.growthrate = growthrate;
    this.turnovertarget = turnovertarget;
    this.trademarkturnoverpercent = trademarkturnoverpercent;
    this.incomeincreasepercent = incomeincreasepercent;
    this.license = license;
    this.licenseroyalt = licenseroyalt;
    this.contract = contract;
    this.advertisement = advertisement;
    this.totalexpenditure = totalexpenditure;
    this.countryoutside = countryoutside;
    this.europeanunion = europeanunion;
    this.name_surname = name_surname;
    this.tc = tc;
    this.tel = tel;
    this.email = email;
    this.legalPerson = legalPerson;
    this.valuationTrademarkAppNo = valuationTrademarkAppNo;
    this.licenseChoose = licenseChoose;
    this.kvvk = kvvk;
  }

  public ValuationTrademarkEntity(String address, String trademarkpurpose, String commonusage, String targetcountry, String trademarktime, String markettime, String trademarkcontribution, String mainsector, String othersector, String marketshare, String overseasmarketshare, String exportcountry, String turnoverpercent, String competingmarketshare, String markethistory, String turnovertarget, String trademarkturnoverpercent, String incomeincreasepercent, String license, String licenseroyalt, String contract, String advertisement, String totalexpenditure, String countryoutside, String europeanunion, String name_surname, String tc, String tel, @NotBlank @Size(max = 50) @Email String email, String legalPerson, String valuationTrademarkAppNo, String licenseChoose, boolean kvvk,String trackingNumber) {
    this.address = address;
    this.trademarkpurpose = trademarkpurpose;
    this.commonusage = commonusage;
//    this.dominanttrademark = dominanttrademark;
    this.targetcountry = targetcountry;
    this.trademarktime = trademarktime;
    this.markettime = markettime;
    this.trademarkcontribution = trademarkcontribution;
//    this.incomepercent = incomepercent;
    this.mainsector = mainsector;
    this.othersector = othersector;
    this.marketshare = marketshare;
//    this.totalturnover = totalturnover;
    this.overseasmarketshare = overseasmarketshare;
    this.exportcountry = exportcountry;
    this.turnoverpercent = turnoverpercent;
//    this.percentroyalt = percentroyalt;
    this.competingmarketshare = competingmarketshare;
    this.markethistory = markethistory;
//    this.growthrate = growthrate;
    this.turnovertarget = turnovertarget;
    this.trademarkturnoverpercent = trademarkturnoverpercent;
    this.incomeincreasepercent = incomeincreasepercent;
    this.license = license;
    this.licenseroyalt = licenseroyalt;
    this.contract = contract;
    this.advertisement = advertisement;
    this.totalexpenditure = totalexpenditure;
    this.countryoutside = countryoutside;
    this.europeanunion = europeanunion;
    this.name_surname = name_surname;
    this.tc = tc;
    this.tel = tel;
    this.email = email;
    this.legalPerson = legalPerson;
    this.valuationTrademarkAppNo = valuationTrademarkAppNo;
    this.licenseChoose = licenseChoose;
    this.kvvk = kvvk;
    this.trackingNumber = trackingNumber;
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

  public String getTrademarkpurpose() {
    return trademarkpurpose;
  }

  public void setTrademarkpurpose(String trademarkpurpose) {
    this.trademarkpurpose = trademarkpurpose;
  }

  public String getCommonusage() {
    return commonusage;
  }

  public void setCommonusage(String commonusage) {
    this.commonusage = commonusage;
  }

  public String getTargetcountry() {
    return targetcountry;
  }

  public void setTargetcountry(String targetcountry) {
    this.targetcountry = targetcountry;
  }

  public String getTrademarktime() {
    return trademarktime;
  }

  public void setTrademarktime(String trademarktime) {
    this.trademarktime = trademarktime;
  }

  public String getMarkettime() {
    return markettime;
  }

  public void setMarkettime(String markettime) {
    this.markettime = markettime;
  }

  public String getTrademarkcontribution() {
    return trademarkcontribution;
  }

  public void setTrademarkcontribution(String trademarkcontribution) {
    this.trademarkcontribution = trademarkcontribution;
  }

  public String getMainsector() {
    return mainsector;
  }

  public void setMainsector(String mainsector) {
    this.mainsector = mainsector;
  }

  public String getOthersector() {
    return othersector;
  }

  public void setOthersector(String othersector) {
    this.othersector = othersector;
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

  public String getTurnoverpercent() {
    return turnoverpercent;
  }

  public void setTurnoverpercent(String turnoverpercent) {
    this.turnoverpercent = turnoverpercent;
  }


  public String getCompetingmarketshare() {
    return competingmarketshare;
  }

  public void setCompetingmarketshare(String competingmarketshare) {
    this.competingmarketshare = competingmarketshare;
  }

  public String getMarkethistory() {
    return markethistory;
  }

  public void setMarkethistory(String markethistory) {
    this.markethistory = markethistory;
  }

  public String getTurnovertarget() {
    return turnovertarget;
  }

  public void setTurnovertarget(String turnovertarget) {
    this.turnovertarget = turnovertarget;
  }

  public String getTrademarkturnoverpercent() {
    return trademarkturnoverpercent;
  }

  public void setTrademarkturnoverpercent(String trademarkturnoverpercent) {
    this.trademarkturnoverpercent = trademarkturnoverpercent;
  }

  public String getIncomeincreasepercent() {
    return incomeincreasepercent;
  }

  public void setIncomeincreasepercent(String incomeincreasepercent) {
    this.incomeincreasepercent = incomeincreasepercent;
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

  public String getCountryoutside() {
    return countryoutside;
  }

  public void setCountryoutside(String countryoutside) {
    this.countryoutside = countryoutside;
  }

  public String getEuropeanunion() {
    return europeanunion;
  }

  public void setEuropeanunion(String europeanunion) {
    this.europeanunion = europeanunion;
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


  public String getValuationTrademarkAppNo() {
    return valuationTrademarkAppNo;
  }

  public void setValuationTrademarkAppNo(String valuationTrademarkAppNo) {
    this.valuationTrademarkAppNo = valuationTrademarkAppNo;
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

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }
}
