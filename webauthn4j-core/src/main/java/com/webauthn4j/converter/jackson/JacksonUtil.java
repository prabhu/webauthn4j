package com.webauthn4j.converter.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.webauthn4j.converter.exception.DataConversionException;

import java.io.IOException;
import java.io.UncheckedIOException;

public class JacksonUtil {

    private static final String INPUT_MISMATCH_ERROR_MESSAGE = "Input data does not match expected form";

    private JacksonUtil() {
    }

    public static JsonNode readTree(ObjectMapper objectMapper, byte[] bytes) {
        try {
            return objectMapper.readTree(bytes);
        } catch (MismatchedInputException | JsonParseException e) {
            throw new DataConversionException(INPUT_MISMATCH_ERROR_MESSAGE, e);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static byte[] binaryValue(JsonNode jsonNode) {
        try {
            return jsonNode.binaryValue();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
