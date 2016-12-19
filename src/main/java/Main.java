import domain.definition.UsersDefinition;
import org.springframework.beans.BeanUtils;
import parser.Parser;

public class Main {
    
    public static final String[] EXTENSIONS = new String[]{"csv", "json", "xml"};
    
    public static void main(String[] args) throws Exception {
        Parser parser = BeanUtils.instantiate(Parser.class);
        for (String extension : EXTENSIONS) {
            UsersDefinition users = parser.deserialize("input/users." + extension);
            parser.serialize(users, "output/users." + extension);
        }
    }
    
}
