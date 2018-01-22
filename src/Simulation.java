// Writes a simulated round to a file
//and loads the content of an instance 
//of a Simulation and returns it
import java.io.*;

public class Simulation{


    public Simulation(){
    }

    public void generateData(){

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