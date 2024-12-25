package org.alhngzl.yikit.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.security.MessageDigest;
import java.util.Base64;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            return Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(attribute.getBytes()));
        }catch (Exception err){
            return attribute;
        }
    }

    @Override
    public String convertToEntityAttribute(String attribute) {
        try {
            return ConstantsUtil.Char.EMPTY;
        }catch (Exception err){
            return attribute;
        }
    }
}