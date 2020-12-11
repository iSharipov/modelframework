package io.github.isharipov.modelframework;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public abstract class ModelAttributeConverter<I extends Model> implements AttributeConverter<Model, String> {
    public String convertToDatabaseColumn(Model attribute) {
        return attribute.formattedValue();
    }

    public Model convertToEntityAttribute(String dbData) {
        return instance(dbData);
    }

    protected abstract I instance(String value);
}
