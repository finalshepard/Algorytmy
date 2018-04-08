import java.util.Scanner;



public class Algorytmy {

    public static void main(String[] args) {
        boolean meni = true;
        do {
            boolean blad = true;
            Scanner in = new Scanner(System.in);
            System.out.println("Witaj! Wybierz algorytm.\n1.Algorytm Hornera\n2.Wyjscie");
            if (in.hasNextInt()) {
                int wybor = in.nextInt();
                if (wybor==1)
                {
                    System.out.println("Podaj największą całkowitą potęgę wielomianu: ");
                    if(in.hasNextInt())
                    {
                        int potega = in.nextInt();
                        if(potega>0)
                        {
                            Horner licz = new Horner(potega);
                            licz.podaj_liczbe();
                            System.out.println("Wybierz akcję: \n1.Wyznaczanie wartości wielomianu w punkcie"
                            + "\n 2.Dzielenie wielomianu \n3. Wyznaczanie pierwiastków");
                            int wybors = in.nextInt();
                            if(wybors==1)
                                System.out.println("Szukana liczba to " + licz.wartosc() + "\n\n");
                            else if(wybors==2)
                            licz.dzielenie();
                            blad=false;
                        }else
                        {
                            System.out.println("Potęga zbyt niska żeby był sens liczyć!\n");
                        }
                    }
                }else if(wybor==2)
                    break;

            }
            if (blad){
                System.out.println("Wpisałeś zły typ danych lub złą liczbę. Spróbuj ponownie.\n");
            }
        } while (meni);
    }
}
