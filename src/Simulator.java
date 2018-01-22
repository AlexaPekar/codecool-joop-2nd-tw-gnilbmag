public class Simulator{

    Simulation simulation;
    Logger logger;
    int[] numOccurances = new int[45];   //Counts occurances of each number


    public Simulator(Simulation simulation/*Logger logger*/){
        this.simulation=simulation;
    }


    /*public Result run(){
        
    }*/

    public void countNums(){
        String[][] tmpArray = simulation.load("../data/lotteryNumbers.csv");
        int counter=0;
        for(int i=0;i<tmpArray.length;i++){
            for(int k=0;k<tmpArray[i].length;k++){
                numOccurances[Integer.parseInt(tmpArray[i][k])-1]+=1;
            }
        }

    }
}