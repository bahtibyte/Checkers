package checkers;

import java.util.Date;

public class Log {
	public static void log(Object m) {
		System.out.println(getTime()+" "+m);
	}
	
	private static String getTime(){
        Date time = new Date();
        int hour = time.getHours();
        int min = time.getMinutes();
        int sec = time.getSeconds();
        return "["+(hour<10?"0"+hour:hour)+":"+(min<10?"0"+min:min)+":"+(sec<10?"0"+sec:sec)+"]";
    }
}
