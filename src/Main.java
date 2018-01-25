//Starts the application. Able to configure the round of the simulations to run by taking an argument from the command line.
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class Main {
    Logger logger;

    public static boolean contains(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(String[] nums, String num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals(num)) {
                return true;
            }
        }
        return false;
    }

    public static Simulation generateSimulation(int round) {
        Simulation mySimulation = new Simulation();
        Random rand = new Random();
        int[] randomNums = new int[6];
        for(int i=0;i<round;i++){
            randomNums[0] = rand.nextInt(45)+1;
            for (int j=1; j<6; j++) {
                int n = rand.nextInt(45)+1; 
                while (contains(randomNums,n)) {
                    n = rand.nextInt(45)+1;
                }
                randomNums[j] = n;
            } 
            mySimulation.generateData(randomNums);
        }
        return mySimulation;
    }

    public static int checkInput(String input,Logger logger){
        Scanner reader = new Scanner(System.in);
        int n=0;
        try{
           n = Integer.parseInt(input);
            if(n<0){
                logger.log("Error: ","Input can not be negative!");
                logger.log("Message: ","Please, enter new input!");
                String s = reader.next();
                n = Integer.parseInt(s);
                if(n<0){
                    checkInput(input, logger);
                }
                
            }
        }catch(Exception e){
            logger.log("Error: ", "Wrong input type!(Expected input is a number.)");
            logger.log("Message: ","Please, enter new input!");
            String s = reader.next();
            
            try{
                n = Integer.parseInt(s);
                if(n<0){
                    checkInput(input, logger);
                }
            }catch(Exception l){
                checkInput(input,logger);
            }
            
        }  
        return n;
    }

    public static void main(String[] args) {
        Date before = new Date();
        Date after = new Date();
        Logger logger = new Logger();
        int n = checkInput(args[0],logger);
     
        long startTime = System.nanoTime();
        Simulation simulation = generateSimulation(n);
        Simulator simulator = new Simulator(simulation,logger);
       
        simulator.run();
        long endTime = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("0.00");
        String runtimeSeconds = formatter.format((endTime-startTime)/1000000000.0);
        
        logger.log("Simulation runtime: ", runtimeSeconds+" s");

        Lottery lottery = new Lottery(simulation, logger);
        lottery.inputNumbers();
        lottery.findAverageMatches();
        logger.log("Info: ", "Your average match in lottery: " + formatter.format((double)lottery.avarageMatches));
        lottery.playLottery();
        

        
    }   
}
