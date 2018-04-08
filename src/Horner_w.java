import java.util.Scanner;
import java.util.ArrayList;

class Horner {
    private ArrayList<Float> tablica = new ArrayList<>();
    private int p;

    public Horner(int potega) {
        p = potega;
    }

    float wartosc() {


        int n = 1;
        float ef = tablica.get(0);
        do {
            System.out.println("Podaj punkt x");
            Scanner in = new Scanner(System.in);
            if (in.hasNextFloat()) {
                float iks = in.nextFloat();
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

    int dzielenie()
    {
        int liczba;
        System.out.println("Podaj dwumian ktorym chcesz podzielic wielomian(przyklad zapisu: x-3): ");
        Scanner in = new Scanner(System.in);
        String bierz = in.nextLine();
        int liczebka= Integer.parseInt(bierz.substring(2));
        if(bierz.substring(1).equals("+"))
        liczebka=liczebka*-1;
        ArrayList<Float> nowex = new ArrayList<>();
        nowex.add(tablica.get(0));
        int z=0;
        do {
            float k =nowex.get(z)*liczebka+ tablica.get(z+1);
            nowex.add(k);
            z++;
        }while(tablica.size()>nowex.size());
        int e=0;
        do {

            System.out.println(nowex.get(e));
            e++;
        }while(e<=nowex.size()-1);

       return liczebka;
    }

    void podaj_liczbe()
    {
        do {
            if(p>0)
                System.out.println("Podaj liczbę przed x o potędze " + p);
            if(p==0)
                System.out.println("Podaj liczbe bez x w wielomianie");
            Scanner elo = new Scanner(System.in);
            if(elo.hasNextFloat())
            {
                float liczba = elo.nextFloat();
                tablica.add(liczba);
                p--;
            }else
                System.out.println("Podałeś zły typ! Spróbuj ponownie. ");
        }while(p>=0);
    }
}
