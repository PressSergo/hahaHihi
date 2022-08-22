package leaveFromWork.domain.metaType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Columns {

    @JsonIgnore
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(name).append(" ");
        sb.append(type).append(" ");
        sb.append("\n");
        return sb.toString();
    }
}
