package leaveFromWork.domain.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;
import leaveFromWork.domain.JsonStruct;
import leaveFromWork.domain.MetaTableInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MetaTableInfoDeserialization extends StdDeserializer<List<MetaTableInfo>> {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public MetaTableInfoDeserialization(){
        this(null);
    };

    public MetaTableInfoDeserialization(Class<?> vc) {
        super(vc);
    };

    @SneakyThrows
    @Override
    public List<MetaTableInfo> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        List<MetaTableInfo> metaTableInfos = new CopyOnWriteArrayList<>();//модификация листа для многопоточного доступа
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();//итератор получаю заранее

        while (true){
            if (!it.hasNext()) {
                break;
            };
            Map.Entry<String, JsonNode> i = it.next();//итерирую все одним потоком, чтобы не думать ) в идеалее есть многопоточный итератор
            executorService.execute(()->{
                try{
                    MetaTableInfo metaTableInfo = new MetaTableInfo(); // каждый поток работает со своей таблицей
                    for(JsonStruct jsonStruct: JsonStruct.values()){
                        String name = jsonStruct.getName();
                        Field field = metaTableInfo.getClass().getDeclaredField(name);
                        field.setAccessible(true);
                        field.set(metaTableInfo,jsonStruct.getAction().deserialize(i.getValue().get(name),deserializationContext));
                    }

                    metaTableInfo.setTableName(i.getKey());
                    metaTableInfos.add(metaTableInfo);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        };
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        return metaTableInfos;
    }
}
