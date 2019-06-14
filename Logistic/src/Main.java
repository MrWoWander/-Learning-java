import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int MAX_CONTAINER = 12;
        final int MAX_BOX = 27;

        int truck;
        int container;
        int box = getBox();

        if(box % MAX_BOX == 0)
        {
            container = (box / MAX_BOX);
        } else {
            container = (box / MAX_BOX) + 1;
        }

        if (container % MAX_CONTAINER == 0)
        {
            truck = container / MAX_CONTAINER;
        } else
        {
            truck = (container / MAX_CONTAINER) + 1;
        }

        System.out.println("tr " + truck);
        System.out.println("cont " + container);
        System.out.println("box " + box);

        for (int i = 1; i <= truck; i++)
        {
            System.out.println("Грузовик " + i);

            for (int x = 1; x <= container; x++)
            {
                int currentTrack = (i-1) * MAX_CONTAINER;
                System.out.println("\tКонтейнер " + (x + currentTrack));

                for (int y = 1; y <= box; y++)
                {
                    int currentContainer = (x-1 + (currentTrack)) * MAX_BOX;
                    System.out.println("\t\tЯщик " + (y + currentContainer));

                    if(y % MAX_BOX == 0)
                    {
                        box -= y;
                        break;
                    }
                }

                if(x % MAX_CONTAINER == 0)
                {
                    container -= x;
                    break;
                }
            }
        }

    }

    public static int getBox()
    {
        System.out.printf("Введите кол-во ящиков: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
