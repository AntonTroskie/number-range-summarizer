import com.numberrangesummarizer.Summarizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SummarizerTest {

    @Test
    @DisplayName("Test to see if unacceptable characters or wrong delimiters are handled.")
    void testHandleCharacters() {
        Summarizer testSummarizer = new Summarizer();
        Assertions.assertEquals(Collections.EMPTY_LIST, testSummarizer.collect("1;2;3;4;5;6;7;8"));
        Assertions.assertEquals(Collections.EMPTY_LIST, testSummarizer.collect("1,f,3,-4,5,6.7,7,8"));
    }

    @Test
    @DisplayName("Test to see if randomly scattered spacing, multiple consecutive delimiters, and multiple instances of the same value are handled.")
    void testAutoFormatInput() {
        Summarizer testSummarizer = new Summarizer();
        List<Integer> testList = Arrays.asList(1,2,3,5,9);
        Assertions.assertEquals(testList, testSummarizer.collect("1,  2,      ,3  ,5,  9"));
        Assertions.assertEquals(testList, testSummarizer.collect(",1,  2,      ,3  ,5,,9,"));
        Assertions.assertEquals(testList, testSummarizer.collect("1,1,1,  2,2      ,3  ,5,  9"));
    }

    @Test
    @DisplayName("Test to see if the correct output is obtained.")
    void testCorrectOutput() {
        Summarizer testSummarizer = new Summarizer();
        String testOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        Assertions.assertEquals(testOutput, testSummarizer.summarizeCollection(testSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31")));
        Assertions.assertEquals(testOutput, testSummarizer.summarizeCollection(testSummarizer.collect("1 ,  3,  6,  7, 8,  12,  13,  14  ,15, 21,  22,23,24,31")));
        Assertions.assertEquals(testOutput, testSummarizer.summarizeCollection(testSummarizer.collect(",1,, 3,6   ,,7,8,,  12,13,  ,,14,15,21  ,,22,23, 24,31, ")));
        Assertions.assertEquals(testOutput, testSummarizer.summarizeCollection(testSummarizer.collect(",1,1,1,, 3,6   ,,7,7,7,7,8,,  12,13,  ,,14,15,15,15,21  ,,22,23, 24,31, ")));
        Assertions.assertEquals("", testSummarizer.summarizeCollection(testSummarizer.collect("1;3;6;7;8;12;13;14;15;21;22;23;24;31")));
        Assertions.assertEquals("", testSummarizer.summarizeCollection(testSummarizer.collect("1,f,6,7.2,8,12,13,14,-15,21,22,23,24,31")));
    }
}