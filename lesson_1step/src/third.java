import java.util.Scanner;

/**
 * Created by Luminiksik on 29.04.2016.
 */
public class third {

    static char[][] pl_area; // Игровое поле
    static Scanner sc = new Scanner(System.in);// Сканер
    static int n; //Размр поля
    static int [] last_turn = new int [2]; // Последний ход игрока
    static final char plChip = 'X'; // Фишка(маркер) игрока
    static final char aiChip = 'O'; // Фишка(маркер) ИИ
    static int[][][] check_Area; //Массив для дальнейшей проверки выйгрыша


    // Создание игрового поля(инициализация игрового поля)
    public static void initAria(){
        pl_area = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pl_area[i][j] = '*';
            }
        }

        check_Area = new int[2][3][];  // 0 - ИИ; 1 - игрок
        check_Area[0][0] = new int[n]; // - запоминание на количество фишек по горизонтали(n - по количеству строк)
        check_Area[0][1] = new int[n]; // - запоминание на количество фишек по вертикали (n - по количеству столбцов)
        check_Area[0][2] = new int[2]; // - запоминание на количество фишек по диагонали (ну... всего 2 диагонали)
        check_Area[1][0] = new int[n];
        check_Area[1][1] = new int[n];
        check_Area[1][2] = new int[2];

    }


    // Печать игрового поля
    public static void printAria(){
        System.out.print("   " + 1);
        for (int i = 1; i < n; i++) { // Верхние индексы поля
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1)); // Боковые индексы поля
            for (int j = 0; j < n; j++) {
                System.out.print(" " + pl_area[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    // Игрок делает свой ход
    public static void plTurn(){
        int x, y;

        do{
            System.out.println("Ваш ход, ввеите координаты, для вашего удара : ");
            System.out.print(" X :   ");
            while (!sc.hasNextInt()){ // возвращает истинну если с потока ввода можно считать целое число
                System.out.println("Упс! В координаты нужно вводить целые числа!!!");
                System.out.print(" X :   "); // Для более красивого ввода
                sc.next(); // Обязательно!!! Если не переедем на другой символ - зацикливается
            }
               x = sc.nextInt() - 1;
            System.out.print(" Y :   ");
            while (!sc.hasNextInt()){
                System.out.println("Упс! В координаты нужно вводить целые числа!!!");
                System.out.print(" Y :   ");
                sc.next();
            }
            y = sc.nextInt() - 1;

        }while(!checkTurn(true, x, y));

        pl_area[y][x] = plChip;
        last_turn[0] = y;
        last_turn[1] = x;
        addTurn(true);
    }


    public static void aiTurn(){
        int x,y,s;
        int[][] check = new int [4][3];
        //Предварительная инициализация массива, для мозгового штурма ИИ
        for (int i = 0; i < 4; i++) {
                check[i][0] = check[i][1] = -1;
        }

        // Сначала ИИ смотрит, надо ли перекрыть ход игрока
        for (int i = 0; i < n; i++) { // ИИ смотрит на строки
            if (check_Area[1][0][i] >= check[0][2])
            {
                if (check_Area[0][0][i] != 0)       //ИИ проверяет, стоит ли его фишка в данной строке
                    check[0][1] = i;
                else
                    check[0][0] = i;
                check[0][2] = check_Area[1][0][i];

            }
        }
        for (int i = 0; i < n; i++) { // ИИ смотрит на столбцы
            if (check_Area[1][1][i] >= check[1][2])
            {
                if (check_Area[0][1][i] != 0)       //ИИ проверяет, стоит ли его фишка а данном столбце
                    check[1][1] = i;
                else
                    check[1][0] = i;
                check[1][2] = check_Area[1][1][i];

            }
        }
        // ИИ смотрит на первую диагональ(короя идёт 2->2)
        if (check_Area[1][2][0] >= check[2][2])
        {
            if (check_Area[0][2][0] != 0)       //ИИ проверяет, стоит ли его фишка а данном диагонали
                check[2][1] = 1;
            else
                check[2][0] = 1;
            check[2][2] = check_Area[1][2][0];
        }
        // ИИ смотрит на вторую диагональ(короя идёт 10->1; 9->2...)
        if (check_Area[1][2][1] >= check[3][2])
        {
            if (check_Area[0][2][1] != 0)       //ИИ проверяет, стоит ли его фишка а данном диагонали
                check[3][1] = 1;
            else
                check[3][0] = 1;
            check[3][2] = check_Area[1][2][1];
        }

        // Если перекрывать ходов не нужно, смотрит, какой ход ему выгоднее сделать
        if (check[0][0] == -1 && check[1][0] == -1 && check[2][0] == -1 && check[3][0] == -1){
            for (int i = 0; i < 4; i++) {
                check[i][0] = check[i][1] = -1;
            }

            for (int i = 0; i < n; i++) { // ИИ смотрит на строки
                if (check_Area[0][0][i] >= check[0][2])
                {
                    if (check_Area[1][0][i] != 0)       //ИИ проверяет, стоит ли его фишка в данной строке
                        check[0][1] = i;
                    else
                        check[0][0] = i;
                    check[0][2] = check_Area[0][0][i];

                }
            }
            for (int i = 0; i < n; i++) { // ИИ смотрит на столбцы
                if (check_Area[0][1][i] >= check[1][2])
                {
                    if (check_Area[1][1][i] != 0)       //ИИ проверяет, стоит ли его фишка а данном столбце
                        check[1][1] = i;
                    else
                        check[1][0] = i;
                    check[1][2] = check_Area[0][1][i];

                }
            }
            // ИИ смотрит на первую диагональ(короя идёт 2->2)
            if (check_Area[0][2][0] >= check[2][2])
            {
                if (check_Area[1][2][0] != 0)       //ИИ проверяет, стоит ли его фишка а данном диагонали
                    check[2][1] = 1;
                else
                    check[2][0] = 1;
                check[2][2] = check_Area[0][2][0];
            }
            // ИИ смотрит на вторую диагональ(короя идёт 10->1; 9->2...)
            if (check_Area[0][2][1] >= check[3][2])
            {
                if (check_Area[1][2][1] != 0)       //ИИ проверяет, стоит ли его фишка а данном диагонали
                    check[3][1] = 1;
                else
                    check[3][0] = 1;
                check[3][2] = check_Area[0][2][1];
            }
        }

        if ((check[0][2] == check[1][2] && check[2][2] == check[3][2] && check[0][2] == check[3][2]) || (check[0][2] > check[2][2] || check[0][2] > check[3][2] || check[1][2] > check[2][2] || check[1][2] > check[3][2]) || check[2][2] == check[3][2]){
            if (check[0][0] == -1)
                y = check[0][1];
            else
                y = check[0][0];

            if (check[1][0] == -1)
                x = check[1][1];
            else
                x = check[1][0];
            s = 1;
        }
        else if (check[2][2] > check[3][2]){
            if (check[2][0] == -1)
                y = check[2][1];
            else
                y = check[2][0];
            x = y;
            s = 2;
        } else {
            if (check[3][0] == -1)
                x = check[3][1];
            else
                x = check[3][0];
            y = n - x;
            x = y;
            s = 3;
        }
        int i = 0;
        while (!checkTurn(false, x, y)){ //первый раз ячейка 100% будет занята, так что ищем другую
            switch (s) {
                case 1:
                    if (check[0][2] > check[1][2] && (check_Area[0][0][x] + check_Area[1][0][x]) < (n - 1)){
                        if (x == n - 1)
                            x = 0;
                        else
                            x++;
                    } else if (check[0][2] < check[1][2] && (check_Area[0][0][y] + check_Area[1][0][y]) < (n - 1)){
                        if (y == n - 1)
                            y = 0;
                        else
                            y++;
                    } else if((check_Area[0][0][x] + check_Area[1][0][x]) < (n - 1)) {
                        if (x == n - 1)
                            x = 0;
                        else
                            x++;
                    } else{
                        if (y == n - 1)
                            y = 0;
                        else
                            y++;
                    }
                    break;
                case 2:
                    if ((check_Area[0][2][0] + check_Area[1][2][0]) < (n - 1)){
                        if (x == n - 1){
                            x = 0;
                            y = 0;
                        } else {
                            x++;
                            y++;
                        }
                    }
                    else
                        x++;
                    break;
                case 3:
                    if ((check_Area[0][2][1] + check_Area[1][2][0]) < (n - 1)){
                        if (x == n - 1){
                            y = n - 1;
                            x = 0;
                        }
                        y--;
                        x++;
                    } else{
                        if (y == n - 1)
                            y = 0;
                        y++;
                    }
                    break;
            }
        }
        pl_area[y][x] = aiChip;
        last_turn[0] = y;
        last_turn[1] = x;
    addTurn(false);
    }


    // Проверка ячейки
    public static boolean checkTurn(boolean flag, int x, int y){ //Если первый оператор истина - ход игрока, ложь - ход ИИ
        if (flag){
            System.out.println();
            if (x > (n - 1) || y > (n - 1)){
                System.out.println("Упс! Вы задали большие координаты, чем размер поля, размер поля :   " + n + " Х " + n);
                return false;
            }
        }

        if (pl_area[y][x] == '*')
            return true;

        if (flag)
            System.out.println("Данная позиция уже занята... =(");
        return false;

    }



    // Добавление хода в проверочные значения(подготовливаем почву для ИИ)
    public static void addTurn(boolean flag){//Если истина - проверяем игрока, ложь - ИИ
        int i = 0;
        if(flag)
            i = 1;

        check_Area[i][0][last_turn[0]]++; //считаем, какую по счету добавляем фишку в строке
        check_Area[i][1][last_turn[1]]++; //считаем, какую по счету добавляем фишку в столбце
        if (last_turn[0] == last_turn[1]) // 2 if без alse, потому что центр диагонали нужно прописать в оба ствойства
            check_Area[i][2][0]++;
        if ( ((n - last_turn[0])== last_turn[1]) && (last_turn[0] == (n - last_turn[1])) ) // используем n
            check_Area[i][2][1]++;                           // т.к. из матрицы выдно, что диагональ идет 10->1; 9->2; 8->3; 3->1; 2->2;

    }


    //Проверка на заполнение поля
    public static boolean checkBulk(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pl_area[i][j] == '*')
                    return false;
            }
        }
        return true;
    }

    //Проверка на выйгрыш
    public static boolean checkWin(boolean flag){
        if (flag){                                                  //Проверка на выйгрыш игрока
            if (check_Area[1][2][1] == n || check_Area[1][2][0] == n){
                System.out.println("Игрок выйграл!");
                System.out.println("Поздравляем! Поздравляем! Вы обыграли ИИ!");
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (check_Area[1][0][i] == n || check_Area[1][1][i] == n) {
                    System.out.println("Игрок выйграл!");
                    System.out.println("Поздравляем! Поздравляем! Вы обыграли ИИ!");
                    return true;
                }
            }
        }else{                                                      //Проверка на выйгрыш ИИ
            if (check_Area[0][2][1] == n || check_Area[0][2][0] == n){
                System.out.println("Увы вы проиграли... Повезет вдругой раз! ;)");
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (check_Area[0][0][i] == n || check_Area[0][1][i] == n) {
                    System.out.println("Увы вы проиграли... Повезет вдругой раз! ;)");
                    return true;
                }
            }
        }
        if (checkBulk()){
            System.out.println("Увы вы поле полностью забито... Ничья =)");
            return true;
        }
        return false;

    }


    // Главная функция
    public static void main(String[] args) {

        System.out.println("Введите размер игрового поля");
        do {
            while (!sc.hasNextInt()) { // проверка ввода параметров игры
                System.out.println("Упс! В координаты нужно вводить целые числа!!!");
                sc.next();
            }
            n = sc.nextInt();
            if (n > 9)
                System.out.println("Эй там, полегче! Давай будем вбивать размер меньше 10, а то индексы поля будут не красивыми =)");
            else if (n < 3)
                System.out.println("Ну и как мы с таким полем будем играть... ='(");
        }while (n > 9 || n < 3);
        initAria();
        printAria();

        while (true){
            plTurn();
            printAria();
            if (checkWin(true))
                break;
            aiTurn();
            printAria();
            if (checkWin(false))
                break;
        }
    }

}
// PS прошу прощенья за такой большой код