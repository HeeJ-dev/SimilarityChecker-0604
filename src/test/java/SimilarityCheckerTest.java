import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void testGetScoreStringLength100Score() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        String s1 = "ADS";
        String s2 = "DSA";
        double actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(60, actual);
    }
    @Test
    void testGetScoreStringLength0Score() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        String s1 = "A";
        String s2 = "BBB";
        double actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerS1() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        String s1 = "AAABB";
        String s2 = "BAA";
        double actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(20, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerS2() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        String s1 = "AA";
        String s2 = "AAE";
        double actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(30, actual);
    }
}