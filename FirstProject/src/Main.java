import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date data = new Date();
        System.out.println(format.format(data));

    }
}
