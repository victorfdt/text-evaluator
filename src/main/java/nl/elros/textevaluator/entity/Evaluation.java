package nl.elros.textevaluator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "evaluation")
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@NotBlank(message = "The title is empty.")
	private String title;

	@Column(name = "text", columnDefinition = "TEXT")
	@NotBlank(message = "The text/sentence field is empty")
	private String text;

	@Column(name = "description", columnDefinition = "TEXT")
	@NotBlank(message = "The description is empty.")
	private String description;

	private EvaluationType evaluationType;

	public Evaluation() {

	}

	public Evaluation(int id, @NotBlank(message = "The title is empty.") String title,
			@NotBlank(message = "The text/sentencen field is empty") String text,
			@NotBlank(message = "The description is empty.") String description, EvaluationType evaluationType) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.description = description;
		this.evaluationType = evaluationType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EvaluationType getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(EvaluationType evaluationType) {
		this.evaluationType = evaluationType;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", " + (title != null ? "title=" + title + ", " : "")
				+ (text != null ? "text=" + text + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (evaluationType != null ? "evaluationType=" + evaluationType : "") + "]";
	}
}
