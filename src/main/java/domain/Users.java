package domain;

import domain.definition.UsersDefinition;
import parser.definition.FileType;

import java.util.Collection;
import java.util.TreeSet;

public class Users extends TreeSet<User> implements UsersDefinition {
    
    private FileType fileType;
    
    public Users() {
    }
    
    public Users(Collection<User> users) {
        super(users);
    }
    
    @Override
    public FileType getFileType() {
        return fileType;
    }
    
    @Override
    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
    
    @Override
    public Users getUsers() {
        return this;
    }
    
    public void setUsers(Users users) {
        this.addAll(users);
    }
    
    @Override
    public UsersGroup getUsersGroup() {
        return new UsersGroup(this);
    }
    
}
