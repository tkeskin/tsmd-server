package tr.com.tsmd.cengiz.models;

import java.util.List;

public class HomePage {

  private Slogan slogan;

  private List<Slider> sliders;

  public Slogan getSlogan() {
    return slogan;
  }

  public void setSlogan(Slogan slogan) {
    this.slogan = slogan;
  }

  public List<Slider> getSliders() {
    return sliders;
  }

  public void setSliders(List<Slider> sliders) {
    this.sliders = sliders;
  }

}
