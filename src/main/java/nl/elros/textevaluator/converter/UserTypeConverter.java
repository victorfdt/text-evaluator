package nl.elros.textevaluator.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import nl.elros.textevaluator.entity.UserType;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, String> {

	@Override
	public String convertToDatabaseColumn(UserType attribute) {
		if (attribute == null)
			return null;

		return attribute.getCode();
	}

	@Override
	public UserType convertToEntityAttribute(String code) {
		if (code == null)
			return null;

		return Stream.of(UserType.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
