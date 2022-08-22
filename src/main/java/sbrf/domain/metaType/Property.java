package sbrf.domain.metaType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Property {

    @JsonProperty("stored")
    private String stored;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append("saved as ").append(stored).append(" ");
        return sb.toString();
    }
}
