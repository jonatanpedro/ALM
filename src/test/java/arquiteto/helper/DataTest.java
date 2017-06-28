package arquiteto.helper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by supero on 28/06/2017.
 */
public class DataTest {
    @Test
    public void test() {
        Data data = new Data(1,10,2000);
        assertTrue("bissexto errado!",data.anoBissexto());
    }
}
