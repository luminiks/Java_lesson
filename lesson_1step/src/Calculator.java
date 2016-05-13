import java.util.Scanner;

/**
 * Created by Liminiksik on 26.04.2016.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        String z;

        System.out.println("Введите два числа и знак операции :");
        a = sc.nextInt();
        b = sc.nextInt();
        z = sc.next();

        switch (z){
            case "-":
                System.out.println("Разность " + (a - b));
                break;
            case "+":
                System.out.println("Сумма " + (a + b));
                break;
            case "*":
                System.out.println("Произведение " + a * b);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Упс! На ноль делить нельзя...");
                    break;
                }
                System.out.println("Частное " + a / b);
                break;
            case "%":
                System.out.println("Остаток " + a % b);
                break;
            default:
                System.out.println("Упс! Не правильный ввод...");
        }
    }
}
