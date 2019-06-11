import java.util.Random;

public class Cat
{

    private static final int COUNT_EYE = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;
    private static int countCat;

    private double originWeight;
    private double weight;
    private double weightFoodEaten;
    private CatColor color;

    private String catName;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        weightFoodEaten = 0;
        color = CatColor.values()[new Random().nextInt(CatColor.values().length)];
        catName = "No name";
        countCat += 1;
    }

    public Cat(String name)
    {
        this();
        catName = name;
    }

    public Cat(double weight)
    {
        this();
        this.weight = weight;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void toilet()
    {
        weight *= 0.1;
        System.out.println("Пора меня лоток");
    }

    public void feed(Double amount)
    {
        weightFoodEaten += amount;
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weightFoodEaten += amount;
        weight = weight + amount;
    }

    public void copyCat(Cat cat)
    {
        this.weight = cat.weight;
        catName = cat.catName;
    }

    public Double getWeight()
    {
        return weight;
    }

    public void getCatInfo()
    {
        System.out.println("Кот " + getCatName() + " имеет: " + COUNT_EYE +
                " глаза, цвет " + color.toString() +
                ", вес " + weight);
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            countCat -= 1;
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            countCat -= 1;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public double getMassFoodEaten()
    {
        return weightFoodEaten;
    }

    public String getCatName()
    {
        return catName;
    }

    public CatColor getColor()
    {
        return color;
    }

    public static int getCountCat() {
        System.out.println("Колличество кошек: " + countCat);
        return countCat;
    }

    public void setCatName(String name)
    {
        catName = name;
    }

    public void setColor(CatColor color)
    {
        this.color = color;
    }
}