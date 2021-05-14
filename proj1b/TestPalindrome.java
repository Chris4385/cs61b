import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

//    @Test
//    public void testIsEven() {
//        boolean result = Palindrome.isEven("hello");
//        assertFalse("This is NOT an even numbered string", result);
//    }

//    @Test
//    public void testUpperLimitForLooping() {
//        int upperLimit = palindrome.setUpperLimitForLooping("happy");
//        int upperLimit1 = palindrome.setUpperLimitForLooping("ha");
//        int upperLimit2 = palindrome.setUpperLimitForLooping("happy-i");
//        assertEquals(upperLimit, 2);
//        assertEquals(upperLimit1, 1);
//        assertEquals(upperLimit2, 3);
//    }

    @Test
    public void testIsPalindrome() {
        boolean result = palindrome.isPalindrome("racecar");
        boolean result1 = palindrome.isPalindrome("xyz");
        boolean result2 = palindrome.isPalindrome("xxyxx");

        assertTrue("It is not a palindrome", result);
        assertFalse("It is not a palindrome", result1);
        assertTrue("It is not a palindrome", result2);
    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator obo = new OffByOne();
        boolean result = palindrome.isPalindrome("flake", obo);
        boolean result1 = palindrome.isPalindrome("zlake", obo);
        boolean result2 = palindrome.isPalindrome("z", obo);
        assertTrue("Is Not an off-by-one palindrome", result);
        assertTrue("Is Not an off-by-one palindrome", result2);
        assertFalse("Is an off-by-one palindrome", result1);
    }

//    @Test
//    public void testIsPalindromeOffByN() {
//        CharacterComparator obo = new OffByOne(5);
//
//    }
}
