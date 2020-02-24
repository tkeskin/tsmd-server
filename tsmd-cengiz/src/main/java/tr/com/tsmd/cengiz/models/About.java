package tr.com.tsmd.cengiz.models;

public class About {

  private Long id;
  private String aboutExplain;

  public About() {
  }

  public About(Long id, String aboutExplain) {
    this.id = id;
    this.aboutExplain = aboutExplain;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAboutExplain() {
    return aboutExplain;
  }

  public void setAboutExplain(String aboutExplain) {
    this.aboutExplain = aboutExplain;
  }
}
