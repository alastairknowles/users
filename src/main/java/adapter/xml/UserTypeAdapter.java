package adapter.xml;

import domain.definition.UserType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserTypeAdapter extends XmlAdapter<String, UserType> {
    
    @Override
    public UserType unmarshal(String v) throws Exception {
        return UserType.deserialize(v);
    }
    
    @Override
    public String marshal(UserType v) throws Exception {
        return UserType.serialize(v);
    }
    
}
