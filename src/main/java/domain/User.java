package domain;

import adapter.csv.DateTimeConversion;
import adapter.csv.UserTypeConversion;
import adapter.json.DateTimeDeserializer;
import adapter.json.UserTypeDeserializer;
import adapter.json.UserTypeSerializer;
import adapter.xml.DateTimeAdapter;
import adapter.xml.UserTypeAdapter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import domain.definition.UserType;
import org.apache.commons.lang3.ObjectUtils;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"userId", "firstName", "lastName", "userName", "userType", "lastLoginTime"})
public class User implements Comparable<User> {
    
    @Parsed(field = "User ID", index = 0)
    @JsonProperty("user_id")
    @XmlElement(name = "userid")
    private Long userId;
    
    @Parsed(field = "First Name", index = 1)
    @JsonProperty("first_name")
    @XmlElement(name = "firstname")
    private String firstName;
    
    @Parsed(field = "Last Name", index = 2)
    @JsonProperty("last_name")
    @XmlElement(name = "surname")
    private String lastName;
    
    @Parsed(field = "Username", index = 3)
    @JsonProperty("username")
    @XmlElement(name = "username")
    private String userName;
    
    @Parsed(field = "User Type", index = 4, applyDefaultConversion = false)
    @JsonProperty("user_type")
    @XmlElement(name = "type")
    @Convert(conversionClass = UserTypeConversion.class)
    @JsonDeserialize(using = UserTypeDeserializer.class)
    @JsonSerialize(using = UserTypeSerializer.class)
    @XmlJavaTypeAdapter(UserTypeAdapter.class)
    private UserType userType;
    
    @Parsed(field = "Last Login Time", index = 5, applyDefaultConversion = false)
    @JsonProperty("last_login_time")
    @XmlElement(name = "lastlogintime")
    @Convert(conversionClass = DateTimeConversion.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private DateTime lastLoginTime;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public UserType getUserType() {
        return userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public DateTime getLastLoginTime() {
        return lastLoginTime;
    }
    
    public void setLastLoginTime(DateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj) || !getClass().equals(obj.getClass())) {
            return false;
        }
        
        return Objects.equals(userId, ((User) obj).getUserId());
    }
    
    @Override
    public int compareTo(User o) {
        return ObjectUtils.compare(userId, o.getUserId());
    }
    
}
