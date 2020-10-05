package nl.elros.textevaluator.entity;

public enum EvaluationType {
	SENTENCE("sentence"), TEXT("text");

	private String type;

	private EvaluationType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
