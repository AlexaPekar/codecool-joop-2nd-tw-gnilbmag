import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Simulation {


    String[][] previousLotteryNumbers;


    public void generateData(int[] winningNumbers) {
        String[][] tempArray = load("../data/simulationResults.csv");
        previousLotteryNumbers = new String[tempArray.length + 1][6];
        int counter = 0;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("../data/simulationResults.csv"));
            StringBuilder sb = new StringBuilder();
            int columnCounter = 0;
            for (String[] elements : tempArray) {
                previousLotteryNumbers[counter] = tempArray[counter];
                counter++;
                for (String element : elements) {
                    sb.append(element);
                    columnCounter++;
                    if (columnCounter != 6) {
                        sb.append(";");
                    }
                }
                sb.append("\n");
                columnCounter = 0;
            }
            for (int number : winningNumbers) {
                sb.append(Integer.toString(number));
                columnCounter++;
                if (columnCounter != 6){
                    sb.append(";");
                }
            }
            previousLotteryNumbers[previousLotteryNumbers.length - 1] = sb.toString().split(";");
            sb.append("\n");
        String myStr = sb.toString();
        myStr = myStr.substring(0, myStr.length() - 1);
        bw.write (myStr);
        bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public int lineCounter(String csvPath) {
        int counter = 0;
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            while ((line = reader.readLine()) != null) {
                counter++;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return counter;
    }

    public String[][] load(String csvPath) {
        int numOFLines = lineCounter(csvPath);
        int lineNumber = 0;
        String line = "";
        String[][] lotteryNumbers = new String[numOFLines][];
        try (BufferedReader lotteryNumbersReader = new BufferedReader(new FileReader(csvPath))) {
            while ((line = lotteryNumbersReader.readLine()) != null) {
                lotteryNumbers[lineNumber] = line.split(";");
                lineNumber++;
            }
            lotteryNumbersReader.close();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return lotteryNumbers;
    }

    
}
