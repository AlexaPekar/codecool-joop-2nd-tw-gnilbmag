//Starts the application. Able to configure the round of the simulations to run by taking an argument from the command line.
import java.util.Random;

public class Main {

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

    public static void main(String[] args) {
        /*Simulation simulation = new Simulation();
        Simulator test = new Simulator(simulation);
        test.countNums();*/
/*
        Logger logger = new Logger();
        Simulation simulation = generateSimulation(Integer.parseInt(args[0]));
        Simulator simulator = new Simulator(simulation, logger);
        Result result = simulator.run();
        logger.print(result.getStrategy());
*/      
        Simulation simulation = generateSimulation(args[0]);

        for (String[] x : simulation.previousLotteryNumbers) {
            for (String y : x) {
                System.out.print(y); 
            }
            System.out.println();
        }   

        Simulator simulator = new Simulator(simulation);
        simulator.run();

        

      
    }
}