import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

public class MainTest {
    
    @Test
    public void shouldParseCsvJsonAndXmlAsExpected() throws Exception {
        int runCounter = 0;
        while (runCounter < 2) {
            Long baseline = DateTime.now().getMillis();
            Main.main(null);
            
            for (String extension : Main.EXTENSIONS) {
                File actualFile = new File(getClass().getClassLoader().getResource("output/users." + extension).getFile());
                Assert.assertTrue(actualFile.lastModified() > baseline);
                
                File expectedFile = new File(getClass().getClassLoader().getResource("users." + extension).getFile());
                Assert.assertEquals(new String(Files.readAllBytes(expectedFile.toPath())), new String(Files.readAllBytes(actualFile.toPath())));
            }
            
            runCounter++;
        }
    }
    
}
