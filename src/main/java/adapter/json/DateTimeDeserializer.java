package adapter.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import util.DateTimeUtils;

import java.io.IOException;

public class DateTimeDeserializer extends JsonDeserializer<DateTime> {
    
    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String v = jsonParser.readValueAs(String.class);
        return DateTimeUtils.deserialize(v);
    }
    
}
