package nl.elros.textevaluator.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import nl.elros.textevaluator.entity.EvaluationType;

@Converter(autoApply = true)
public class EvaluationTypeConverter implements AttributeConverter<EvaluationType, String> {

	@Override
	public String convertToDatabaseColumn(EvaluationType attribute) {
		if (attribute == null)
			return null;
		
		return attribute.getType();
	}

	@Override
	public EvaluationType convertToEntityAttribute(String code) {
		if (code == null)
			return null;
		
		return Stream.of(EvaluationType.values()).filter(c -> c.getType().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
