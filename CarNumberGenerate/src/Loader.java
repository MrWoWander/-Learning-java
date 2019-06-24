import java.util.*;

public class Loader {
    public static void main(String[] args) {

        ArrayList<String> carsNumber = new ArrayList<>();

        String[] carsWord = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (int i = 1; i <= 100000; i++)
        {
            for (int j = 0; j < carsWord.length; j++)
            {
                for(int x = 1; x <= 9; x++)
                {
                    carsNumber.add(carsWord[j] + x + x + x + carsWord[j] + carsWord[j] + i);
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        TreeSet<String> setTree = new TreeSet<>();
        set.addAll(carsNumber);
        setTree.addAll(carsNumber);

        Collections.sort(carsNumber); //Без нее почему то binarySearch() не отработал, хотя у меня, вроде как, цикл собирает элементы по порядку

        System.out.println("Колличество номеров в базе: " + carsNumber.size());

        Scanner scanner = new Scanner(System.in);

        for (;;)
        {
            System.out.printf("\nВведите номер: ");
            String carNum = scanner.nextLine();

            System.out.println();

            long start = System.currentTimeMillis();

            if (!carsNumber.contains(carNum))
            {
                System.out.println("Такого номера нет!");
            } else {
                System.out.println("Номер " + carNum + " есть в базе!");
            }

            long end = System.currentTimeMillis() - start;

            System.out.println("Операция 'contains' выполнилась за " + end + " ms\n");

            start = System.currentTimeMillis();
            if (Collections.binarySearch(carsNumber, carNum) > -1) {
                System.out.println("Номер " + carNum + " есть в базе!");
            } else {
                System.out.println("Такого номера нет!");
            }

            end = System.currentTimeMillis() - start;

            System.out.println("Операция 'binarySearch' выполнилась за " + end + " ms\n");

            start = System.currentTimeMillis();
            if(set.contains(carNum))
            {
                System.out.println("Номер " + carNum + " есть в базе!");
            } else {
                System.out.println("Такого номера нет!");
            }
            end = System.currentTimeMillis() - start;

            System.out.println("Операция 'set.contains()' выполнилась за " + end + " ms\n");

            start = System.currentTimeMillis();

            if(setTree.contains(carNum))
            {
                System.out.println("Номер " + carNum + " есть в базе!");
            } else {
                System.out.println("Такого номера нет!");
            }
            end = System.currentTimeMillis() - start;

            System.out.println("Операция 'setTree.contains()' выполнилась за " + end + " ms\n");
        }

    }
}
