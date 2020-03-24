package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_VALUATIONPATENT, schema = Const.SCHEMA)
public class ValuationPatentEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String address;
  private String patentpurpose;
  private String patentappno;
  private String patentcountry;
  private String patentmarket;
  private String patentcontribution;
  private String patentsector;
  private String patentothersector;
  private String marketshare;
  private String percentageturnover;
  private String overseasmarketshare;
  private String exportcountry;
  private String exportturnover;
  private String royaltyrate;
  private String competingmarketshare;
  private String competitordate;
  private String competinggrowthrate;
  private String turnovertarget;
  private String turnoverpercent;
  private String incomepercent;
  private String license;
  private String licenseroyalt;
  private String contract;
  private String advertisement;
  private String totalexpenditure;
  private String spending;
  private String developmentspending;
  private String worldspending;
  private String caseexpense;
  private String countryoutside;
  private String europeanunio;


  public ValuationPatentEntity() {
  }

  public ValuationPatentEntity(String address, String patentpurpose, String patentappno, String patentcountry, String patentmarket, String patentcontribution, String patentsector, String patentothersector, String marketshare, String percentageturnover, String overseasmarketshare, String exportcountry, String exportturnover, String royaltyrate, String competingmarketshare, String competitordate, String competinggrowthrate, String turnovertarget, String turnoverpercent, String incomepercent, String license, String licenseroyalt, String contract, String advertisement, String totalexpenditure, String spending, String developmentspending, String worldspending, String caseexpense, String countryoutside, String europeanunio) {
    this.address = address;
    this.patentpurpose = patentpurpose;
    this.patentappno = patentappno;
    this.patentcountry = patentcountry;
    this.patentmarket = patentmarket;
    this.patentcontribution = patentcontribution;
    this.patentsector = patentsector;
    this.patentothersector = patentothersector;
    this.marketshare = marketshare;
    this.percentageturnover = percentageturnover;
    this.overseasmarketshare = overseasmarketshare;
    this.exportcountry = exportcountry;
    this.exportturnover = exportturnover;
    this.royaltyrate = royaltyrate;
    this.competingmarketshare = competingmarketshare;
    this.competitordate = competitordate;
    this.competinggrowthrate = competinggrowthrate;
    this.turnovertarget = turnovertarget;
    this.turnoverpercent = turnoverpercent;
    this.incomepercent = incomepercent;
    this.license = license;
    this.licenseroyalt = licenseroyalt;
    this.contract = contract;
    this.advertisement = advertisement;
    this.totalexpenditure = totalexpenditure;
    this.spending = spending;
    this.developmentspending = developmentspending;
    this.worldspending = worldspending;
    this.caseexpense = caseexpense;
    this.countryoutside = countryoutside;
    this.europeanunio = europeanunio;
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


  public String getPatentcontribution() {
    return patentcontribution;
  }

  public void setPatentcontribution(String patentcontribution) {
    this.patentcontribution = patentcontribution;
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

  public String getPercentageturnover() {
    return percentageturnover;
  }

  public void setPercentageturnover(String percentageturnover) {
    this.percentageturnover = percentageturnover;
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

  public String getRoyaltyrate() {
    return royaltyrate;
  }

  public void setRoyaltyrate(String royaltyrate) {
    this.royaltyrate = royaltyrate;
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

  public String getCompetinggrowthrate() {
    return competinggrowthrate;
  }

  public void setCompetinggrowthrate(String competinggrowthrate) {
    this.competinggrowthrate = competinggrowthrate;
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

  public String getDevelopmentspending() {
    return developmentspending;
  }

  public void setDevelopmentspending(String developmentspending) {
    this.developmentspending = developmentspending;
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
}
