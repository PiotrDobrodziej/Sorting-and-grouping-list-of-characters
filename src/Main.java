import java.util.ArrayList;

/**
 * Potrzebuje stworzyć algorytm sortująco - grupujacy listę na zasadzie jak niżej:
 * - mam listę ls= [a,a,a,b,a,a,c,c,b,a,c]
 * - potrzebuje stworzyć listę list grupującą to co wyżej tj.
 * <p>
 * a1 = [a,a,a]
 * b1 = [b]
 * a2 = [a,a]
 * c1 = [c,c]
 * b2 = [b]
 * a3 = [a]
 * c2 = [c]
 * <p>
 * i koniec koncow
 * ls = [a1,b1,a2,c1,b2,a3,c2]
 */

public class Main {

    public static void main(String[] args) {
        char ls[] = {'a', 'a', 'a', 'b', 'a', 'a', 'c', 'c', 'b', 'a', 'c'};

        ArrayList<Character> literaGrupy = new ArrayList();
        ArrayList<Integer> numerGrupy = new ArrayList();
        ArrayList<Integer> startGrupy = new ArrayList();
        ArrayList<Integer> stopGrupy = new ArrayList();

        char znak = ls[0];
        int start = 0;
        int stop = 0;
        // budowanie tablicy pomocniczej ---> znak, zero jako nr wystąpienia, start, stop
        for (int i = 0; i < ls.length; i = i + 1) {
            if (i + 1 < ls.length) {      // czy jest następny znak
                if (znak == ls[i + 1]) {          // czy następny jest taki sam ?
                    stop = i + 1;
                } else {                        // następny znak nie jest taki sam
                    literaGrupy.add(znak);
                    numerGrupy.add(0);
                    startGrupy.add(start);
                    stopGrupy.add(stop);
                    start = i + 1;
                    stop = i + 1;
                    znak = ls[i + 1];
                }
            } else {                    // nie ma następnego znaku
                literaGrupy.add(znak);
                numerGrupy.add(0);
                startGrupy.add(start);
                stopGrupy.add(stop);
            }
        }

//        System.out.println("litera, 0, start, stop ");
//        for (int i = 0; i < literaGrupy.size(); i++) {
//            System.out.print(literaGrupy.get(i));
//            System.out.print(",");
//            System.out.print(numerGrupy.get(i));
//            System.out.print(",");
//            System.out.print(startGrupy.get(i));
//            System.out.print(",");
//            System.out.println(stopGrupy.get(i));
//        }

        // tablica pomocnicza znak, nr wystąpienia, start, stop
        // wyliczanie nr wystąpienia znaku
        int ileElementow = literaGrupy.size();
        int wystapienieGrupy;
        for (int i = 0; i < ileElementow; i++) {
            if (numerGrupy.get(i).equals(0)) {
                char szukanaLitera = literaGrupy.get(i);
                wystapienieGrupy = 1;
                numerGrupy.set(i, wystapienieGrupy);
                for (int k = i; k < ileElementow; k++) {
                    if ((literaGrupy.get(k).equals(szukanaLitera)) && (numerGrupy.get(k).equals(0))) {
                        wystapienieGrupy++;
                        numerGrupy.set(k, wystapienieGrupy);
                    }
                }
            }
        }

//        System.out.println("litera, nr grupy, start, stop ");
//        for (int i = 0; i < literaGrupy.size(); i++) {
//            System.out.print(literaGrupy.get(i));
//            System.out.print(",");
//            System.out.print(numerGrupy.get(i));
//            System.out.print(",");
//            System.out.print(startGrupy.get(i));
//            System.out.print(",");
//            System.out.println(stopGrupy.get(i));
//        }

        System.out.println("= WYNIK 1 ============");
        for (int i = 0; i < literaGrupy.size(); i++) {
            System.out.print(literaGrupy.get(i));
            System.out.print(numerGrupy.get(i));
            System.out.print(" = [");
            for (int k = startGrupy.get(i); k <= stopGrupy.get(i); k++) {
                System.out.print(ls[k]);
                if (k < stopGrupy.get(i)) System.out.print(",");
            }
            System.out.println("]");
        }

        System.out.println("=== WYNIK 2 ===");
        System.out.print("ls = [");
        for (int i = 0; i < literaGrupy.size(); i++) {
            System.out.print(literaGrupy.get(i));
            System.out.print(numerGrupy.get(i));
            if (i < literaGrupy.size() - 1) System.out.print(",");
        }
        System.out.print("}");
    }
}











