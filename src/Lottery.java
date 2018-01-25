import java.util.Scanner;
import java.util.Random;

public class Lottery{
    
    Simulation simulation;
    Logger logger;
    double avarageMatches = 0.0;
    Scanner scanner = new Scanner(System.in);
    String[] yourNums = new String[6];

    public Lottery(Simulation simulation,Logger logger){
        this.simulation=simulation;
        this.logger=logger;
    }

    public void inputNumbers(){
        logger.log("Message: ","Please, enter your guesses (6 numbers from 1 to 45) seperated with spaces!");
        String guesses = scanner.nextLine();
        yourNums = guesses.split(" ");
    }

    public void findAverageMatches() {
        double counter = 0.0;
        String[][] allLotteryNums = simulation.previousLotteryNumbers;
        for (String[] lotteryNums : allLotteryNums) {
            for (String num : yourNums) {
                if (Main.contains(lotteryNums, num)) {
                    counter += 1;
                }
            }
        }
        avarageMatches = counter/allLotteryNums.length;
    }

    public void playLottery(){
        int[] yourNums = new int[6];
        int counter=0;
        Random rand = new Random();
        int[] randomNums = new int[6];
        randomNums[0]=rand.nextInt(45)+1;
        for (int j=1; j<6; j++) {
            int n = rand.nextInt(45)+1; 
            while (Main.contains(randomNums,n)) {
                n = rand.nextInt(45)+1;
            }
            randomNums[j] = n;
        } 
        

        inputNumbers();
        for(int l = 0;l<6;l++){
            yourNums[l]=Integer.parseInt(this.yourNums[l]);
        }
        for (int num : yourNums) {
            if (Main.contains(randomNums, num)) {
                counter += 1;
            }
        }
        logger.log("Winning numbers: ","","");
        for(int k : randomNums){
           
            logger.log("",k+" ","");
        }
        logger.log("\nInfo: ","The number of you matches: "+counter);
        
    }
}