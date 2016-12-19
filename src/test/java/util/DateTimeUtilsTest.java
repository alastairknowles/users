package util;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class DateTimeUtilsTest {
    
    @Test
    public void shouldSerializeDate() {
        Assert.assertNull(DateTimeUtils.serialize(null));
        String serialized = DateTimeUtils.serialize(DateTime.now());
        Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}.[0-9]{3}Z$");
        Assert.assertTrue(pattern.matcher(serialized).matches());
    }
    
    @Test
    public void shouldDeserializeDate() {
        Assert.assertNull(DateTimeUtils.deserialize(null));
        String serialized = "28-11-2001 09:26:51";
        DateTime deserialized = DateTimeUtils.deserialize(serialized);
        Assert.assertEquals(deserialized.getYear(), 2001);
        Assert.assertEquals(deserialized.getMonthOfYear(), 11);
        Assert.assertEquals(deserialized.getDayOfMonth(), 28);
        Assert.assertEquals(deserialized.getHourOfDay(), 9);
        Assert.assertEquals(deserialized.getMinuteOfHour(), 26);
        Assert.assertEquals(deserialized.getSecondOfMinute(), 51);
    }
    
}
