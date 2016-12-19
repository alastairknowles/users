package domain.definition;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class UserTypeTest {
    
    @Test
    public void shouldSerializeUserTypes() {
        shouldSerializeUserType(null);
        shouldSerializeUserType(UserType.EMPLOYEE);
        shouldSerializeUserType(UserType.MANAGER);
    }
    
    @Test
    public void shouldDeserializeUserTypes() {
        shouldDeserializeUserType(UserType.EMPLOYEE, null);
        shouldDeserializeUserType(UserType.EMPLOYEE, "employee");
        shouldDeserializeUserType(UserType.MANAGER, "manager");
    }
    
    private void shouldSerializeUserType(UserType userType) {
        if (Objects.isNull(userType)) {
            Assert.assertNull(UserType.serialize(userType));
        } else {
            Assert.assertEquals(WordUtils.capitalizeFully(userType.name()), UserType.serialize(userType));
        }
    }
    
    private void shouldDeserializeUserType(UserType userTypeExpected, String lowercaseInput) {
        if (Objects.isNull(lowercaseInput)) {
            Assert.assertNull(UserType.deserialize(lowercaseInput));
        } else {
            Assert.assertEquals(userTypeExpected, UserType.deserialize(lowercaseInput));
            Assert.assertEquals(userTypeExpected, UserType.deserialize(WordUtils.capitalizeFully(lowercaseInput)));
        }
    }
    
}
