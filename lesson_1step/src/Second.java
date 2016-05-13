import java.util.Arrays;

/**
 * Created by Liminiksik on 26.04.2016.
 */
public class Second {
    public static void main(String[] args) {

        // Создать массив состоящий из элементов 0 и 1, например int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr1 ={1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1} ;
        // В массиве из предыдущего пункта, с помощью цикла заменить 0 на 1, 1 на 0;
        for (int i = 0; i < 15; i++) {
            if (arr1[i] == 1)
                arr1[i] = 0;
            else
                arr1[i] = 1;
        }
        System.out.println("Создать массив состоящий из элементов 0 и 1, например int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 } :");
        System.out.println(Arrays.toString(arr1));



        // Создать массив из 8 целых чисел. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22;
        int[] arr2 = new int[8];
        int k = 1;

        for (int i = 0; i < 8; i++){
            arr2[i] = k;
            k += 3;
        }
        System.out.println("\nСоздать массив из 8 целых чисел. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22 :");
        System.out.println(Arrays.toString(arr2));


        //Задать массив int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; пройти по нему циклом, и числа которые меньше 6 умножить на 2.
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < 12; i++){
            if (arr3[i] < 6)
                arr3[i] *= 2;
        }
        System.out.println("\nЗадать массив int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; пройти по нему циклом, и числа которые меньше 6 умножить на 2 : ");
        System.out.println(Arrays.toString(arr3));




        // * Задать одномерный массив и найти в нем минимальный и максимальный элементы;
        int[] arr4 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 0, -12, -3};
        int[] min = new int[2];
        min[0] = Integer.MAX_VALUE;
        int[] max = new int[2];
        max[0] = Integer.MIN_VALUE;

        for (int i = 0; i < 15; i++){
            if (arr4[i] < min[0]){
                min[0] = arr4[i];
                min[1] = i;
            } else if(arr4[i] > max[0]){
                max[0] = arr4[i];
                max[1] = i;
            }
        }
        System.out.println("\n* Задать одномерный массив и найти в нем минимальный и максимальный элементы :");
        System.out.println(Arrays.toString(arr4));
        System.out.println("Минимальный элемент " + min[1] + " равен " + min[0] + "; Максимальный элемент " + max[1] + " равен " + max[0]);

    }
}
