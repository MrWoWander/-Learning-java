import java.util.HashSet;
import java.util.Scanner;

public class Loader {
    private static HashSet<String> dataEmail = new HashSet<>();

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в базу данных Email!\n");

        boolean isWork = true;

        String menuText = "Вы можете ввести команды:" +
                "\n\t1. LIST - показать список команд" +
                "\n\t2. ADD YYYY - добавить задачу, YYYY - тело задания" +
                "\n\t3. MENU - показать список команд" +
                "\n\t4. EXIT - выход из программы\n";

        System.out.println(menuText);

        while (isWork)
        {
            System.out.printf("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            String console = scanner.nextLine();
            String command;

            System.out.println();

            if (console.indexOf(" ") > 0)
                command = console.substring(0, console.indexOf(" "));
            else
                command = console;

            if (command.equalsIgnoreCase("ADD")) {

                if (console.indexOf(" " ,command.length()) > 0)
                {
                    String email = console.substring(command.length() + 1);
                    String[] emailS = email.split("[.@\\s+]");

                    if (emailS.length != 3) {
                        System.out.println("Вы ввели некорректный email!");
                        continue;
                    }

                    dataEmail.add(email);
                    System.out.println("Email " + email + " добавлен!");
                }
            } else if (command.equalsIgnoreCase("LIST"))
            {
                if (dataEmail.size() > 0) {
                    int index = 1;

                    for (var s : dataEmail) {
                        System.out.println(index++ + " - " + s);
                    }
                    continue;
                }

                System.out.println("База данных пустая");

            } else if (command.equalsIgnoreCase("EXIT"))
            {
                isWork = false;
                System.out.println("До свидания!");
                continue;

            } else if (command.equalsIgnoreCase("MENU")) {

                System.out.println("=====================\n");
                System.out.println(menuText);
                continue;

            } else {
                System.out.println("Такой комманды нет. Повторите попытку");
            }

            System.out.println("\n=====================\n");

        }
    }
}
