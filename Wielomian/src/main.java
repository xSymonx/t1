import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int stopien;

        Scanner in = new Scanner(System.in);
        System.out.println("Podaj stopien wielomianu losowego");
        stopien = in.nextInt();
        Wielomian wiel1 = new Wielomian(stopien); // stworzenie konstruktorem nowego wielmianu losowego
        wiel1.losowe_wspolczynniki();
        wiel1.wyswietl_wspolczynniki();

        System.out.println("Podaj stopien wielomianu zadanego");
        stopien = in.nextInt();
        wiel1 = new Wielomian(stopien); // stworzenie konstruktorem nowego wielmianu losowego
        wiel1.zadane_wspolczynniki(5,3,5,7); // wywolanie funkcji wpisujacej wspolczynnki zadane w wywolaniu
        wiel1.wyswietl_wspolczynniki();
        wiel1.oblicz_wielomian(1);
    }
}
