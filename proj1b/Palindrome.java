public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
//        Deque<Character> d = new LinkedListDeque<>();
        Deque<Character> d = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }


    public boolean isPalindrome(String word) {

        Deque d = wordToDeque(word);
        int dequeSize = d.size();
        int upperLimit = word.length() / 2;

        if (dequeSize <= 1) {
            return true;
        }


        for (int i = 0; i < upperLimit; i++) {
            if (d.get(i) != d.get(dequeSize - i - 1)) {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque<Character> d = wordToDeque(word);
        int dequeSize = d.size();
        int upperLimit = word.length() / 2;

        if (dequeSize <= 1) {
            return true;
        }
        for (int i = 0; i < upperLimit; i++) {
            if (!cc.equalChars(d.get(i), d.get(dequeSize - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
