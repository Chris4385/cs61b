import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    @Test
    public void testOffByN() {
        OffByN N = new OffByN(5);
        boolean result = N.equalChars('a', 'f');
        boolean result1 = N.equalChars('A', 'f');
        assertTrue("Both chars do not differ by 5", result);
        assertFalse("Both chars do not differ by 5", result1);
    }
}
