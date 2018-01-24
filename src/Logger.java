//It writes information to the console. Only this class can contain calls to System.out.println().

public class Logger {

    //using TimeStamp for example, Use java.util.Date for creating timestamps.
    public void log(String type, String message) {
        System.out.println(type+message);
    }

    
}