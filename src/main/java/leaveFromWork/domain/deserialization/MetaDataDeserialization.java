package leaveFromWork.domain.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import leaveFromWork.domain.metaType.DataMeta;

import java.io.IOException;
import java.util.List;

public class MetaDataDeserialization implements FunctionableInterface{
    public List<DataMeta> deserializeDataMeta(JsonNode jsonNode, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        return OBJECT_MAPPER.readValue(jsonNode.toString(),List.class);
    }

    @SneakyThrows
    @Override
    public List<DataMeta> deserialize(JsonNode jsonNode, DeserializationContext deserializationContext) {
        return deserializeDataMeta(jsonNode, deserializationContext);
    }
}
