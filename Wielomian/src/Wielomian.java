import java.util.Random;

import static java.lang.Math.pow;

public class Wielomian {
    private static int n; // stopien wielomianu
    public static double wspolczynniki[]; // talica wspolczynnikow wielomianu
    public double wielomian = 0; // zmienna przechowuje wynik wielomianu
    Random generator = new Random();

    public Wielomian(int ilosc) // konstruktor 1 argumentowy inicjalizujacy tablice wspolczynnikow
    {
        n = ilosc;
        wspolczynniki = new double[n+1];
    }
    public void losowe_wspolczynniki() // metoda generujaca randomowe wspolczynniki dla talicy wspol.
    {
        for (int i = 0; i < (n+1); i++)
        {
            wspolczynniki[i] = generator.nextDouble(n);
        }
    }
    public void zadane_wspolczynniki(double arg0, double...args) // metoda ze zmienna lista argumentow wypelniajaca nimi tablice wspolczynnikow
    {
        wspolczynniki[0] = arg0;
        for (int i = 0; i < args.length; i++)
        {
            wspolczynniki[i+1] = args[i];
        }
    }
    public void wyswietl_wspolczynniki() // metoda wyswietlajaca tablice wsolczynnikow
    {
        for(int i= 0; i < (n+1); i++)
        {
            System.out.print((i+1) + ": " + wspolczynniki[i] + " ");
        }
        System.out.println("");
    }
    public void oblicz_wielomian(double x) // metoda oblicz wartosc wielomianu dla wartosci podanej w argumencie wywolania
    {
        for(int i = n; i >= 0;i--)
        {
            wielomian += wspolczynniki[i] * pow(x,n);
        }
        System.out.println("Wartosc wielomianu dla x = " + x + " wynosi " + wielomian);
    }
}
