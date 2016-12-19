package domain.definition;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Objects;

public enum UserType {
    
    EMPLOYEE,
    MANAGER;
    
    public static String serialize(UserType v) {
        if (Objects.nonNull(v)) {
            return WordUtils.capitalizeFully(v.name());
        }
        
        return null;
    }
    
    public static UserType deserialize(String v) {
        if (Objects.nonNull(v)) {
            return UserType.valueOf(v.toUpperCase());
        }
        
        return null;
    }
    
}
