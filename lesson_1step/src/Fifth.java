import Animals.Dog;
import Animals.Cat;
import Animals.Horse;

/**
 * Created by Luminiksik on 07.05.2016.
 */
public class Fifth {
    public static void main(String[] args) {

        Dog d = new Dog("Аврора", "рыжая", 4);
        Cat c = new Cat("Васька", "белый", 3);
        Horse h = new Horse("Белка", "белая", 7);

        System.out.println("Начнём показ");
        d.voice();
        c.voice();
        h.voice();
        System.out.println("");

        d.jump(170);
        c.jump(170);
        h.jump(170);
        System.out.println("");

        d.run(90);
        c.run(90);
        h.run(90);
        System.out.println("");

        d.swim(500);
        c.swim(500);
        h.swim(500);
        System.out.println("");

    }
}
