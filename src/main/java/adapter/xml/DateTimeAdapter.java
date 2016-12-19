package adapter.xml;

import org.joda.time.DateTime;
import util.DateTimeUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {
    
    @Override
    public DateTime unmarshal(String v) throws Exception {
        return DateTimeUtils.deserialize(v);
    }
    
    @Override
    public String marshal(DateTime v) throws Exception {
        return DateTimeUtils.serialize(v);
    }
    
}
