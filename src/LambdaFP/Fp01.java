package LambdaFP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
      /*
      1) Lambda (Functional Programming) Java 8 ile kullanilmaya baslanmistir
      2) Functional Programming'de "Ne yapilacak (What to do) uzerine yogunlasir.
         Structured Programming, "Nasıl yapilacak" (How to do) uzerine yogunlasir
      3) Functional Programming, Arrays ve Collections ile kullanilir
      4) "entrySet() methodu ile Map, Set'e donusturulerek Functional Programming'de kullanilabilir.

       */


    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);

        listElemanlariniYazdirStructured(liste);
        System.out.println();
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        ciftElemanlariniYazdirStructured(liste);
        System.out.println();
        ciftElemanlariniYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);
        //System.out.println();
        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        //System.out.println();
        getMaxEleman01(liste);
        //System.out.println();
        getMaxEleman02(liste);
        listElemanlarindanEnKucugu(liste);
        getYedidenBuyukCiftMin(liste);
        getYedidenBuyukCiftMin02(liste);
        getYedidenBuyukCiftMin03(liste);
        getTersSiralamaTekrarsizElemanlarinYarisi(liste);


    }
    //1) Ardışık list elementlerini
    // aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    // (Structured)

    public static void listElemanlariniYazdirStructured(List<Integer> list) {
        for (Integer w : list
        ) {
            System.out.print(w + " ");
        }
    }

    //1) List elementlerini arka arkaya aynı satırda
    // aralarında boşluk bırakarak yazdıran bir method oluşturun.
    // (Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
        //stream() method'u collection'dan elementleri akisa dahil etmek icin
        // ve method'lara ulasmak icin kullanilir


    }
    //2) List elementlerinden çift olanlarini
    // aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    // (Structured)

    public static void ciftElemanlariniYazdirStructured(List<Integer> list) {
        for (Integer w : list
        ) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }
    //2) List elementlerinden çift olanlarini
    // aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    // (Functional)

    public static void ciftElemanlariniYazdirFunctional(List<Integer> list) {

        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    // 3) Ardışık tek list elemanlarinin karelerini aynı satırda
    // aralarında boşluk bırakarak yazdıran bir method oluşturun.
    // (Functional)

    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        // elemanlarin degerleri degisecekse map()'u kullanilir
    }


    //4) Ardışık tek list elementlerinin küplerini
    // tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran
    // bir method oluşturun.

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {


        list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));


    }

    //5) Tekrarsız çift elementlerin
    // karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.println(toplam);
    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan
    // bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {
        Integer kupCarpim = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.println(kupCarpim);
    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    // 1. Yol
    public static void getMaxEleman01(List<Integer> list) {

        Integer max01 = list.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);
        System.out.println(max01);
    }

    // 2.Yol
    public static void getMaxEleman02(List<Integer> list) {

        Integer max02 = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);
        System.out.println(max02);
    }

    //Ödev
    //8)List elemanları arasından
    // en küçük değeri bulan bir method oluşturun.
    // (2 Yol ile)

    public static void listElemanlarindanEnKucugu(List<Integer> list) {
        Integer minValue = list.stream().distinct().sorted().reduce(list.get(0), (t, u) -> t < u ? t : u);
        System.out.println(minValue);


    }

    //9) List elemanları arasından 7'den büyük,
    // çift, en küçük değeri bulan bir method oluşturun.
    // 1. Yol

    public static void getYedidenBuyukCiftMin(List<Integer> list) {
        Integer minValue01 = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.println(minValue01);
    }

    // 2. Yol
    public static void getYedidenBuyukCiftMin02(List<Integer> list) {
        Integer minValue02 = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u) -> u);
        System.out.println(minValue02);
    }

    // 3. Yol
    public static void getYedidenBuyukCiftMin03(List<Integer> list) {
        Integer minValue03 = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).sorted().findFirst().get();
        System.out.println(minValue03);
    }

    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların
    // yarı değerlerini(elamanın ikiye bölüm sonucunu)
    // bulan bir method oluşturun.

    public static void getTersSiralamaTekrarsizElemanlarinYarisi(List<Integer>list){
        List <Double> sonList = list.stream().distinct().filter(t -> t > 5).map(t -> t / 2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonList);
    }

}