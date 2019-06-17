import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    private static ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в лист задач!\n");

        boolean isWork = true;


        String menuText = "Вы можете ввести команды:" +
                "\n\t1. LIST - показать список команд" +
                "\n\t2. ADD YYYY - добавить задачу, YYYY - тело задания" +
                "\n\t3. ADD X YYYY- добавить задачу, где X - порядковый номер задачи, YYYY - тело задания" +
                "\n\t4. EDIT X YYYY - изменить задачу, где X - порядковый номер задачи, YYYY - тело задания" +
                "\n\t5. DELETE X - удалить задачу, где X - порядковый номер задачи" +
                "\n\t6. MENU - показать список команд" +
                "\n\t7. EXIT - выход из программы\n";

        System.out.println(menuText);

        while (isWork) {


            System.out.printf("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            String consoleText = scanner.nextLine();
            String comande;

            if (consoleText.indexOf(" ") > 0)
                comande = consoleText.substring(0, consoleText.indexOf(" "));
            else
                comande = consoleText;

            System.out.println();

            if (comande.equalsIgnoreCase("LIST")) {
                if (toDoList.size() > 0) {
                    for (int i = 0; i < toDoList.size(); i++) {
                        System.out.println((i + 1) + " - " + '"' + toDoList.get(i) + '"');
                    }
                    System.out.println();
                    continue;
                }
                System.out.println("Задач нет!");

            } else if (comande.equalsIgnoreCase("ADD")) {

                addItem(consoleText, comande);

            } else if (comande.equalsIgnoreCase("DELETE")) {

                deleteItem(consoleText, comande);

            } else if (comande.equalsIgnoreCase("EDIT")) {

                editItem(consoleText, comande);

            } else if (comande.equalsIgnoreCase("EXIT")) {

                isWork = false;
                System.out.println("До свидания!");
                continue;

            } else if (comande.equalsIgnoreCase("MENU")) {

                System.out.println("=====================\n");
                System.out.println(menuText);
                continue;

            } else {

                System.out.println("Такой комманды нет. Повторите попытку");
            }

            System.out.println("\n=====================\n");
        }
    }

    public static void addItem(String console, String comande) {
        if (console.indexOf(" ", comande.length()) > 0) {

            String textIndex = console.substring(comande.length() + 1);

            String[] test = textIndex.split("\\s+");

            if (isNumeric(test[0])) {
                int index = Integer.parseInt(test[0]);

                String toDo = isEmptyTask(console, comande, test[0]);

                if (toDo == null) {
                   return;
                }

                if (toDoList.size() >= index) {
                    toDoList.add(index - 1, toDo);
                } else {
                    toDoList.add(toDo);
                }
            } else {
                toDoList.add(console.substring(console.indexOf(" ", comande.length()) + 1));
            }

            System.out.println("Задание добавленно!");

        } else {
            System.out.println("Вы не написали задание!");
        }
    }

    public static void deleteItem(String console, String comande) {
        if (console.indexOf(" ", comande.length()) > 0)
        {
            String textIndex = console.substring(comande.length() + 1);

            if (isNumeric(textIndex))
            {
                int index = Integer.parseInt(textIndex);

                if (toDoList.size() >= index) {
                    System.out.println("Задание " + index + ": " + '"' + toDoList.get(index-1) + '"' + " удалено!");
                    toDoList.remove(index - 1);
                }
                else
                    System.out.println("Объекта с таким индексом нет!");
            } else {
                System.out.println("Вы не указали индекс!");
            }
        } else {
            System.out.println("Вы не указали индекс!");
        }
    }

    public static void editItem(String console, String comande) {

        if (console.indexOf(" ", comande.length()) > 0) {

            String textIndex = console.substring(comande.length() + 1);

            String[] test = textIndex.split("\\s+");

            if (isNumeric(test[0])) {
                int index = Integer.parseInt(test[0]);

                String toDo = isEmptyTask(console, comande, test[0]);

                if (toDo == null) {
                    return;
                }

                if (toDoList.size() >= index) {

                    System.out.println("Задание " + index + ": "
                            + '"' + toDoList.get(index - 1) + '"'
                            + " изменено на " + '"' + toDo + '"' + '!');

                    toDoList.set(index - 1, toDo);
                } else
                    System.out.println("Объекта с таким индексом нет!");
            } else {
                System.out.println("Вы не указали индекс!");
            }
        }  else {
            System.out.println("Вы не указали индекс!");
        }
    }

    private static String isEmptyTask(String console, String comande, String task) {
        int index = comande.length() + task.length() + 2;
        if (index > console.length()) {
            System.out.println("Вы не написали задание");
            return null;
        }

        String toDo = console.substring(index);

        if (toDo.replaceAll("\\s+", "").isEmpty())
        {
            System.out.println("Вы не написали задание");
            return null;
        }
        return toDo;
    }

    private static boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}

