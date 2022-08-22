package sbrf.domain.deserialization;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface FunctionableInterface {
    Object deserialize(JsonNode jsonNode, DeserializationContext deserializationContext);
}
