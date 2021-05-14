public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int n1 = x;
        int n2 = y;
        int result = Math.abs(n1 - n2);

        return result == 1;
    }
}
