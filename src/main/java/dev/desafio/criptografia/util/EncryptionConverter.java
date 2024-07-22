package dev.desafio.criptografia.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class EncryptionConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return EncryptionUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String attribute) {
        return EncryptionUtil.decrypt(attribute);
    }    
}
