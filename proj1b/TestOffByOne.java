import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void TestOffByOne() {
        assertTrue("Both characters do not differ by one!", offByOne.equalChars('c', 'b'));

    }

}
