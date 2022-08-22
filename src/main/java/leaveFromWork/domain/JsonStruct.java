package leaveFromWork.domain;

import lombok.Getter;
import leaveFromWork.domain.deserialization.FunctionableInterface;
import leaveFromWork.domain.deserialization.MetaColumnDeserealization;
import leaveFromWork.domain.deserialization.MetaDataDeserialization;
import leaveFromWork.domain.deserialization.MetaPropertyDeserialization;

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
