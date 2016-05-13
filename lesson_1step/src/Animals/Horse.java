package Animals;

/**
 * Created by Luminiksik on 07.05.2016.
 */
public class Horse extends Animals {
    static int sRun = 15;
    static int sSwim = 5;

    public Horse(){
        System.out.println("Введите имя лошади : ");
        name = sc.next();
        System.out.println("Введите окрас лошади : ");
        color = sc.next();
        System.out.print("Введите возраст лошади :     ");
        while (!sc.hasNextInt()){ // возвращает истинну если с потока ввода можно считать целое число
            System.out.println("Введите цифрами");
            sc.next(); // Обязательно!!! Если не переедем на другой символ - зацикливается
        }
        age = sc.nextInt();
    }
    public Horse(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public void voice(){
        System.out.println("Иго-го");
    }

    @Override
    public void swim(float m){
        System.out.println("Лошадь переплыла за " + m/sSwim);
    }

    @Override
    public void jump(float m){
        if (m > 200)
            System.out.println("Лошадь встала на дыбы");
        else if(m < 50)
            System.out.println("Лошаь перешагнула стойку");
        else
            System.out.println("Лошадь перепрыгнула стойку");
    }

    @Override
    public void run(float m){
        System.out.println("Время лошади " + m/sRun);
    }
}
