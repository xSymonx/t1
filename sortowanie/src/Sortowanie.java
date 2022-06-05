import java.util.Random;
import java.util.Scanner;

public class Sortowanie {
    /* Sortowanie poprzez wyzanczenie punktu odniesienia i porownywanie z nim
   od konca i od poczatku kolejnych elementow tablicy oraz zamieniaie ich miejscami,
   jesli sa po niewlasciwych stronach funkcja wywoluje sama siebie do momentu
   utworzenia tablic jednoelementowych */
    public static void Sortowanie_Szybkie(int [] tab, int poczatek, int koniec)
    {
        int i = poczatek;   // zmienna indeksujaca tablice od poczatku
        int j = koniec;     // zmienna indeksujaca tablice od konca
        int srodek = tab[(poczatek + koniec) / 2];  // wyznaczenie pkt odniesienia
        do
        {
            for(; tab[i] < srodek;)    // jesli elemnty sa mniejsze od pkt odniesiania
                i++;                //  bierzemy nastepny element tablicy i porownujemy

            for(; tab[j] > srodek;)    // jesli elemnty sa wieksze od pkt odniesiania
                j--;                //  bierzemy nastepny element tablicy i porownujemy

            if(i <= j)      // jesli zmienne indeksujace sie nie minely zamieniamy miejsca
            {
                int tymczas = tab[i]; // zmiana wartosc miejscami
                tab[i] = tab[j];
                tab[j] = tymczas;
                i++;            // po zmianie miejsc przejscie jeden element dalej
                j--;            // oraz jeden element wczesniej
            }

        }
        while(i < j);

        if(i < koniec)    // jesli tablice nie sa jednoelementowe wywolujemy ponownie funkcje
            Sortowanie_Szybkie(tab, i, koniec);
        if(j > poczatek)
            Sortowanie_Szybkie(tab, poczatek, j);
    }
    public static void Sortowanie_Babelkowe(int tab[]){
        int tymczas; // zmienna pomocnicza
        int zmiana = 1;
        while(zmiana > 0){ // jesli brak zmian posortowane
            zmiana = 0;
            for(int i=0; i<tab.length-1; i++){
                if(tab[i]>tab[i+1]){ // porownywaie dwoch sasiedich elementow i zmiana miejscami jesli sa w zlej kolejnosci
                    tymczas = tab[i+1];
                    tab[i+1] = tab[i];
                    tab[i] = tymczas;
                    zmiana++;
                }
            }
        }
    }
    public static void main(String[] args) {
        int ilosc;
        int tym;
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj ilość liczb do posortowania");
        ilosc = in.nextInt();

        int[] tab1 = new int[ilosc]; // stworzenie tablic do posortowania
        int[] tab2 = new int[ilosc];
        for(int i=0; i<tab1.length; i++){ // wypelnienie tablic randomowymi wartosciami
            tym = generator.nextInt(ilosc);
            tab1[i] = tym;
            tab2[i] = tym;
        }
        long start1=System.currentTimeMillis(); // pomiar czasu start
        Sortowanie_Szybkie(tab1,0,ilosc-1);
        long stop1=System.currentTimeMillis(); // pomiar czasu stop

        long start2=System.currentTimeMillis();// pomiar czasu start
        Sortowanie_Babelkowe(tab2);
        long stop2=System.currentTimeMillis();// pomiar czasu stop

        for(int i=0; i<tab1.length; i++){ // wyswietlenie tablic
            System.out.print(tab1[i]+" ");
        }
        System.out.print("\n");
        for(int i=0; i<tab2.length; i++){
            System.out.print(tab2[i]+" ");
        }
        System.out.print("\n"); // wyswietlenie czasu
        System.out.println("Czas wykonania sorotwania szybkiego:"+(stop1 - start1) + "ms");
        System.out.println("Czas wykonania sorotwania babelkoweo:"+(stop2 - start2) + "ms");
    }
}
