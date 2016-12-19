package adapter.csv;

import com.univocity.parsers.conversions.Conversion;
import org.joda.time.DateTime;
import util.DateTimeUtils;

public class DateTimeConversion implements Conversion<String, DateTime> {
    
    public DateTimeConversion(String[] args) {
    }
    
    @Override
    public DateTime execute(String s) {
        return DateTimeUtils.deserialize(s);
    }
    
    @Override
    public String revert(DateTime o) {
        return DateTimeUtils.serialize(o);
    }
    
}
