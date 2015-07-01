public class Main {

    public static void main(String[] args) {
	    System.out.println("nth     Sequence");
        System.out.println("===========================================================================");
        int[] morseSequence = new int[1];
        morseSequence[0]=0;
        for(int n=0;n<=6;n++){
            System.out.print(n+"       ");
            arrayPrinter(morseSequence);
            morseSequence = morseIterator(morseSequence);
            System.out.println();
        }
    }

    public static int[] morseIterator(int[] originalMorseSequence){
        /**
         * Returns the next iteration in the Thue-Morse sequence.
         * The Thue-Morse sequence takes the input and outputs the
         * input followed by the complement of the input.
         * @param input Morse sequence to be iterated, should only contains 1s and 0s
         * @return Array containing next iteration in the Thue-Morse sequence
         */
        int[] tmpPrefix = originalMorseSequence.clone(), tmpSuffix = originalMorseSequence.clone();
        for(int i=0;i<tmpSuffix.length;i++)
            tmpSuffix[i] = (tmpSuffix[i] == 0) ? 1 : 0;
        int[] returnArray = new int[tmpPrefix.length+tmpPrefix.length];
        System.arraycopy(tmpPrefix, 0, returnArray, 0, tmpPrefix.length);
        System.arraycopy(tmpSuffix, 0, returnArray, tmpPrefix.length, tmpPrefix.length + tmpSuffix.length - tmpPrefix.length);
        return returnArray;
    }

    public static void arrayPrinter(int[] input){
        for (int i : input)
            System.out.print(i);
    }
}
