package tr.com.tsmd.cengiz.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "answers", schema = "tsmd")
public class AnswerEntity extends AuditModel {
  @Id
  @GeneratedValue(generator = "answer_generator")
  @SequenceGenerator(
      name = "answer_generator",
      sequenceName = "answer_sequence",
      initialValue = 1000
  )
  private Long id;

  @Column(columnDefinition = "text")
  private String text;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "question_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private QuestionEntity question;

  // Getters and Setters (Omitted for brevity)
}
