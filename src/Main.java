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


    public Simulation generateSimulation(int round) {
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


    public int checkInput(String input,Logger logger) {
        Scanner reader = new Scanner(System.in);
        int n = 0;
        try {
           n = Integer.parseInt(input);
            if (n<0) {
                logger.log("Error: ","Input can not be negative!");
                logger.log("Message: ","Please, enter new input!");
                String s = reader.next();
                n = Integer.parseInt(s);
                if(n < 0) {
                    checkInput(input, logger);
                }  
            }
        } catch (Exception e) {
            logger.log("Error: ", "Wrong input type!(Expected input is a number.)");
            logger.log("Message: ","Please, enter new input!");
            String s = reader.next();
            
            try {
                n = Integer.parseInt(s);
                if (n < 0) {
                    checkInput(input, logger);
                }
            } catch (Exception l) {
                checkInput(input,logger);
            } 
        }
        return n;
    }


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Main myMain = new Main();
        Statistics statistics = new Statistics();
   
        Logger logger = new Logger();

        int n = myMain.checkInput(args[0],logger);
        statistics.setNumOfSimulations(n);
        long startTime = System.nanoTime();
        Simulation simulation = myMain.generateSimulation(n);
        Simulator simulator = new Simulator(simulation,logger);

        NumberFormat formatter = new DecimalFormat("0.00");

        Lottery lottery = new Lottery(simulation, logger);

        int counter = 0;
        while (true) {
            clearScreen();
            simulator.run();
            long endTime = System.nanoTime();
            String runtimeSeconds = formatter.format((endTime-startTime)/1000000000.0);
            if(counter == 0){
                statistics.setRuntime(runtimeSeconds);
            }
            counter++;

            logger.log("\nSimulation runtime: ", statistics.getRuntime() + " s\n");
            logger.log("\n", "(1) Test the program's efficiency");
            logger.log("", "(2) Play a lottery");
            logger.log("", "(3) Statistics");
            logger.log("", "(0) Exit");

            logger.log("\n", "Please, choose an option: ", "");
            int input = reader.nextInt();            
            String back;

            switch(input) {
                case 1:
                    lottery.findAverageMatches();
                    statistics.setAverageMatches(lottery.avarageMatches);
                    logger.log("\n\nMessage: ", "Enter any key to go back!","");
                    back = reader.next();
                break;
                case 2:
                    clearScreen();
                    lottery.playLottery();
                    logger.log("\n\nMessage: ", "Enter any key to go back!","");
                    back = reader.next();
                break;
                case 3:
                    clearScreen();
                    logger.log("\n\nInfo: ", "Number of simulations were run: " + statistics.getNumOfSimulations());
                    logger.log("\nInfo: ", "Runtime of the simulation: " + statistics.getRuntime());
                    logger.log("\nInfo: ", "Average of your matches in all the simulations: " + statistics.getAverageMatches());
                    logger.log("\n\nMessage: ", "Enter any key to go back!","");
                    back = reader.next();
                break;
                case 0:
                    System.exit(0);
                break;
            }
        }
    }

    
}
