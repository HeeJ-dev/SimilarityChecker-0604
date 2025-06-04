import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    SimilarityChecker similarityChecker;

    @BeforeEach
    void setUp() {
        similarityChecker = new SimilarityChecker();
    }

    @Test
    void testGetScoreStringLength100Score() {
        String s1 = "ADS";
        String s2 = "DSA";
        int actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(60, actual);
    }
    @Test
    void testGetScoreStringLength0Score() {
        String s1 = "A";
        String s2 = "BBB";
        int actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerS1() {
        String s1 = "AAABB";
        String s2 = "BAA";
        int actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(20, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerS2() {
        String s1 = "AA";
        String s2 = "AAE";
        int actual = similarityChecker.getScoreStringLength(s1, s2);
        assertEquals(30, actual);
    }

    @Test
    void testGetScoreAlpha100ScoreSameLength() {
        String s1 = "ASD";
        String s2 = "DSA";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha100ScoreLongerS1() {
        String s1 = "AAABB";
        String s2 = "BA";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha100ScoreLongerS2() {
        String s1 = "BA";
        String s2 = "AAABB";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreSameLength() {
        String s1 = "AA";
        String s2 = "BB";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreLongerS1() {
        String s1 = "AA";
        String s2 = "B";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreLongerS2() {
        String s1 = "A";
        String s2 = "BB";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreSameLength() {
        String s1 = "AAC";
        String s2 = "AAE";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(13, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreLongerS1() {
        String s1 = "AAE";
        String s2 = "AA";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(20, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreLongerS2() {
        String s1 = "AA";
        String s2 = "AAE";
        int actual = similarityChecker.getScoreAlpha(s1, s2);
        assertEquals(20, actual);
    }
}