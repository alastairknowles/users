package domain.definition;

import domain.Users;
import domain.UsersGroup;
import parser.definition.FileType;

public interface UsersDefinition {
    
    FileType getFileType();
    
    void setFileType(FileType fileType);
    
    Users getUsers();
    
    UsersGroup getUsersGroup();
    
}
