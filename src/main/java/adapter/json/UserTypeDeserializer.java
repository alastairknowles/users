package adapter.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import domain.definition.UserType;

import java.io.IOException;

public class UserTypeDeserializer extends JsonDeserializer<UserType> {
    
    @Override
    public UserType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String v = jsonParser.readValueAs(String.class);
        return UserType.deserialize(v);
    }
    
}
