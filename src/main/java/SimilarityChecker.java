public class SimilarityChecker {
    public double getScoreStringLength(String s1, String s2) {
        if(s1.length() == s2.length()){
            return 60;
        }
        if(s1.length() == s2.length()*2 || s2.length() == s1.length()*2) {
            return 0;
        }
        else {
            if(s1.length()>s2.length()) {
                return  Math.round(((1-(double)(s1.length()-s2.length())/s2.length())*60));
            }
            else {
                return  Math.round(((1-(double)(s2.length()-s1.length())/s1.length())*60));
            }
        }
    }
}
