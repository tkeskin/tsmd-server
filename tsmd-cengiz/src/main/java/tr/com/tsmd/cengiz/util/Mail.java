package tr.com.tsmd.cengiz.util;

import java.util.Arrays;

public class Mail {

  private String from;
  private String[] to;
  private String subject;
  private String content;

  public Mail() {
  }

  /**
   * @param from    .
   * @param to      .
   * @param subject .
   * @param content .
   */
  public Mail(String from, String[] to, String subject, String content) {
    this.from = from;
    this.to = to.clone();
    this.subject = subject;
    this.content = content;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String[] getTo() {
    return to.clone();
  }

  public void setTo(String[] to) {
    this.to = to.clone();
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Mail{"
        + "from='" + from + '\'' + ", to='" + Arrays.toString(to) + '\''
        + ", subject='" + subject + '\''
        + ", content='" + content + '\'' + '}';
  }
}
