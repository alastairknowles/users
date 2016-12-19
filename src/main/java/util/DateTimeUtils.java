package util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Objects;

public class DateTimeUtils {
    
    public static String serialize(DateTime v) {
        if (Objects.nonNull(v)) {
            return v.toString();
        }
        
        return null;
    }
    
    public static DateTime deserialize(String v) {
        if (Objects.nonNull(v)) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yy HH:mm:ss");
            return formatter.parseDateTime(v);
        }
        
        return null;
    }
    
}
