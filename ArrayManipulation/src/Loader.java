public class Loader {
    public static void main(String[] args) {

        // Задание 1
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] textSplit = text.split(",?\\s+");
        String[] newArrayString = new String[textSplit.length];

        for (int i = textSplit.length - 1; i >=0; i-- )
        {
            newArrayString [(textSplit.length - 1) - i] = textSplit[i];
        }

        for (var s : newArrayString)
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

        String[][] xString = {
                {"X", " ", " ", " ", "X"},
                {" ", "X", " ", "X", " "},
                {" ", " ", "X", " ", " "},
                {" ", "X", " ", "X", " "},
                {"X", " ", " ", " ", "X"}
        };

        for (int i = 0; i < xString.length; i++)
        {
            for (int j = 0; j < xString[i].length; j++)
            {
                System.out.printf(xString[i][j]);
            }
            System.out.println();
        }
    }
}
