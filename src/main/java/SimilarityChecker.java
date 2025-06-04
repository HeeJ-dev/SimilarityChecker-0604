import java.util.HashSet;
import java.util.Set;

public class SimilarityChecker {

    public static final int MAX_LENGTH_SCORE = 60;
    public static final int MIN_LENGTH_SCORE = 0;
    public static final int MAX_ALPHA_SCORE = 40;

    public int getScoreStringLength(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int gapLength = Math.abs(s1.length() - s2.length());

        if (s1Length == s2Length)
            return MAX_LENGTH_SCORE;
        if (isMoreThanTwiceLength(s1Length, s2Length))
            return MIN_LENGTH_SCORE;
        if (s1Length > s2Length)
            return getLengthScore(gapLength, s2Length);
        else
            return getLengthScore(gapLength, s1Length);
    }

    private int getLengthScore(double gapLength, int shorterString) {
        return (int) ((1 - gapLength / shorterString) * MAX_LENGTH_SCORE);
    }

    private boolean isMoreThanTwiceLength(int s1Length, int s2Length) {
        return s1Length >= s2Length * 2 || s2Length >= s1Length * 2;
    }

    public int getScoreAlpha(String s1, String s2) {
        return getAlphaScore(s1, s2);
    }

    private int getAlphaScore(String s1, String s2) {
        Set<Character> setS1 = makeSetOfString(s1);
        Set<Character> setS2 = makeSetOfString(s2);
        Set<Character> setTotal = makeSetOfString(s1+s2);
        double sameCount = setS1.size() + setS2.size() - setTotal.size();

        return (int)( sameCount /setTotal.size() * MAX_ALPHA_SCORE);
    }

    private Set<Character> makeSetOfString(String s1) {
        Set<Character> set = new HashSet<>();
        for(int i = MIN_LENGTH_SCORE; i< s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        return set;
    }
}
