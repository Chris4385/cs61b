public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int n1, n2;
        if (Character.isLetter(x) && Character.isLetter(y)) {
            n1 = Character.toLowerCase(x);
            n2 = Character.toLowerCase(y);
        } else {
            n1 = x;
            n2 = y;
        }
        int result = Math.abs(n1 - n2);
        return result == 1;
    }
}
