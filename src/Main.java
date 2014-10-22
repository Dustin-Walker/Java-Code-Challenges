import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SmartStackList smartStackList = new SmartStackList();
        Random rnd = new Random();
        for(int i=0;i<40;i++)
            smartStackList.push(rnd.nextInt(2000)-1000);
        smartStackList.displayOrdered();
        smartStackList.displayStack();
        int x = rnd.nextInt(2000)-1000;
        smartStackList.removeGreater(x);
        smartStackList.displayOrdered();
        smartStackList.displayStack();
        int n = smartStackList.getSize();
        for(int j=0;j<n/2;j++)
            smartStackList.pop();
        smartStackList.displayOrdered();
        smartStackList.displayStack();
    }
}
