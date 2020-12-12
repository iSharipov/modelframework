package io.github.isharipov.modelframework;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public abstract class ModelAttributeConverter<I extends Model> implements AttributeConverter<Model, String> {
    public String convertToDatabaseColumn(Model attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.formattedValue();
    }

    public Model convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return instance(dbData);
    }

    protected abstract I instance(String value);
}
