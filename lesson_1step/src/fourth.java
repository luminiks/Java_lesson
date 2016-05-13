/**
 * Created by Luminiksik on 04.05.2016.
 */
public class fourth {
    public static void main(String[] args) {
        Staffer st = new Staffer();
        st.stPrint();
        Staffer[] stArray = new Staffer[5];
        stArray[0] = new Staffer(new String[]{"Клишина", "Ольга", "Михайловна"}, "Продавец", "lion@mail.ru", 89123423454L, 12000, 21);
        stArray[1] = new Staffer(new String[]{"Родионов", "Константин", "Алексеевич"}, "Бугалтер", "lion@mail.ru", 89123352345L, 27000, 45);
        stArray[2] = new Staffer(new String[]{"Булыжников", "Анатолий", "Сергеевич"}, "Директор", "lion@mail.ru", 89123423345L, 31000, 51);
        stArray[3] = new Staffer(new String[]{"Звонарев", "Александ", "Алексеевич"}, "Маркетолог", "lion@mail.ru", 89123729454L, 19000, 34);
        stArray[4] = new Staffer(new String[]{"Звонова", "Екатерина", "Семеновна"}, "Консультант", "lion@mail.ru", 89123490894L, 15000, 26);

        for (int i = 0; i < 5; i++) {
            stArray[i].stPrint40();
        }


    }
}
