public class SimilarityChecker {
    public double getScoreStringLength(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int gapLength = Math.abs(s1.length() - s2.length());

        if(s1Length == s2Length)
            return 60;
        if(s1Length >= s2Length * 2 || s2Length >= s1Length * 2)
            return 0;
        if(s1Length > s2Length)
            return  Math.round(((1-(double) gapLength/ s2Length)*60));
        else
            return  Math.round(((1-(double) gapLength/ s1Length)*60));
    }
}
