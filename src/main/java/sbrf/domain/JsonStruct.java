package sbrf.domain;

import lombok.Getter;
import sbrf.domain.deserialization.FunctionableInterface;
import sbrf.domain.deserialization.MetaColumnDeserealization;
import sbrf.domain.deserialization.MetaDataDeserialization;
import sbrf.domain.deserialization.MetaPropertyDeserialization;

@Getter
public enum JsonStruct {
    COLUMNS("columns",new MetaColumnDeserealization()),
    PROPERTY("proprety",new MetaPropertyDeserialization()),
    DATA("data",new MetaDataDeserialization());

    String name;
    FunctionableInterface action;

    JsonStruct(String name, FunctionableInterface action) {
        this.name = name;
        this.action = action;
    }
}
