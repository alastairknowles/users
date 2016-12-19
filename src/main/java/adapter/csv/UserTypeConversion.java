package adapter.csv;

import com.univocity.parsers.conversions.Conversion;
import domain.definition.UserType;

public class UserTypeConversion implements Conversion<String, UserType> {
    
    public UserTypeConversion(String[] args) {
    }
    
    @Override
    public UserType execute(String s) {
        return UserType.deserialize(s);
    }
    
    @Override
    public String revert(UserType o) {
        return UserType.serialize(o);
    }
    
}


