package tr.com.tsmd.cengiz.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions", schema = "tsmd")
public class QuestionEntity extends AuditModel {
  @Id
  @GeneratedValue(generator = "question_generator")
  @SequenceGenerator(
      name = "question_generator",
      sequenceName = "question_sequence",
      initialValue = 1000
  )
  private Long id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String title;

  @Column(columnDefinition = "text")
  private String description;

  // Getters and Setters (Omitted for brevity)
}
