import java.util.Scanner;

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

    


}