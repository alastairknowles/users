package parser.definition;

import org.junit.Assert;
import org.junit.Test;
import parser.CsvParser;
import parser.JsonParser;
import parser.XmlParser;

import java.lang.reflect.Field;
import java.util.Objects;

public class FileTypeTest {
    
    @Test
    public void shouldDetectFileType() {
        Assert.assertEquals(FileType.CSV, FileType.detect("anypath.csv"));
        Assert.assertEquals(FileType.JSON, FileType.detect("anypath/anypath.json"));
        Assert.assertEquals(FileType.XML, FileType.detect("anypath/anypath/anypath.xml"));
        
        Exception thrown = null;
        try {
            FileType.detect("anypath.jpeg");
        } catch (Exception e) {
            thrown = e;
        }
        
        Assert.assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    @Test
    public void shouldGetInstantiatedParsers() throws Exception {
        shouldGetInstantiatedParser(FileType.CSV, CsvParser.class, "beanListProcessor", "csvParserSettings", "beanWriterProcessor", "csvWriterSettings");
        shouldGetInstantiatedParser(FileType.JSON, JsonParser.class, "objectMapper");
        shouldGetInstantiatedParser(FileType.XML, XmlParser.class, "unmarshaller", "marshaller");
    }
    
    private <T extends ParserDefinition> void shouldGetInstantiatedParser(FileType fileType, Class<T> expectedParserClass, String... properties) throws Exception {
        Object parser = FileType.getParser(fileType);
        Assert.assertEquals(expectedParserClass, parser.getClass());
        
        Class<T> parserClass = (Class<T>) parser.getClass();
        if (Objects.nonNull(properties)) {
            for (String fieldName : properties) {
                Field field = parserClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                Assert.assertNotNull(field.get(parser));
            }
        }
    }
    
}
