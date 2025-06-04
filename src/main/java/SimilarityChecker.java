import java.util.HashSet;
import java.util.Set;

public class SimilarityChecker {
    public int getScoreStringLength(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int gapLength = Math.abs(s1.length() - s2.length());

        if (s1Length == s2Length)
            return 60;
        if (isMorethanTwiceLength(s1Length, s2Length))
            return 0;
        if (s1Length > s2Length)
            return (int) ((1 - (double) gapLength / s2Length) * 60);
        else
            return (int) ((1 - (double) gapLength / s1Length) * 60);
    }

    private boolean isMorethanTwiceLength(int s1Length, int s2Length) {
        return s1Length >= s2Length * 2 || s2Length >= s1Length * 2;
    }

    public int getScoreAlpha(String s1, String s2) {
        Set<Character> setS1 = new HashSet<>();
        Set<Character> setS2 = new HashSet<>();
        Set<Character> setTotal = new HashSet<>();

        for(int i=0; i<s1.length(); i++) {
            setS1.add(s1.charAt(i));
            setTotal.add(s1.charAt(i));
        }

        for(int i=0; i<s2.length(); i++) {
            setS2.add(s2.charAt(i));
            setTotal.add(s2.charAt(i));
        }

        return (int)((double)(setS1.size() + setS2.size()-setTotal.size())/setTotal.size()*40.0);
    }
}
