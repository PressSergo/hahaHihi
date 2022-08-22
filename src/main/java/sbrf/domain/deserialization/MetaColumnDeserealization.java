package sbrf.domain.deserialization;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import sbrf.domain.metaType.Columns;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MetaColumnDeserealization implements FunctionableInterface {
    @SneakyThrows
    public static List<Columns> deserializeColumn(JsonNode jsonNode, DeserializationContext deserializationContext) {
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        List<Columns> columns = new LinkedList<>();
        for (Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> i = it.next();
            Columns c = OBJECT_MAPPER.readValue(i.getValue().toString(),Columns.class);
            c.setName(i.getKey());
            columns.add(c);
        }
        return columns;
    }

    @Override
    public List<Columns> deserialize(JsonNode jsonNode, DeserializationContext deserializationContext) {
        return deserializeColumn(jsonNode, deserializationContext);
    }
}
