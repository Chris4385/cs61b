import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue("Both characters do not differ by one!", offByOne.equalChars('8', '7'));
        assertTrue("Both characters do not differ by one!", offByOne.equalChars('a', 'b'));
        assertTrue("Both characters do not differ by one!", offByOne.equalChars('b', 'a'));
        assertTrue("Both characters do not differ by one!", offByOne.equalChars('%', '&'));
        assertFalse("Both characters do not differ by one!", offByOne.equalChars('a', 'B'));

    }

}
