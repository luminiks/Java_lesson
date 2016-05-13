package Animals;

/**
 * Created by Luminiksik on 07.05.2016.
 */
public class Cat extends Animals {
    static int sRun = 5;

    public Cat(){
        System.out.println("Введите имя котейки : ");
        name = sc.next();
        System.out.println("Введите окрас котейки : ");
        color = sc.next();
        System.out.print("Введите возраст котейки :     ");
        while (!sc.hasNextInt()){ // возвращает истинну если с потока ввода можно считать целое число
            System.out.println("Введите цифрами");
            sc.next(); // Обязательно!!! Если не переедем на другой символ - зацикливается
        }
        age = sc.nextInt();
    }
    public Cat(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }


    @Override
    public void voice(){
        System.out.println("Мяу-мяяяяу");
    }

    @Override
    public void swim(float m){
        System.out.println(m + " метров говорите? ");
        System.out.println("Кот упирается и не хочет плыть");
    }

    @Override
    public void jump(float m){
        if (m > 50){
            System.out.println("Кот достал свои когти и перебрлся на другую сторону");
            System.out.println("Вот только так не поправилам, желтую карточку ему!");
        }
        else
            System.out.println("Кот молч перепрыгнул");
    }

    @Override
    public void run(float m){
        if (m < 100){
            System.out.println("Кот гордо прошагал за " + m/sRun);
        }
        else
            System.out.println("Кот пролетел за " + m/sRun);
    }

}
