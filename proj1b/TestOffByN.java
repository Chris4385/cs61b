import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByN() {

        boolean result = offByN.equalChars('a', 'f');
        assertTrue("Both chars do not differ by 5", result);
    }
}
