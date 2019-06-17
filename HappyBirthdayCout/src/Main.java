import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
        int age = 23;
        int year = calendar.get(Calendar.YEAR);

        for (int i = age; i >= 0; i--)
        {
            calendar.set(year-i, Calendar.MARCH, 2);
            System.out.println((age - i) + " - " + dateFormat.format(calendar.getTime()));
        }

    }
}
