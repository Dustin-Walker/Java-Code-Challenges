import java.util.Collections;

public class Bowling {

    private static final int CHARACTER_OFFSET = -48;
    private static final int STRIKE_VALUE = 10;
    private static final int SPARE_VALUE = 10;
    private static final int NUMBER_OF_FRAMES = 10;

    /**
     * Method calculates a player's score based on the input string. Use X for strikes, / for spares, and - for missed throws.
     * @param scoreLine String representing score such as "X -/ X 5- 8/ 9- X 81 1- 4/X"
     * @return Player's score for the game
     */
    public int calculateScore(String scoreLine){
        if (scoreLine.trim().split(" ").length != NUMBER_OF_FRAMES)
            throw new IllegalArgumentException("Illegal argument format.");

        char[] scoreArray = scoreLine.replaceAll(" ","").toCharArray();
        int[] valueArray = new int[scoreArray.length];
        int numberOfThrows = scoreArray.length;
        for (int throwIndex = numberOfThrows-1; throwIndex >= 0; throwIndex--){
            switch (scoreArray[throwIndex]){
                case 'X':
                    if (throwIndex >= numberOfThrows-2){ // Last two throws is a strike
                        valueArray[throwIndex] = 0;
                    } else {
                        if (throwIndex == numberOfThrows - 3 && scoreLine.split(" ")[scoreLine.split(" ").length-1].charAt(0) == 'X') {
                            valueArray[throwIndex] = STRIKE_VALUE + rollAnalyzer(scoreArray[throwIndex + 1]) + rollAnalyzer(scoreArray[throwIndex + 2]);
                            if (scoreLine.split(" ")[scoreLine.split(" ").length-1].charAt(2) == '/')
                                valueArray[throwIndex] = STRIKE_VALUE + SPARE_VALUE;
                            valueArray[throwIndex+1] = 0; valueArray[throwIndex+2] = 0;
                        } else { // Any other throw is a strike
                            valueArray[throwIndex] = STRIKE_VALUE + rollAnalyzer(scoreArray[throwIndex + 1]) + rollAnalyzer(scoreArray[throwIndex + 2]);
                        }
                    }
                    break;
                case '/':
                    if (throwIndex == numberOfThrows-2){
                        // Last throw is a spare
                        valueArray[throwIndex] = (10-rollAnalyzer(scoreArray[throwIndex-1])) + rollAnalyzer(scoreArray[throwIndex+1]);
                        valueArray[throwIndex+1] = 0;
                    } else if (throwIndex == numberOfThrows-1){ // Spare on last throw
                        valueArray[throwIndex] = (10-rollAnalyzer(scoreArray[throwIndex-1]));
                    } else {
                        valueArray[throwIndex] = (10-rollAnalyzer(scoreArray[throwIndex-1])) + rollAnalyzer(scoreArray[throwIndex+1]);
                    }
                    break;
                case '-':
                    valueArray[throwIndex] = 0;
                    break;
                default:
                    valueArray[throwIndex] = rollAnalyzer(scoreArray[throwIndex]);
                    break;
            }
        }

        int sum = 0;
        for (int throwValue : valueArray)
            sum += throwValue;

        return sum;
    }

    /**
     * @param roll Value or mark to analyze
     * @return Numerical score for the mark
     */
    private int rollAnalyzer(char roll){
        switch (roll){
            case 'X': return STRIKE_VALUE;
            case '/': return SPARE_VALUE;
            case '-': return 0;
            default: return ((int) roll + CHARACTER_OFFSET);
        }
    }
}
