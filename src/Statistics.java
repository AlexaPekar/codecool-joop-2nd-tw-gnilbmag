public class Statistics {
    private double averageMatches ;
    private String runtime;
    private int numOfSimulations;

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