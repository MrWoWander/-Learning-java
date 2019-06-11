package core;

public class Car
{

    public String number; // Публичная переменная типа String
    public int height; // Публичная переменная типа int
    public double weight; // Публичная переменная типа double
    public boolean hasVehicle; // Публичная переменная типа boolean
    public boolean isSpecial; // Публичная переменная типа boolean
    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : ""; // Переменная типа String
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public String getNumber()
    {
        return number;
    }

    public int getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    public boolean isHasVehicle()
    {
        return hasVehicle;
    }

    public boolean getSpecial()
    {
        return isSpecial;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setHasVehicle(boolean hasVehicle)
    {
        this.hasVehicle = hasVehicle;
    }

    public void setSpecial(boolean isSpecial)
    {
        this.isSpecial = isSpecial;
    }
}