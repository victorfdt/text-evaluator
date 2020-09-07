package nl.elros.textevaluator.entity;

public enum UserType {
	EVALUATOR("evaluator"), STUDENT("student"), ADMIN("admin");

	private String code;

	private UserType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
