package adapter.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import domain.definition.UserType;

import java.io.IOException;

public class UserTypeSerializer extends JsonSerializer<UserType> {
    
    @Override
    public void serialize(UserType userType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(UserType.serialize(userType));
    }
    
}
