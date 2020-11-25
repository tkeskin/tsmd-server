package tr.com.tsmd.cengiz.models;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ValuationTrademark {

  private Long id;
  private String address;
//  private String trademarkclass;
  private String trademarkpurpose;
//  private String registrationdate;
  private String commonusage;
//  private String dominanttrademark;
  private String targetcountry;
  private String trademarktime;
  private String markettime;
  private String trademarkcontribution;
//  private String incomepercent;
  private String mainsector;
  private String othersector;
  private String marketshare;
//  private String totalturnover;
  private String overseasmarketshare;
  private String exportcountry;
  private String turnoverpercent;
//  private String percentroyalt;
  private String competingmarketshare;
  private String markethistory;
//  private String growthrate;
  private String turnovertarget;
  private String trademarkturnoverpercent;
  private String incomeincreasepercent;
  private String license;
  private String licenseroyalt;
  private String contract;
  private String advertisement;
  private String totalexpenditure;
  private String countryoutside;
  private String europeanunion;

  private Date createdAt;

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
  private boolean kvvk;


  public ValuationTrademark() {
  }

  public ValuationTrademark( String address, String trademarkpurpose, String commonusage, String targetcountry, String trademarktime, String markettime, String trademarkcontribution, String mainsector, String othersector, String marketshare, String overseasmarketshare, String exportcountry, String turnoverpercent, String competingmarketshare, String markethistory, String turnovertarget, String trademarkturnoverpercent, String incomeincreasepercent, String license, String licenseroyalt, String contract, String advertisement, String totalexpenditure, String countryoutside, String europeanunion, String name_surname, String tc, String tel, @NotBlank @Size(max = 50) @Email String email, String legalPerson, String valuationTrademarkAppNo,String licenseChoose, boolean kvvk) {

    this.address = address;
//    this.trademarkclass = trademarkclass;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
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
}
