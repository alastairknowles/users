import domain.definition.UsersDefinition;
import org.springframework.beans.BeanUtils;
import parser.Parser;

public class Main {
    
    public static final String[] EXTENSIONS = new String[]{"csv", "json", "xml"};
    
    public static void main(String[] args) throws Exception {
        Parser parser = BeanUtils.instantiate(Parser.class);
        for (String extension : EXTENSIONS) {
            String fileName = "users." + extension;
            UsersDefinition users = parser.deserialize("input/" + fileName);
            parser.serialize(users, Main.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "output/" + fileName);
        }
    }
    
}
