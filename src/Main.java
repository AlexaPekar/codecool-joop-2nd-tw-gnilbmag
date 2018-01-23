//Starts the application. Able to configure the round of the simulations to run by taking an argument from the command line.

public class Main {

    public static Simulation generateSimulation(int round) {
        Simulation mySimulation = new Simulation();
        mySimulator.countNums(); 
        for(int i=0;i<round;i++){
            mySimulator.run();
        }
        
        
        return mySimulation;
    }

    public static void main(String[] args) {
        /*Simulation simulation = new Simulation();
        Simulator test = new Simulator(simulation);
        test.countNums();*/

        Logger logger = new Logger();
        Simulation simulation = generateSimulation(Integer.parseInt(args[0]));
        Simulator simulator = new Simulator(simulation, logger);
        Result result = simulator.run();
        logger.print(result.getStrategy());
        

        

      
    }
}