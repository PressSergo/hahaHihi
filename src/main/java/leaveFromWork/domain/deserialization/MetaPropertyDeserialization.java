package leaveFromWork.domain.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import leaveFromWork.domain.metaType.Property;

import java.io.IOException;

public class MetaPropertyDeserialization implements FunctionableInterface{
    public Property deserializeProperty(JsonNode jsonNode, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        return OBJECT_MAPPER.readValue(jsonNode.toString(),Property.class);
    }

    @SneakyThrows
    @Override
    public Property deserialize(JsonNode jsonNode, DeserializationContext deserializationContext) {
        return deserializeProperty(jsonNode, deserializationContext);
    }
}
