package by.belstu.it.budanowa.basejava;

import static java.lang.Math.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //_________________b___________________
        char ch = 'h';
        int i = 255;
        short s = 11;
        byte by = 8;
        long l = 121;
        boolean b = true;
        double d = 12.9;

        String str = "hi";

        System.out.println(str+i);              //hi255
        System.out.println(str+ch);             //hih
        System.out.println(str+d);              //hi12.9
        System.out.println(by = (byte) (by+i)); //7
        l = i + 2147483647L;        //при выводе значение будет положительным
        System.out.println(l);      //2147483902

        //static int sint;  //значение без инициализации, ошибка

        System.out.println(b=b&&b);     //true
        System.out.println(b=b^b);      //false
        //System.out.println(b+b);      //нельзя

        long highValue1 = 9223372036854775807L;
        long highValue2 = 0x7fff_ffff_fffL;
        char ch2 = 'a', ch3 = '\u0061', ch4 = 97;
        System.out.println(ch2+ch3+ch4);    //складываются по коду
        System.out.println(3.45%2.4);       //1.050000..
        System.out.println(1.0/0.0);    //Infinity
        System.out.println(0.0/0.0);    //NaN
        System.out.println(log(-345));  //NaN
        System.out.println(Float.intBitsToFloat(0x7F800000));   //Infinity
        System.out.println(Float.intBitsToFloat(0xFF800000));   //-Infinity

        //TODO в каких системах счисления можно записывать целые константы?


        //_________________d___________________
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.round(PI));
        System.out.println(Math.round(E));
        System.out.println(Math.min(PI,E));
        System.out.println(Math.random());

        //_________________e___________________

        //упаковка
        Boolean objbool = true;
        Character objchar = 'c';
        Integer objint = 9;
        Byte objbyte = 50;
        Short objshort = 5245;
        String str2 = "425";

        System.out.println(objbool&objbool);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        //Распаковка
        int ival = objint.intValue();
        byte bval = objbyte.byteValue();

        System.out.println(Integer.parseInt(str2));
        System.out.println(Integer.toHexString(ival));
        System.out.println(Integer.compare(ival,ival));
        System.out.println(Integer.toString(ival));
        System.out.println(Integer.bitCount(ival));
        //isNaN отсутствует

        //_________________f___________________
        String s34 = "2345";
        int s34_int = Integer.parseInt(s34);    //через parse
        s34_int = Integer.valueOf(s34);         //через valueOf

        String inputString = "Kuku";
        // преобразуем нашу строку в массив байт
        byte[] byteArray = inputString.getBytes();
        System.out.println("Строку в массив байт : " + Arrays.toString(byteArray));
        // конвертируем байты в строку
        String string = new String(byteArray);
        System.out.println("байты в строку : " + string);


        //String в логический тип
        String str3 = "true";
        Boolean b1 = Boolean.valueOf(str3);
        Boolean b2 = Boolean.parseBoolean(str3);

        String str5 = "hello";
        String str6 = "hello";
        System.out.println("Comparing two strings: ");
        System.out.println(str5==str6);
        System.out.println(str5.equals(str6));
        System.out.println(str5.compareTo(str6));

        System.out.println(str5.split(str6));
        System.out.println(str5.contains(str6));
        System.out.println(str5.hashCode());
        System.out.println(str5.indexOf('e'));
        System.out.println(str5.length());
        System.out.println(str5.replace('e','a'));

        //_________________g___________________
        char[][] c1;
        char[] c2[];
        char c3[][];

        //TODO Можно ли определить массив нулевой длины?    //boolean[] bits = new boolean[0];
        //TODO Что случится, если индекс массива превысит его длину?    //Будет вызвано исключение

        c1 = new char[2][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[0][0] ='a';
        c1[1][0] ='b';
        c1[1][1] ='c';

        System.out.println(c1.length);
        System.out.println(c1[0].length);

        //boolean comRez = c2==c3;
        //c2=c3;

        for (char[] x:c1) {
            System.out.println(x);
        }


        WrapperString testWrapp = new WrapperString("hello"){
            @Override
            public String replaces(char oldchar, char newchar){
                this.str = this.str.replace(oldchar, newchar);
                System.out.println("Method replaces");
                return str;
            };
            @Override
            public String deletes(char newchar){
                this.str = this.str.replace(newchar, "".toCharArray()[0]);
                System.out.println("Method deletes");
                return str;
            };
        };

        String test2 = "";
        test2 = testWrapp.replaces('l','i');
        System.out.println(test2);
    }
}