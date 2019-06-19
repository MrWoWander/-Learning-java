import java.util.Scanner;
import java.util.TreeMap;

public class Loaded {

    private static TreeMap<String, String> contactMap = new TreeMap<>();

    public static void main(String[] args) {

        boolean isWork = true;

        while (isWork) {
            System.out.println("\nЕсли хотите выйти, введите 'q'");
            System.out.printf("Введите номер или имя: ");
            Scanner scanner = new Scanner(System.in);

            String console = scanner.nextLine();

            if (console.equalsIgnoreCase("LIST"))
            {
                if (contactMap.size() > 0) {
                    for (var k : contactMap.keySet())
                        printMap(k);

                    continue;
                }

                System.out.println("Контактов нет!\n");
                    continue;
            } else if (console.equalsIgnoreCase("q"))
            {
                System.out.println("До встречи!");
                isWork = false;
                continue;
            }

            if (console.replaceAll("[^0-9]", "").isEmpty()) {
                String name = console;
                System.out.println("Имя: " + name);

                checkMap(name, MapType.NAME);
            } else {
                String phone = correctPhone(console);

                if (phone == null)
                    continue;

                System.out.println("Номер: " + phone);

                checkMap(phone, MapType.PHONE);
            }
        }
    }

    private static String correctPhone(String phone)
    {
        phone = phone.replaceAll("[^0-9]", "");

        if (phone.length() < 11) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append('7');
            stringBuilder.append(phone);
            phone = stringBuilder.toString();
        }

        if (phone.length() < 11) {
            System.out.println("Телефон некорректный");
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < phone.length(); i++) {
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

        return phone;
    }

    private static void checkMap(String s, MapType type) {
        switch (type) {
            case NAME: {
                if (contactMap.containsKey(s)) {

                    System.out.println("Такой контакт существует!\n");
                    printMap(s);

                } else {

                    boolean isWorkPhone = true;
                    System.out.println("\nЕсли хотите вернуться назад, введите 'q'");

                    while (isWorkPhone) {
                        System.out.printf("Введите номер телефона: ");
                        Scanner scanner = new Scanner(System.in);

                        String phoneConsole = scanner.nextLine();

                        if (phoneConsole.equalsIgnoreCase("q")) {
                            return;
                        }

                        if (phoneConsole.replaceAll("[^0-9]", "").isEmpty()) {
                            System.out.println("Вы неввели номер телефона");
                            continue;
                        }

                        String phone = correctPhone(phoneConsole);

                        if (phone == null) {
                            continue;
                        }

                        addContact(s, phone);

                        isWorkPhone = false;
                    }
                }

                break;
            }

            case PHONE: {
                if (contactMap.containsValue(s)) {

                    System.out.println("Такой номер существует!\n");
                    String key;

                    for (var k : contactMap.keySet()) {
                        if (contactMap.get(k).equals(s)) {
                            key = k;
                            printMap(key);
                        }
                    }

                } else {

                    boolean isWorkName = true;
                    System.out.println("\nЕсли хотите вернуться назад, введите 'q'");

                    while (isWorkName) {
                        System.out.printf("Введите имя: ");
                        Scanner scanner = new Scanner(System.in);

                        String name = scanner.nextLine();

                        if (name.equalsIgnoreCase("q")) {
                            return;
                        }

                        if (name.isEmpty()) {
                            System.out.println("Вы не ввели имя!");
                            continue;
                        }

                        addContact(name, s);

                        isWorkName = false;
                    }
                }
            }

            break;
        }
    }


    private static void printMap(String k) {
        System.out.println("Имя: " + k +
                "\nТелефон: " + contactMap.get(k) + "\n");
    }

    private static void addContact(String k, String v) {
        contactMap.put(k, v);

        System.out.println("Контакт с именем " + k + " и с номером " + v + " добавлен!\n");
    }
}
