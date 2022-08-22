package leaveFromWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import leaveFromWork.domain.MetaTableInfo;
import java.io.File;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MetaTableInfo> metaTableInfo=null;
        metaTableInfo = (List<MetaTableInfo>) objectMapper.readValue(new File("/Users/sergei/Desktop/sparkJob/src/main/resources/test.json"),MetaTableInfo.class);
        for(MetaTableInfo i : metaTableInfo){
            System.out.println(i.toString());
            System.out.println("\n");
        }
    }
}
