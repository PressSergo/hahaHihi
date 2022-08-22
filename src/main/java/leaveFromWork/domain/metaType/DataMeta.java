package leaveFromWork.domain.metaType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataMeta {

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("active")
    private String active;
}
