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
        String outputPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/output";
        FileUtils.forceMkdir(new File(outputPath));
        FileType fileType = usersDefinition.getFileType();
        ParserDefinition parser = FileType.getParser(fileType);
        FileUtils.writeStringToFile(new File(outputPath + "/users." + fileType.name().toLowerCase()), parser.serialize(usersDefinition), "UTF-8");
    }
    
}
