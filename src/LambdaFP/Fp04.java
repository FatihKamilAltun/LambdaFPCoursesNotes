package LambdaFP;

import java.util.stream.IntStream;

public class Fp04 {
    public static void main(String[] args) {
        System.out.println(get7den100eToplam01());
        System.out.println("get7den100eToplam02 = " + get7den100eToplam02());
        System.out.println("get2den11eCarpim01 = " + get2den11eCarpim01());
        System.out.println("faktoriyelHesapla(5) = " + faktoriyelHesapla(5));
        System.out.println("verilen2SayiArasindakiCiftSayilarinToplami = " + verilen2SayiArasindakiCiftSayilarinToplami(11, 5));
        System.out.println(ikiSayiArasindakiTumSayilarinRakamlariToplami(23, 32));


    }

    //1) 7'den 100'e kadar integer değerlerinin toplamını bulan
    // bir method oluşturun.
    //1.Yol
    public static int get7den100eToplam01() {

        return IntStream.range(7, 101).reduce(Math::addExact).getAsInt();
    }

    //2.Yol
    public static int get7den100eToplam02() {

        return IntStream.rangeClosed(7, 100).reduce(Math::addExact).getAsInt();

    }

    //2) 2'den 11'e kadar integer değerlerinin çarpımını bulan
    // bir method oluşturun.

    public static int get2den11eCarpim01() {

        return IntStream.rangeClosed(2, 11).reduce(Math::multiplyExact).getAsInt();

    }

    //3) Verilen bir sayının faktoriyelini hesaplayan
    // bir method oluşturun. (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)

    public static int faktoriyelHesapla(int x) {
        if (x > 0) {
            return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact).getAsInt();
        }

        System.out.println("0'dan buyuk bir deger giriniz");
        return 0;
    }

    //4) Verilen iki sayı arasındaki çift sayıların toplamını bulan
    // bir method oluşturun.

    public static int verilen2SayiArasindakiCiftSayilarinToplami(int x, int y) {
        int z;
        if (x > y) {
            z = x;
            x = y;
            y = z;

        }
        return IntStream.rangeClosed(x, y).filter(Utils::ciftElemaniSec).sum();
    }

    //5) Verilen iki sayı arasındaki tüm sayıların
    // rakamlarının toplamını hesaplayan bir method oluşturun.
    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +
    //  2+7  +   2+8  +   2+9  +   3+0  +   3+1  +   3+2 ==> 68

    public static int ikiSayiArasindakiTumSayilarinRakamlariToplami(int x, int y){
        return IntStream.rangeClosed(x,y).map(Utils::rakamlariToplaminiAl).sum();

    }
}