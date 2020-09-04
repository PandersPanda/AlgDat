public class oppg123 { // og 124

    public static void main(String[] args){

        int[] v = {2,56,7,8,1,9};
        int[] f = {};

        //Testet med f og laget feilmelding osv.

        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.altNestMax(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skriv(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

        //oppg 1.2.6
        int[] sortet = Tabell.sort(a);
        Tabell.skriv(sortet);

        int [] c = Tabell.randPerm(20);

        int[] mNm = Tabell.nestMaksTre(c);

        Tabell.skriv(mNm);
        // kopierer a først i b
        System.arraycopy(c, 0, a, 0, c.length);

        // kopierer a bakerst i b|
        System.arraycopy(c, 0, a, c.length - a.length,c.length);

        // kopierer a på midten av b
        System.arraycopy(c, 0, a, (c.length - a.length)/2,c.length);



    }
}
