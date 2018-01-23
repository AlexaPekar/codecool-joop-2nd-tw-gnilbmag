import java.util.Arrays;

public class Simulator{

    Simulation simulation;
    Logger logger;
    int[] numOccurances = new int[45];   //Counts occurances of each number


    public Simulator(Simulation simulation/*Logger logger*/){
        this.simulation=simulation;
    }

    /*public Result run(){
        
    }*/

    public void countNums() {
        String[][] tmpArray = simulation.load("../data/lotteryNumbers.csv");
        int counter = 0;
        for(int i = 0; i < tmpArray.length;i++) {
            for(int k = 0; k < tmpArray[i].length;k++) {
                numOccurances[Integer.parseInt(tmpArray[i][k]) - 1] += 1;
            }
        }
    }

    public int[] collectWinningNumbers(int[] numberOccurences) {
        LotteryNumbers[] numbers = new LotteryNumbers[45];
        for (int i = 0; i < numberOccurences.length; i++) {
             numbers[i] = new LotteryNumbers(i + 1, numberOccurences[i]);
        }
        
        LotteryNumbers tmp;
        
        for(int x = 0; x < numbers.length; x++) {
            for(int l = 0; l < numbers.length - 1; l++){
                if(numbers[l].occurance < numbers[l+1].occurance) {
                    tmp = numbers[l];
                    numbers[l] = numbers[l+1];
                    numbers[l+1] = tmp;
                }
            }
        }

        int [] result = new int[6];
        for(int r = 0; r < 6; r++) {
            result[r] = numbers[r].number;
        }
        return result;
    }
}