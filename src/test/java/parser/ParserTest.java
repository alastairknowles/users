package parser;

import domain.User;
import domain.Users;
import org.junit.Assert;
import org.junit.Test;
import parser.definition.FileType;

public class ParserTest {
    
    @Test
    public void shouldOrderDeserializedEntitiesAscending() throws Exception {
        JsonParser jsonParser = (JsonParser) FileType.getParser(FileType.JSON);
        Users users = jsonParser.deserialize("input/users.json");
        
        Long lastUserId = 0L;
        for (User user : users) {
            Long thisUserId = user.getUserId();
            Assert.assertTrue(thisUserId > lastUserId);
            lastUserId = thisUserId;
        }
    }
    
}
