import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        Date date = new Date(0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.HOUR, 0);

        DateFormat dateFormat = new SimpleDateFormat("H:mm:ss");
        calendar.getTime().setTime(a * 1000);
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
