import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        // Задание 1
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] textSplit = text.split(",?\\s+");

        for (int i = 0; i < textSplit.length / 2; i++ )
        {
            String s = textSplit[i];
            textSplit[i] = textSplit[(textSplit.length - 1) - i];
            textSplit[(textSplit.length - 1) - i] = s;
        }

        for (var s : textSplit)
            System.out.println(s);

        System.out.println();

        //Задание 2


        float[] tempPatient = new float[30];

        int healthyPatientCout = 0;

        float averageTemp = .0f;


        System.out.printf("Температура пациентов: ");

        for (int i = 0; i < tempPatient.length; i++)
        {
            float temperature = 32.0f + (float) Math.round((Math.random() * (40.0 - 32.0) ) * 10) / 10;
            tempPatient[i] = temperature;

            System.out.printf((i + 1) + " - " + temperature + "; ");

            if (temperature < 36.9f && temperature > 36.2f)
                healthyPatientCout += 1;

            averageTemp += temperature;
        }

        averageTemp = Math.round((averageTemp / tempPatient.length) * 10) / 10;

        System.out.println("\nКолличество здоровых пациентов: " + healthyPatientCout);
        System.out.println("Средняя температура: " + averageTemp);

        System.out.println();

        //Задание 3

        int countSize = 101;

        char xChar = 'X';
        char spaceChar = ' ';

        String[][] xString = new String[countSize][countSize];

        for (int i = 0; i < (xString.length / 2) + (countSize % 2); i++)
        {
            xString[i][i] = String.valueOf(xChar);
            xString[i][xString.length - i - 1] = xString[i][i];

            for (int j = 0; j < (xString.length / 2) + (countSize % 2); j++)
            {
                if (xString[i][j] != null)
                    continue;

                xString[i][j] = String.valueOf(spaceChar);
                xString[i][xString[i].length - j - 1] = xString[i][j];

            }

            xString[(xString.length - 1) - i] = xString[i];
        }

        for (int i = 0; i < xString.length; i++)
        {
            for (var s : xString[i])
            {
                System.out.printf(s);
            }
            System.out.println();
        }
    }
}
