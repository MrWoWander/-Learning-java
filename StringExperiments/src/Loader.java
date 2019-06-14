
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int oneNumber = Integer.parseInt( text.substring(text.indexOf(' ', 6) + 1, text.indexOf(' ', (text.indexOf(' ', 6) + 1))));
        int twoNumber = Integer.parseInt( text.substring(text.indexOf('-') + 2, text.indexOf('р', text.indexOf('-')) - 1));
        int threeNumber = Integer.parseInt( text.substring(text.lastIndexOf('-') + 2, text.lastIndexOf(' ')));

        System.out.println("Сумма зарботка: " + (oneNumber + twoNumber + threeNumber));
    }
}