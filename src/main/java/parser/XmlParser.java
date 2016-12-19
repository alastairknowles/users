package parser;

import domain.UsersGroup;
import org.apache.commons.io.IOUtils;
import parser.definition.ParserDefinition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

public class XmlParser implements ParserDefinition<UsersGroup> {
    
    private Unmarshaller unmarshaller;
    
    private Marshaller marshaller;
    
    public XmlParser() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(UsersGroup.class);
        this.unmarshaller = jaxbContext.createUnmarshaller();
        this.marshaller = jaxbContext.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
    
    @Override
    public UsersGroup deserialize(String path) throws Exception {
        return (UsersGroup) this.unmarshaller.unmarshal(new File(getClass().getClassLoader().getResource(path).getFile()));
    }
    
    @Override
    public String serialize(UsersGroup usersDefinition) throws Exception {
        StringWriter stringWriter = new StringWriter();
        try {
            this.marshaller.marshal(usersDefinition, stringWriter);
            return stringWriter.toString();
        } finally {
            IOUtils.closeQuietly(stringWriter);
        }
    }
    
}
