
public class oppg121{ //Og 122


    public static void main(String[] args){

        int[] tabell = {6,1,3,5,2,9,8};
        char[] charTabell = {'a','b','d','f','e'};

        int minste = Tabell.min2(tabell, 2,5);
        int minste2 = Tabell.min1(tabell, 2, 4);
        int storste1 = Tabell.max(tabell, 3, 4);
        int storste2 = Tabell.max(tabell);
        int storste3 = Tabell.maksAnnet(tabell, 3, 4);
        Tabell.byttChar(charTabell, 1, 3);

        System.out.println(minste + " " + minste2 + " " + storste1 + " " + storste2 + " " + storste3);

        Tabell.skriv(tabell, 2, 5);
        Tabell.skriv(tabell);

        String res = "";

        for(char c : charTabell){
            res += c + " ";
        }

    }
}
