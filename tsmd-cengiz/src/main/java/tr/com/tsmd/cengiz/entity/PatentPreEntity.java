package tr.com.tsmd.cengiz.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_PATENTPRE, schema = Const.SCHEMA)
public class PatentPreEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name_surname;
  private String tc;
  private String address;
  private String tel;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private String protectiontype;
  private String reporttype;

  private String computerarea;
  private String electricityarea;
  private String electronicarea;
  private String machinearea;
  private String medicinearea;
  private String automotivearea;
  private String metallurgyarea;
  private String biomedicalarea;
  private String chemistryarea;
  private String foodarea;
  private String buildarea;
  private String otherarea;



  private String title;


  private String patentkeyword;
  private String patentapplication;
  private String advantage;
  private String publications;
  private String deferencechoose;
  private String deferenceno;
  private String deferencepriority;
  private String detailexplain;
  private String picture;
  private String otherpoint;


  public PatentPreEntity() {
  }

  public PatentPreEntity(String name_surname, String tc, String address, String tel, @NotBlank @Size(max = 50) @Email String email, String protectiontype, String reporttype, String computerarea, String electricityarea, String electronicarea, String machinearea, String medicinearea, String automotivearea, String metallurgyarea, String biomedicalarea, String chemistryarea, String foodarea, String buildarea, String otherarea, String title, String patentkeyword, String patentapplication, String advantage, String publications, String deferencechoose, String deferenceno, String deferencepriority, String detailexplain, String picture, String otherpoint) {
    this.name_surname = name_surname;
    this.tc = tc;
    this.address = address;
    this.tel = tel;
    this.email = email;
    this.protectiontype = protectiontype;
    this.reporttype = reporttype;
    this.computerarea = computerarea;
    this.electricityarea = electricityarea;
    this.electronicarea = electronicarea;
    this.machinearea = machinearea;
    this.medicinearea = medicinearea;
    this.automotivearea = automotivearea;
    this.metallurgyarea = metallurgyarea;
    this.biomedicalarea = biomedicalarea;
    this.chemistryarea = chemistryarea;
    this.foodarea = foodarea;
    this.buildarea = buildarea;
    this.otherarea = otherarea;
    this.title = title;
    this.patentkeyword = patentkeyword;
    this.patentapplication = patentapplication;
    this.advantage = advantage;
    this.publications = publications;
    this.deferencechoose = deferencechoose;
    this.deferenceno = deferenceno;
    this.deferencepriority = deferencepriority;
    this.detailexplain = detailexplain;
    this.picture = picture;
    this.otherpoint = otherpoint;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getProtectiontype() {
    return protectiontype;
  }

  public void setProtectiontype(String protectiontype) {
    this.protectiontype = protectiontype;
  }

  public String getReporttype() {
    return reporttype;
  }

  public void setReporttype(String reporttype) {
    this.reporttype = reporttype;
  }

  public String getComputerarea() {
    return computerarea;
  }

  public void setComputerarea(String computerarea) {
    this.computerarea = computerarea;
  }

  public String getElectricityarea() {
    return electricityarea;
  }

  public void setElectricityarea(String electricityarea) {
    this.electricityarea = electricityarea;
  }

  public String getElectronicarea() {
    return electronicarea;
  }

  public void setElectronicarea(String electronicarea) {
    this.electronicarea = electronicarea;
  }

  public String getMachinearea() {
    return machinearea;
  }

  public void setMachinearea(String machinearea) {
    this.machinearea = machinearea;
  }

  public String getMedicinearea() {
    return medicinearea;
  }

  public void setMedicinearea(String medicinearea) {
    this.medicinearea = medicinearea;
  }

  public String getAutomotivearea() {
    return automotivearea;
  }

  public void setAutomotivearea(String automotivearea) {
    this.automotivearea = automotivearea;
  }

  public String getMetallurgyarea() {
    return metallurgyarea;
  }

  public void setMetallurgyarea(String metallurgyarea) {
    this.metallurgyarea = metallurgyarea;
  }

  public String getBiomedicalarea() {
    return biomedicalarea;
  }

  public void setBiomedicalarea(String biomedicalarea) {
    this.biomedicalarea = biomedicalarea;
  }

  public String getChemistryarea() {
    return chemistryarea;
  }

  public void setChemistryarea(String chemistryarea) {
    this.chemistryarea = chemistryarea;
  }

  public String getFoodarea() {
    return foodarea;
  }

  public void setFoodarea(String foodarea) {
    this.foodarea = foodarea;
  }

  public String getBuildarea() {
    return buildarea;
  }

  public void setBuildarea(String buildarea) {
    this.buildarea = buildarea;
  }

  public String getOtherarea() {
    return otherarea;
  }

  public void setOtherarea(String otherarea) {
    this.otherarea = otherarea;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPatentkeyword() {
    return patentkeyword;
  }

  public void setPatentkeyword(String patentkeyword) {
    this.patentkeyword = patentkeyword;
  }

  public String getPatentapplication() {
    return patentapplication;
  }

  public void setPatentapplication(String patentapplication) {
    this.patentapplication = patentapplication;
  }

  public String getAdvantage() {
    return advantage;
  }

  public void setAdvantage(String advantage) {
    this.advantage = advantage;
  }

  public String getPublications() {
    return publications;
  }

  public void setPublications(String publications) {
    this.publications = publications;
  }

  public String getDeferencechoose() {
    return deferencechoose;
  }

  public void setDeferencechoose(String deferencechoose) {
    this.deferencechoose = deferencechoose;
  }

  public String getDeferenceno() {
    return deferenceno;
  }

  public void setDeferenceno(String deferenceno) {
    this.deferenceno = deferenceno;
  }

  public String getDeferencepriority() {
    return deferencepriority;
  }

  public void setDeferencepriority(String deferencepriority) {
    this.deferencepriority = deferencepriority;
  }

  public String getDetailexplain() {
    return detailexplain;
  }

  public void setDetailexplain(String detailexplain) {
    this.detailexplain = detailexplain;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getOtherpoint() {
    return otherpoint;
  }

  public void setOtherpoint(String otherpoint) {
    this.otherpoint = otherpoint;
  }
}
