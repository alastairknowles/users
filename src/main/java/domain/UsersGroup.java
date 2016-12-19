package domain;

import domain.definition.UsersDefinition;
import parser.definition.FileType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersGroup implements UsersDefinition {
    
    private FileType fileType;
    
    public UsersGroup() {
    }
    
    public UsersGroup(Users users) {
        this.users = users;
    }
    
    @Override
    public FileType getFileType() {
        return fileType;
    }
    
    @Override
    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
    
    @XmlElement(name = "user")
    private Users users;
    
    @Override
    public Users getUsers() {
        return users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Override
    public UsersGroup getUsersGroup() {
        return this;
    }
    
}
