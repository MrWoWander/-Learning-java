import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String alphaviteENG = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphaviteRUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        /*getCharCode(alphaviteENG);
        getCharCode(alphaviteRUS);*/

        //getFIO1();

        getFIO2();

        System.out.println();

        getPhone();
    }

    public static void getCharCode(String text) {

        for (var c : text.toCharArray()) {
            System.out.println("Символ " + c + ". Код: " + (int) c);
        }

        System.out.println();
    }

    public static String scannerFIO() {

        System.out.printf("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static void getFIO1() {
        boolean isFIO = true;

        while (isFIO) {

            String FIO = scannerFIO();
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

    public static void getFIO2() {

        boolean isFIO = true;

        while (isFIO) {

            String FIO = scannerFIO();
            String surname = "";
            String name = "";
            String otchestvo = "";

            String[] sArray = FIO.split("\\s+");

            if (sArray.length < 1) {
                System.out.println("Вы ничего не ввели");
                continue;
            } else if (sArray.length > 3) {
                System.out.println("Неправильный формат. Требуется ввести ФИО");
                continue;
            } else if (sArray.length == 3) {
                surname = sArray[0];
                name = sArray[1];
                otchestvo = sArray[2];
            } else if (sArray.length == 2) {
                surname = sArray[0];
                name = sArray[1];
            } else {
                surname = sArray[0];
            }

            System.out.println("Фамилия: " + surname);

            if (!name.isEmpty())
                System.out.println("Имя: " + name);
            if (!otchestvo.isEmpty())
                System.out.println("Отчество: " + otchestvo);

            isFIO = false;
        }
    }

    public static void getPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите телефон: ");
        String phone = scanner.nextLine().replaceAll("[^0-9]", "");


        if (phone.length() < 11)
        {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append('7');
            stringBuilder.append(phone);
            phone = stringBuilder.toString();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < phone.length(); i++)
        {
            if (i == 0) {
                stringBuilder.append('+');
                if (phone.charAt(i) == '8') {
                    stringBuilder.append("7 (");
                    continue;
                }
                stringBuilder.append(phone.charAt(i) + " (");
            } else if (i == 3) {
                stringBuilder.append(phone.charAt(i) + ") ");
            } else if (i == 6 || i == 8) {
                stringBuilder.append(phone.charAt(i) + "-");
            } else {
                stringBuilder.append(phone.charAt(i));
            }
        }

        phone = stringBuilder.toString();

        System.out.println("Ваш номер: " + phone);
    }
}
