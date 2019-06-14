import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String alphaviteENG = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphaviteRUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        getCharCode(alphaviteENG);
        getCharCode(alphaviteRUS);

        boolean isFIO = true;

        while (isFIO) {

            String FIO = getFIO();
            String surname = "";
            String name = "";
            String otchestvo = "";

            System.out.println();

            var delSpaceIndex = FIO.replaceAll("\\s+", "").length();

            if (delSpaceIndex + 2 == FIO.length()) {
                surname = FIO.substring(0, FIO.indexOf(' '));

                name = FIO.substring(FIO.indexOf(' ') + 1, FIO.lastIndexOf(' '));

                otchestvo = FIO.substring(FIO.lastIndexOf(' ') + 1);

            } else if (delSpaceIndex + 1 == FIO.length()) {
                surname = FIO.substring(0, FIO.indexOf(' '));

                name = FIO.substring(FIO.indexOf(' ') + 1);

            } else if (delSpaceIndex == FIO.length()) {
                surname = FIO;

            } else {

                System.out.println("Неправильный формат. Требуется ввести ФИО");
                continue;
            }

            if (!surname.isEmpty())
                System.out.println("Фамилия: " + surname);
            else {
                System.out.println("Вы ничего не ввели");
                continue;
            }

            if (!name.isEmpty())
                System.out.println("Имя: " + name);
            if (!otchestvo.isEmpty())
                System.out.println("Отчество: " + otchestvo);

            isFIO = false;
        }


    }

    public static void getCharCode(String text) {

        for (var c : text.toCharArray()) {
            System.out.println("Символ " + c + ". Код: " + (int) c);
        }

        System.out.println();
    }

    public static String getFIO() {

        System.out.printf("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
