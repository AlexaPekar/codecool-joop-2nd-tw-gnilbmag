//Starts the application. Able to configure the round of the simulations to run by taking an argument from the command line.
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    Logger logger;

    public static Simulation generateSimulation(int round) {
        Simulation mySimulation = new Simulation();
        Random rand = new Random();
        int[] randomNums = new int[6]; 
        for(int i=0;i<round;i++){
            for (int j=0; j<6; j++) {
                randomNums[j] = rand.nextInt(45)+1;
            } 
            mySimulation.generateData(randomNums);
        }
        return mySimulation;
    }

    public static int inputCheck(String input,Logger logger){
        Scanner reader = new Scanner(System.in);
        int n=0;
        try{
           n = Integer.parseInt(input);
            if(n<0){
                logger.log("Error: ","Input can not be negative!");
                logger.log("","Please, enter new input!");
                String s = reader.next();
                n = Integer.parseInt(s);
                if(n<0){
                    inputCheck(input, logger);
                }
                
            }
        }catch(Exception e){
            logger.log("Error: ", "Wrong input type!(Expected input is a number.)");
            logger.log("","Please, enter new input!");
            String s = reader.next();
            
            try{n = Integer.parseInt(s);}catch(Exception l){inputCheck(input,logger);}
            
        }  
        return n;
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        int n = inputCheck(args[0],logger);
        
        Simulation simulation = generateSimulation(n);
        Simulator simulator = new Simulator(simulation,logger);
        
        simulator.run();

        

      
    }
}