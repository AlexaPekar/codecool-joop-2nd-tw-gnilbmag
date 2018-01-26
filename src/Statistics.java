public class Statistics {


    private double averageMatches=0.0;
    private String runtime=" ";
    private int numOfSimulations=0;


    public double getAverageMatches(){
        return averageMatches;
    }


    public String getRuntime(){
        return runtime;
    }


    public int getNumOfSimulations(){
        return numOfSimulations;
    }


    public void setAverageMatches(double value){
        averageMatches=value;
    }


    public void setRuntime(String value){
        runtime=value;
    }


    public void setNumOfSimulations(int value){
        numOfSimulations=value;
    }

    
}