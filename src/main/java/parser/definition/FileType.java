package parser.definition;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import parser.CsvParser;
import parser.JsonParser;
import parser.XmlParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum FileType {
    
    CSV(CsvParser.class),
    JSON(JsonParser.class),
    XML(XmlParser.class);
    
    private static final Map<FileType, ParserDefinition> PARSERS = new HashMap<>();
    
    static {
        Arrays.stream(values()).forEach(fileType -> PARSERS.put(fileType, BeanUtils.instantiate(fileType.parserClass)));
    }
    
    private Class<? extends ParserDefinition> parserClass;
    
    FileType(Class<? extends ParserDefinition> parserClass) {
        this.parserClass = parserClass;
    }
    
    public static ParserDefinition getParser(FileType fileType) {
        return PARSERS.get(fileType);
    }
    
    public static FileType detect(String path) {
        String extension = FilenameUtils.getExtension(path);
        return FileType.valueOf(extension.toUpperCase());
    }
    
}
