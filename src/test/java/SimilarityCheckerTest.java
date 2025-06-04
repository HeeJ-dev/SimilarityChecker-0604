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
        String A = "ADS";
        String B = "DSA";
        int actual = similarityChecker.getScoreStringLength(A, B);
        assertEquals(60, actual);
    }
    @Test
    void testGetScoreStringLength0Score() {
        String A = "A";
        String B = "BBB";
        int actual = similarityChecker.getScoreStringLength(A, B);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerA() {
        String A = "AAABB";
        String B = "BAA";
        int actual = similarityChecker.getScoreStringLength(A, B);
        assertEquals(20, actual);
    }
    @Test
    void testGetScoreStringLengthPartialScoreLongerB() {
        String A = "AA";
        String B = "AAE";
        int actual = similarityChecker.getScoreStringLength(A, B);
        assertEquals(30, actual);
    }

    @Test
    void testGetScoreAlpha100ScoreSameLength() {
        String A = "ASD";
        String B = "DSA";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha100ScoreLongerA() {
        String A = "AAABB";
        String B = "BA";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha100ScoreLongerB() {
        String A = "BA";
        String B = "AAABB";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(40, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreSameLength() {
        String A = "AA";
        String B = "BB";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreLongerA() {
        String A = "AA";
        String B = "B";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlpha0ScoreLongerB() {
        String A = "A";
        String B = "BB";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(0, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreSameLength() {
        String A = "AAC";
        String B = "AAE";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(13, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreLongerA() {
        String A = "AAE";
        String B = "AA";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(20, actual);
    }
    @Test
    void testGetScoreAlphaPartialScoreLongerB() {
        String A = "AAU";
        String B = "AAAB";
        int actual = similarityChecker.getScoreAlpha(A, B);
        assertEquals(13, actual);
    }
}