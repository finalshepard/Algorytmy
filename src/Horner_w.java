import java.util.Scanner;
import java.util.ArrayList;

class Horner {
    private ArrayList<Float> tablica = new ArrayList<>();
    private int p;
    private boolean wyznaczt;

    public Horner(int potega) {
        p = potega;
    }

    float wartosc(float x) {


        int n = 1;
        float ef = tablica.get(0);
        do {
            System.out.println("Podaj punkt x");
            Scanner in = new Scanner(System.in);
            float iks;
            if (in.hasNextFloat()) {
                if (wyznaczt == false)
                    iks = in.nextFloat();
                else iks = x;
                n = 1;
                do {
                    ef = ef * iks + tablica.get(n);
                    n++;
                } while (n < tablica.size());
            } else
                System.out.println("Błędna wartosc. Spróbuj ponownie");
        } while (n == 1);
        return ef;
    }

    void dzielenie() {
        System.out.println("Podaj dwumian ktorym chcesz podzielic wielomian(przyklad zapisu: x-3): ");
        Scanner in = new Scanner(System.in);
        String bierz = in.nextLine();
        int liczebka = Integer.parseInt(bierz.substring(2));
        if (bierz.charAt(1) == '+')
            liczebka = -1 * liczebka;
        ArrayList<Float> nowex = new ArrayList<>();
        nowex.add(tablica.get(0));
        int z = 0;
        do {
            float k = nowex.get(z) * liczebka + tablica.get(z + 1);
            //    System.out.println(nowex.get(z)+" "+liczebka+" "+tablica.get(z+1));
            nowex.add(k);
            z++;
        } while (tablica.size() > nowex.size());
        int e = 0;
        int l = p;

        do {
            if (e == 0)
                System.out.print("f(x)=(");
            if (nowex.get(e) == 1)
                System.out.print("x^" + (l - 1));
            else if (((nowex.get(e) < 0) && (l > 1)) || (e == 0))
                System.out.print(nowex.get(e) + "x^" + (l - 1));
            else if ((nowex.get(e) > 0) && (l > 1))
                System.out.print("+" + nowex.get(e) + "x^" + (l - 1));
            else if ((nowex.get(e) >= 0) && (l == 1))
                System.out.print("+" + nowex.get(e));
            else if (nowex.get(e) != 0)
                System.out.print(nowex.get(e));
            l--;
            e++;
        } while (e <= nowex.size() - 2);
        System.out.print(")(" + bierz + ") reszty " + nowex.get(p) + "\n\n");
    }

    void wyznacz() {
        ArrayList<Float> now = new ArrayList<>();
        System.out.println("Rownanie posiada: " + p + " rozwiązania\\rozwiazan");
        System.out.println("Rozwiązaniem rownania bedzie któryś z dzielników wyrazu wolnego");
        float wolna = wartosc(tablica.size() - 1);      //zapisujemy wartosc wolnej do zmiennej
        int dzielnik=1;
        int it=0;
        do {
                if(wartosc(dzielnik)==0)
                {
                    now.add(wartosc(dzielnik));
                    it++;
                }
                dzielnik++;

        } while (it <= p);

        do {
            System.out.println("x");
        }
    }
    void podaj_liczbe()
    {
        int q=p;
        do {
            if(q>0)
                System.out.println("Podaj liczbę przed x o potędze " + q);
            if(q==0)
                System.out.println("Podaj liczbe bez x w wielomianie");
            Scanner elo = new Scanner(System.in);
            if(elo.hasNextFloat())
            {
                float liczba = elo.nextFloat();
                tablica.add(liczba);
                q--;
            }else
                System.out.println("Podałeś zły typ! Spróbuj ponownie. ");
        }while(q>=0);
    }
}
