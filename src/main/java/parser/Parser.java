package parser;

import domain.definition.UsersDefinition;
import org.apache.commons.io.FileUtils;
import parser.definition.FileType;
import parser.definition.ParserDefinition;

import java.io.File;

public class Parser {
    
    public UsersDefinition deserialize(String path) throws Exception {
        FileType fileType = FileType.detect(path);
        ParserDefinition parser = FileType.getParser(fileType);
        UsersDefinition usersDefinition = parser.deserialize(path);
        usersDefinition.setFileType(fileType);
        return usersDefinition;
    }
    
    public void serialize(UsersDefinition usersDefinition, String path) throws Exception {
        FileType fileType = usersDefinition.getFileType();
        ParserDefinition parser = FileType.getParser(fileType);
        FileUtils.forceMkdir(new File(path.substring(0, path.lastIndexOf("/"))));
        FileUtils.writeStringToFile(new File(path), parser.serialize(usersDefinition), "UTF-8");
    }
    
}
