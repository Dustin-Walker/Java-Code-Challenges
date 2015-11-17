import static org.junit.Assert.*;

/**
 * Created by user on 11/17/15.
 */
public class GameOfThreesTest {

    @org.junit.Test
    public void testGameOfThrees() throws Exception {
        org.junit.Assert.assertEquals("-31337357\n" +
                "-10445786\n" +
                "-3481929\n" +
                "-1160643\n" +
                "-386881\n" +
                "-128960\n" +
                "-42987\n" +
                "-14329\n" +
                "-4776\n" +
                "-1592\n" +
                "-531\n" +
                "-177\n" +
                "-59\n" +
                "-20\n" +
                "-7\n" +
                "-2\n" +
                "-1\n" +
                "Solution found for -31337357.", new GameOfThrees().gameOfThrees(-31337357));
    }
}