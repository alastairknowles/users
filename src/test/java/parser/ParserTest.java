package parser;

import com.google.common.collect.ImmutableMap;
import domain.User;
import domain.Users;
import domain.definition.UsersDefinition;
import org.junit.Assert;
import org.junit.Test;
import parser.definition.FileType;
import parser.definition.ParserDefinition;

import java.util.Map;

public class ParserTest {
    
    @Test
    public void shouldDeserializeEntitiesInAscendingOrder() throws Exception {
        Map<FileType, Integer> expectations = ImmutableMap.of(FileType.CSV, 2, FileType.JSON, 5, FileType.XML, 3);
        for (FileType fileType : expectations.keySet()) {
            ParserDefinition parser = FileType.getParser(fileType);
            UsersDefinition usersDefinition = parser.deserialize("input/users." + fileType.name().toLowerCase());
            
            Users users = usersDefinition.getUsers();
            Assert.assertEquals(expectations.get(fileType).intValue(), users.size());
            
            Long lastUserId = 0L;
            for (User user : users) {
                Long thisUserId = user.getUserId();
                Assert.assertTrue(thisUserId > lastUserId);
                lastUserId = thisUserId;
            }
        }
    }
    
}
