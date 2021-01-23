package tr.com.tsmd.cengiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import tr.com.tsmd.cengiz.util.Const;

@Entity
@Table(name = Const.TABLE_SLIDER, schema = Const.SCHEMA)
public class SliderEntity extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] picture;

  private String pictureExplain;

  private String pictureName;

  private String pictureType;

  public SliderEntity() {
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

  public String getPictureName() {
    return pictureName;
  }

  public void setPictureName(String pictureName) {
    this.pictureName = pictureName;
  }

  public String getPictureType() {
    return pictureType;
  }

  public void setPictureType(String pictureType) {
    this.pictureType = pictureType;
  }

  public String getPictureExplain() {
    return pictureExplain;
  }

  public void setPictureExplain(String pictureExplain) {
    this.pictureExplain = pictureExplain;
  }
}
