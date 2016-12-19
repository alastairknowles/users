package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import domain.Users;
import parser.definition.ParserDefinition;

import java.io.File;
import java.nio.file.Files;

public class JsonParser implements ParserDefinition<Users> {
    
    private ObjectMapper objectMapper;
    
    public JsonParser() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());
        objectMapper.setDateFormat(new ISO8601DateFormat());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    
    @Override
    public Users deserialize(String path) throws Exception {
        File file = new File(getClass().getClassLoader().getResource(path).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));
        return this.objectMapper.readValue(content, Users.class);
    }
    
    @Override
    public String serialize(Users usersDefinition) throws Exception {
        return this.objectMapper.writeValueAsString(usersDefinition);
    }
    
}
