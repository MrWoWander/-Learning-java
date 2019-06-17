
public class Loader
{
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int textIndex = text.indexOf(' ', text.indexOf(' ') + 1) + 1;
        int oneNumber = Integer.parseInt(text.substring(textIndex, text.indexOf(' ', (textIndex))));

        /*int twoNumber = Integer.parseInt( text.substring(text.indexOf('-') + 2, text.indexOf('р', text.indexOf('-')) - 1));*/

        int threeNumber = Integer.parseInt(text.substring(text.lastIndexOf('-') + 2, text.lastIndexOf(' ')));

        System.out.println("Сумма зарботка: " + (oneNumber + threeNumber));

        String[] newText = text.replaceAll("[^0-9\\s]", "").replaceAll("\\s+", " ").trim().split("[^0-9]");
        int result = 0;

        for (var s : newText)
        {
            result += Integer.parseInt(s);
        }

        System.out.println("Сумма зарботка: " + result);
    }
}