import java.util.Scanner;

/**
 * Created by Luminiksik on 04.05.2016.
 */
/*• Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
        • Конструктор класса должен заполнять эти поля при создании объекта; +
        • Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        • Создать массив из 5 сотрудников
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);
        • С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/
public class Staffer {
    private String[] fio = new String[3];
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;
    private static Scanner sc = new Scanner(System.in);

    public Staffer (){

        System.out.println("Введите ФИО сотрудника : ");
        fio[0] = sc.next();
        fio[1] = sc.next();
        fio[2] = sc.next();
        System.out.println("Введите должность стотрудника : ");
        position = sc.next();
        System.out.println("Введите email сотрудника : ");
        email = sc.next();
        System.out.print("\nВведите номер телефона сотруника :     ");
        while (!sc.hasNextInt()){ // возвращает истинну если с потока ввода можно считать целое число
            System.out.println("Введите цифрами");
            sc.next(); // Обязательно!!! Если не переедем на другой символ - зацикливается
        }
        phone = sc.nextInt();
        System.out.print("\nВведите зарплату сотрудника :     ");
        while (!sc.hasNextInt()){
            System.out.println("Введите цифрами");
            sc.next();
        }
        salary = sc.nextInt();
        System.out.print("\nВведите возраст сотрудника :     ");
        while (!sc.hasNextInt()){
            System.out.println("Введите цифрами");
            sc.next();
        }
        age = sc.nextInt();
        System.out.println();
    }


    public Staffer (String[] _fio, String _position, String _email, long _phone, int _salary, int _age){
        fio[0] = _fio[0];
        fio[1] = _fio[1];
        fio[2] = _fio[2];
        position = _position;
        email = _email;
        phone = _phone;
        salary = _salary;
        age = _age;
    }

    public void stPrint(){
        System.out.println("Сотрудник    " + fio[0] + " " + fio[1] + " " + fio[2]);
        System.out.println("    Должность    " + position);
        System.out.println("    Заработная плата :    " + salary + " р.");
        System.out.println("    Возраст :    " + age);
        System.out.println("    Контактная информация :   телефон - " + phone + "; email -  " + email);
    }

    public void stPrint40(){
        if (age >= 40){
            stPrint();
        }
    }
}
