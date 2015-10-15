import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10/15/15.
 */
public class BowlingTest {

    @Test
    public void testCalculateScore() throws Exception {
        Bowling bowling = new Bowling();
        String allNines = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
        String allStrikes = "X X X X X X X X X XXX  ";
        String sampleGame137 = "X -/ X 5- 8/ 9- X 81 1- 4/X";
        String sampleGame140 = "62 71 X 9- 8/ X X 35 72 5/8";
        String sampleGame137v2 = "X -/ X 5- 8/ 9- X 81 1- X5/";
        assertEquals(90, bowling.calculateScore(allNines));
        assertEquals(300, bowling.calculateScore(allStrikes));
        assertEquals(137, bowling.calculateScore(sampleGame137));
        assertEquals(140, bowling.calculateScore(sampleGame140));
        assertEquals(137, bowling.calculateScore(sampleGame137v2));
    }
}