package Items;
import People.Person;

public class Welchs implements Item{
    public void action(Person p)
    {
        p.setHealth(15);
        p.setGPA(0);
        p.setWealth(-1.25);
    }
    public String getName()
    {
        return "Welch's Fruit Snacks";
    }
}
