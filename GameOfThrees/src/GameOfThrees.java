public class GameOfThrees {

    // From: https://www.reddit.com/r/dailyprogrammer/comments/3r7wxz/20151102_challenge_239_easy_a_game_of_threes/


    /**
     *
     * @param input Value to start with
     * @return String displaying the game progression
     */
    public String gameOfThrees(int input) {
        String originalInput = String.valueOf(input);
        StringBuilder output = new StringBuilder(String.valueOf(input+"\n"));
        //System.out.println(input);
        while (input != 1 && input != 0 && input != -1){
            input = divideByThree(input);
            //System.out.println(input);
            output.append(input+"\n");
        }
        if (input == 0)
            return output.append("No solution for ").append(originalInput).append(".").toString();
        if (input == 1 || input == -1)
            return output.append("Solution found for ").append(originalInput).append(".").toString();
        return null;
    }

    private int divideByThree(int input) {
        if (input % 3 == 0)
            return input / 3;
        if ((input-1) % 3 == 0)
            return (input-1) / 3;
        if ((input+1) % 3 == 0)
            return (input+1) / 3;
        return 0;
    }


}
