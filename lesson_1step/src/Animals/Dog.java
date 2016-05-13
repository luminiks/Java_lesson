package Animals;

/**
 * Created by Luminiksik on 07.05.2016.
 */
public class Dog extends Animals {
    static int sRun = 10;
    static int sSwim = 7;

    public Dog(){
        System.out.println("Введите имя собаки : ");
        name = sc.next();
        System.out.println("Введите окрас собаки : ");
        color = sc.next();
        System.out.print("Введите возраст собаки :     ");
        while (!sc.hasNextInt()){ // возвращает истинну если с потока ввода можно считать целое число
            System.out.println("Введите цифрами");
            sc.next(); // Обязательно!!! Если не переедем на другой символ - зацикливается
        }
        age = sc.nextInt();
    }
    public Dog(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public void voice(){
        System.out.println("Гав-гав");
    }

    @Override
    public void swim(float m){
        System.out.println("Собака переплыла за " + m/sSwim);
    }

    @Override
    public void jump(float m){
        if (m > 150)
            System.out.println("Собака завыла");
        else
            System.out.println("Собака перепрыгнула стойку");
    }

    @Override
    public void run(float m){
        System.out.println("Время собаки " + m/sRun);
    }
}

