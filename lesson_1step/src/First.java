/**
 * Created by Liminiksik on 21.04.2016.
 */
public class First {
    public static void main(String[] args) {

        byte a1 = 127;
        short a2 = -32768;
        int a3 = 2147483647;
        long a4 = -9223372036854775808L;
        System.out.println("byte = \"" + a1 + "\"; shot = \"" + a2 + "\"; int = \"" + a3 + "\"; long = \"" + a4 + "\";");

        float a5 = 254.4f;
        double a6 = -45.6672;
        System.out.println("float = \"" + a5 + "\"; double = \"" + a6 + "\";");

        char a7 = 'x';
        boolean a8 = true;
        System.out.println("char = \"" + a7 + "\"; boolean = \"" + a8 + "\";");

        String a9 = "раз-раз, проверка";
        System.out.println("String = \"" + a9 + "\";");

        System.out.println("\nОперация вычисления = " + calculation(2, 1, 6, 3) + ";");
        System.out.println("\nПроверка вхождения в суммы в множество: \"" + sum(5, 13) + "\";");
        System.out.println("\nПроверка весокосности:");
        System.out.println("год " + 1608 + " - \"" + year(1608) + "\";");
    }

    public static int calculation(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean sum(int a, int b) {
        int c = a + b;

        if (c <= 20 && c >= 10){
            return true;
        }
        return false;
    }

    public static boolean year(int g) {
        /*if (g % 4 == 0 && (g % 100 != 0 || g % 400 == 0)){
            return true;
        }
        return false;*/
        return g % 4 == 0 && (g % 100 != 0 || g % 400 == 0);

    }
}
