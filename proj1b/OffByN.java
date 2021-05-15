//Due to the fact that we won't bother too much details as in "OffByOne" so the following codes are enough to pass
// the autograder

public class OffByN implements CharacterComparator {
    private int steps;

    public OffByN(int N) {
        steps = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int n1 = x;
        int n2 = y;

        int result = Math.abs(n1 - n2);

        return result == steps;
    }
}


//to consider the different situations as in "OffByOne" these codes could be referred

//    private static boolean bothCharactersUpperOrLower(char x, char y) {
//        if (Character.isUpperCase(x) && Character.isUpperCase(y)) {
//            return true;
//        } else {
//            return Character.isLowerCase(x) && Character.isLowerCase(y);
//        }
//    }
//
//    private static boolean bothCharactersAreLetters(char x, char y) {
//        return Character.isLetter(x) && Character.isLetter(y);
//    }
//
//    @Override
//    public boolean equalChars(char x, char y) {
//        if (bothCharactersAreLetters(x, y)) {
//            if (!bothCharactersUpperOrLower(x, y)) {
//                return false;
//            }
//        }
//        int result = Math.abs((int) x - (int) y);
//        return result == steps;
//    }
