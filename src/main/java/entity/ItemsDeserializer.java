package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom deseriaziler, because of generic types erasure
 *
 * @param <T>
 */
class ItemsDeserializer<T> extends JsonDeserializer<List<T>> {

    private Class<T> tClass;

    public ItemsDeserializer(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public List<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC));

        var listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        List<T> items = mapper.readValue(jsonParser, listType);

        return items;
    }
}
