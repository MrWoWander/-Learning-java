public class Main {
    public static void main(String[] args) {

        var mashaOld = 25;
        var vasaOld = 43;
        var mishaOld = 35;

        int min = -1;
        int middle = -1;
        int max= -1;

        if (mashaOld >= vasaOld)
        {
            if (mashaOld >= mishaOld) {
                max = mashaOld;

                if (mishaOld >= vasaOld) {
                    middle = mishaOld;
                    min = vasaOld;
                } else {
                    middle = vasaOld;
                    min = mishaOld;
                }
            } else {
                max = mishaOld;
                middle = mashaOld;
                min = vasaOld;
            }
        } else if (vasaOld >= mishaOld) {
            max = vasaOld;

            if (mashaOld >= mishaOld) {
                middle = mashaOld;
                min = mishaOld;
            } else {
                min = mashaOld;
                middle = mishaOld;
            }
        }

        System.out.println("Min old: " + min);
        System.out.println("Middle old: " + middle);
        System.out.println("Max old: " + max);
    }
}
