import java.util.Arrays;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }


    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int max(int[] a)  // bruker hele tabellen
    {
        return max(a,0,a.length);     // kaller metoden over
    }


    static int max(int[] verdier, int fra, int til){

        fratilKontroll(verdier.length, fra, til);

        int m = fra;
        int biggest = verdier[fra];

        for(int i = fra +1; i < til; i++){
            if(verdier[i] > biggest){
                m = i;
                biggest = verdier[i];
            }
        }
        return m;
    }


    static int min1(int[] verdier, int fra, int til){

        if(fra >= til || fra < 0 || til > verdier.length){
            throw new IllegalArgumentException("ugyldig argumenter");
        }

        int m = fra;
        int minste = verdier[fra];

        for(int i = fra + 1; i < til; i++){

            if(verdier[i] < minste){

                m = i;
                minste = verdier[i];
            }

        }
        return m;
    }

    static int min2(int[] verdier, int venstre, int høyre){

        if(venstre > høyre || venstre < 0 || høyre >= verdier.length){
            throw new IllegalArgumentException("ugyldig argumenter");
        }

        int m = venstre;
        int minste = verdier[venstre];

        for(int i = venstre + 1; i <= høyre; i++){

            if(verdier[i] < minste){
                m = i;
                minste = verdier[i];
            }

        }
        return m;
    }

    public static int maksAnnet(int[] a, int fra, int til)  // versjon 3 av maks-metoden
    {
        int sist = til - 1;       // siste posisjon i tabellen
        int m = fra;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = fra; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static void byttChar(char[] verdier, int i, int j){

        char temp = verdier[i];
        verdier[i] = verdier[j];
        verdier[j] = temp;

    }

    public static void skriv(int[] v, int fra, int til){

        fratilKontroll(v.length, fra, til);

        for(int i = fra; i < til; i++ ){
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }

    public static void skriv(int[] v){

        for(int c: v){
            System.out.print(c + " ");
        }

        System.out.println("");
    }

    public static void fratilKontroll(int tablengde, int fra, int til){
        if(tablengde == 0){
            throw new IllegalArgumentException("Arrayet er tomt");
        }
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = max(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = max(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = max(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = max(a, 0, m);              // leter i a[0:m>
            int mh = max(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    public static int[] altNestMax(int[] a){
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = max(a);  // m er posisjonen til tabellens største verdi
                            // nm skal inneholde posisjonen til nest største verdi

        int f = a[0];
        a[0] = a[m];
        a[m] = f;


        int nm = max(a, 1, n);

        if(nm == m){
            nm = 0;
        }

        bytt(a, 0, m);

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1
    }

    public static int[] sort(int[] a){

        int n = a.length;
        for(int i = n-1; i > 0; i--){
            int m = max(a, 0, i+1);
            bytt(a, m, i);
        }
        return a;
    }

    public static int[] nestMaksTre(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) {
                tempverdi = b[k]; k++;
            }
            if (tempverdi > nestmaksverdi){
                nestmaksverdi = tempverdi;
            }

        }

        return new int[] {1,b[1],b[2], nestmaksverdi}; // størst og nest størst

    } // nestMaks

    public static void kopier(int[] a, int i, int[] b, int j, int ant)
    {
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
    }
}
