import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    public static void main(String[] args)
    {
        // Создается бесконечный цикл
        while(true)
        {
            //Вывод информации в консоль
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");

            // Запись вводимого значения
            int income = (new Scanner(System.in)).nextInt();

            //Проверка на правильность диапазона вводимого числа. Если функция возвращает false, то цикл "перезапускается"
            if(!checkIncomeRange(income)) {
                continue;
            }
            // Высчитывается зарплата менеджера относительно его процента
            double managerSalary = income * managerPercent;

            // Расчет чистого дохода: доход - зарплата менеджера - сумма трат за аренду помещения, интернет, телефонию.
            double pureIncome = income - managerSalary -
                calculateFixedCharges();

            // Расчет налогов на доход
            double taxAmount = mainTaxPercent * pureIncome;

             // Доход после уплаты налогов
            double pureIncomeAfterTax = pureIncome - taxAmount;

            // Проверка на возможность инвестиции. Если доход больше или равен минимальной суммы инвестиции, то будет true;
            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            //Вывод информации в консоль
            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income)
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges()
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
