import java.util.Scanner;

public class Znaki {
/*
* Funkcja znajduje w ciagu znakow wzorzec i wyswietla index pocztkowy
* i koncowy znalezionego dopasowania, indexowanie zczyna sie od 0
*/
    public static void Znajdz(String ciag_znakow, String wzorzec)
    {
        String tmp = ciag_znakow;
        int last_idx = ciag_znakow.lastIndexOf(wzorzec); //index ostatniego dopasowania
        int idx = 0; // zmienna do zliczania indexow
        int tmp_idx = 0; // zmienna zliczajaca index w obcietym stringu
        int i= 1; // zmienna pomocnicza do wyswietlania wynikow
       while((idx) != (last_idx + wzorzec.length())) // wykonuj do poki nie znajdziesz ostatniego indeksu
        {
            tmp_idx = tmp.indexOf(wzorzec); // znajdz indeks pierwszego dopasowania
            idx += tmp_idx; // zlicz index
            System.out.println(i + " wystapienie wzorca, pozycja poczatku w ciagu: " + idx + " koniec: " + (idx + wzorzec.length())); // wyswietl znaleziony index
            tmp = tmp.substring(tmp_idx+wzorzec.length()); // obetnij ciagu znakow znalezione dopasowanie
            idx += wzorzec.length(); // dodaj dlugosc wzorca
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj ciag znakow do przeszukania.");
        String znaki = in.nextLine();
        System.out.println("Podaj wzorzec znakowy do znalezienia.");
        String wzorzec = in.nextLine();
        Znajdz(znaki, wzorzec);
    }
}
