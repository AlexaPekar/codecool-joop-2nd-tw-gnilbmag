//Starts the application. Able to configure the round of the simulations to run by taking an argument from the command line.

public class Main {

    public Simulation generateSimulation(int round) {
        return null;
    }

    public static void main(String[] args) {
        
        Simulation simulation = new Simulation();
        Simulator test = new Simulator(simulation);
        /*String [][] nums = simulation.load("../data/lotteryNumbers.csv");
        for (String[] num : nums) {
            for (String nu : num) {
                System.out.print(nu + " ");
            }
            System.out.println();
        }*/

        test.countNums();

        for(int i=0;i<test.numOccurances.length;i++){
            System.out.println(test.numOccurances[i]);
        }

    }
}