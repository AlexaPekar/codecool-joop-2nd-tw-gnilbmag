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

    public int[] collectWinningNumbers(int[] numberOccurences) {
        int first = 0, second = 0, third = 0, fourth = 0, fifth = 0, sixth = 0;
        for (int i = 0; i < numberOccurences.length; i++) {
                if (numberOccurences[i] > first) {
                    sixth = fifth;
                    fifth = fourth;
                    fourth = third;
                    third = second;
                    second = first;
                    first = numberOccurences[i];
                }
                else if (numberOccurences[i] > second) {
                    sixth = fifth;
                    fifth = fourth;
                    fourth = third;
                    third = second;
                    second = i+1;
                }
                else if (numberOccurences[i] > third) {
                    sixth = fifth;
                    fifth = fourth;
                    fourth = third;
                    third = i+1;
                }
                else if (numberOccurences[i] > fourth) {
                    sixth = fifth;
                    fifth = fourth;
                    fourth = i+1;
                }
                else if (numberOccurences[i] > fifth) {
                    sixth = fifth;
                    fifth = i+1;
                }
                else if (numberOccurences[i] > sixth) {
                    sixth = i+1;
                }
        }
        int [] winningNumbers = {first, second, third, fourth, fifth, sixth};
        int [] foundWinningNumbers = new int[6];
        for (int i = 0; i < numberOccurences.length; i++) {
            for (int j = 0; j < winningNumbers.length; j++) {
                if (numberOccurences[i] == winningNumbers[j]) {
                    if (foundWinningNumbers[j] == 0) {
                        foundWinningNumbers[j] = i+1;
                        System.out.println(foundWinningNumbers[j]);
                    }
                }   
            }
        }
        return foundWinningNumbers;
    }


}