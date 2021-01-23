package tr.com.tsmd.cengiz.models;


import tr.com.tsmd.cengiz.entity.AuditModel;


public class Slider extends AuditModel {

  private Long id;

  private byte[] picture;

  private String pictureExplain;

  private String pictureName;

  private String pictureType;

  private String base64Picture;


  public Slider() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getPictureType() {
    return pictureType;
  }

  public void setPictureType(String pictureType) {
    this.pictureType = pictureType;
  }

  public String getBase64Picture() {
    return base64Picture;
  }

  public void setBase64Picture(String base64Picture) {
    this.base64Picture = base64Picture;
  }

  public String getPictureExplain() {
    return pictureExplain;
  }

  public void setPictureExplain(String pictureExplain) {
    this.pictureExplain = pictureExplain;
  }

  public String getPictureName() {
    return pictureName;
  }

  public void setPictureName(String pictureName) {
    this.pictureName = pictureName;
  }
}
