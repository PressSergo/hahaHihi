package leaveFromWork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import leaveFromWork.domain.deserialization.MetaTableInfoDeserialization;
import leaveFromWork.domain.metaType.Columns;
import leaveFromWork.domain.metaType.DataMeta;
import leaveFromWork.domain.metaType.Property;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = MetaTableInfoDeserialization.class)
public class MetaTableInfo {

    private  @JsonIgnore
    String tableName;

    @JsonProperty("columns")
    private List<Columns> columns;

    @JsonProperty("proprety")
    private Property proprety;

    @JsonProperty("data")
    private List<DataMeta> data;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("create table ");
        sb.append(this.tableName).append(" (");
        sb.append("\n");
        for (Columns c : this.columns){
            sb.append(c.toString());
        }
        sb.append(')');
        sb.append(this.proprety.toString());
        return sb.toString();
    }
}
