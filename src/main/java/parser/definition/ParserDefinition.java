package parser.definition;

import domain.definition.UsersDefinition;

public interface ParserDefinition<T extends UsersDefinition> {
    
    T deserialize(String path) throws Exception;
    
    String serialize(T usersDefinition) throws Exception;
    
}
