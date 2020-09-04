public class UkeOppgave1 {

    public static long fak(int n){

        for(int i = n-1; i > 1; i--){
            n *= i;
        }
        return n;
    }

    public static int maxIndex(int[] values){

        int index = 0;

        for(int i = 1; i < values.length; i++){
            if(values[i] > values[index]){
                index = i;
            }
        }
        return index;
    }

    public static int maxNumber(int[] values){

        int value = values[0];

        for(int i = 1; i < values.length; i++){
            if(values[i] > value){
                value = values[i];
            }
        }
        return value;
    }

    public static int minNumber(int[] values){

        int minValue = values[0];
        for(int i = 1; i < values.length; i++){
            if(values[i] < minValue){
                minValue = values[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args){

        long time = System.currentTimeMillis();

        int[] values = {111,-2,3,4,0};

        int biggest = maxIndex(values);
        System.out.println("Indexen til det største tallet er " + biggest + "\n");

        biggest = maxNumber(values);
        System.out.println("Det største tallet er: " + biggest + "\n");

        int smallest = minNumber(values);

        System.out.println("Det minste taller er: " + smallest + "\n");

        int n = 5;

        long a = fak(n);
        System.out.println(a +" Er fakkulteten av " + n + "\n");

        time = System.currentTimeMillis() - time;

        System.out.println("Opperasjonene tok " + time + " millisekunder");

    }
}
