package parser;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import domain.User;
import domain.Users;
import org.apache.commons.io.IOUtils;
import parser.definition.ParserDefinition;

import java.io.File;
import java.io.StringWriter;

public class CsvParser implements ParserDefinition<Users> {
    
    private BeanListProcessor<User> beanListProcessor;
    
    private CsvParserSettings csvParserSettings;
    
    private BeanWriterProcessor<User> beanWriterProcessor;
    
    private CsvWriterSettings csvWriterSettings;
    
    public CsvParser() {
        this.beanListProcessor = new BeanListProcessor<>(User.class);
        this.csvParserSettings = new CsvParserSettings();
        this.csvParserSettings.setProcessor(beanListProcessor);
        this.csvParserSettings.setHeaderExtractionEnabled(true);
        
        this.beanWriterProcessor = new BeanWriterProcessor<>(User.class);
        this.csvWriterSettings = new CsvWriterSettings();
        this.csvWriterSettings.setRowWriterProcessor(beanWriterProcessor);
        this.csvWriterSettings.setHeaders("User ID", "First Name", "Last Name", "Username", "User Type", "Last Login Time");
    }
    
    @Override
    public Users deserialize(String path) {
        com.univocity.parsers.csv.CsvParser csvParser = new com.univocity.parsers.csv.CsvParser(this.csvParserSettings);
        csvParser.parse(new File(getClass().getClassLoader().getResource(path).getFile()));
        return new Users(this.beanListProcessor.getBeans());
    }
    
    @Override
    public String serialize(Users usersDefinition) {
        try {
            StringWriter stringWriter = new StringWriter();
            CsvWriter csvWriter = new CsvWriter(stringWriter, this.csvWriterSettings);
            csvWriter.writeHeaders();
            csvWriter.processRecords(usersDefinition);
            csvWriter.close();
            return stringWriter.toString();
        } finally {
            IOUtils.closeQuietly();
        }
    }
    
}
