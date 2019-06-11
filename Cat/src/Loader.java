
public class Loader
{
    public static void main(String[] args)
    {
        // Урок 1

        for (int i = 1; i <= 5; i++)
        {
            Cat cat = new Cat(Integer.toString(i));
            System.out.println("Кошка " + cat.getCatName());
            System.out.println("Вес кошки: " + cat.getWeight());
            cat.feed(100.4);
            System.out.println("Вес кошки после еды: " + cat.getWeight());

            System.out.println("Кошка ушла \n");
        }

        Cat vasya = new Cat("Вася");
        System.out.println("Кот " + vasya.getCatName());

        while (vasya.getStatus() != "Exploded"){
            vasya.drink(100.0);
            vasya.feed(200.5);
        }

        System.out.println(vasya.getCatName() + " взорвался \n");

        Cat snow = new Cat("Снежок");
        System.out.println("Кот " + snow.getCatName());

        while (snow.getStatus() != "Dead"){
            snow.meow();
        }

        System.out.println(snow.getCatName() + " умер \n");

        // Урок 2
        Cat boris = new Cat("Борис");
        System.out.println("Кот " + boris.getCatName());
        boris.feed(100.0);
        System.out.println(boris.getMassFoodEaten());
        boris.toilet();
        System.out.println(boris.getWeight() + "\n");

        // Урок 3
        Cat.getCountCat();
        System.out.println();

        // Урок 4
        boris.getCatInfo();
        System.out.println();

        //Урок 5
        Cat tom = createNewCat("Том", 287.456);
        tom.getCatInfo();

        //Урок 6
        tom.setColor(CatColor.RED);
        System.out.println(tom.getCatName() + " имеет " + tom.getColor() + " окрас");
        System.out.println();

        //Урок 7
        Cat fedor = new Cat("Федор");
        fedor.getCatInfo();
        fedor.copyCat(tom);

        tom.getCatInfo();
        fedor.getCatInfo();
    }

    public static Cat createNewCat(String name, double weight)
    {
        Cat cat = new Cat(weight);
        cat.setCatName(name);
        return cat;
    }
}