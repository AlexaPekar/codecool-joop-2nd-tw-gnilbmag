import java.util.Scanner;

public class Lottery{
    
    Simulation simulation;
    Logger logger;
    int matches=0;
    Scanner scanner = new Scanner(System.in);
    int[] yourNums = new int[6];

    public Lottery(Simulation simulation,Logger logger){
        this.simulation=simulation;
        this.logger=logger;
    }

    public void inputNumbers(){
        logger.log("Message: ","Please, enter your guesses (6 numbers from 1 to 45) seperated with spaces!");
        String guesses = scanner.nextLine();
        yourNums = guesses.split(" ");
    }

    


}