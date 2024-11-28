public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world");
       /* int myFirstVariable = 100;


    int mySecondVariable = 0;
    final int MAX_SIZE = 1000;
        System.out.println(args[0] + args[1]);
    int operandLeft =   Integer.parseInt(args[0]);
    int operandRight =   Integer.parseInt(args[1]);
        System.out.println(operandLeft + operandRight);

*/
     /*   if (args.length == 0) {
            System.out.println(" Introdu un an între 1900 și 2016 ca argument la linia de comandă.");
            return;
        }

        // convertire argumentul din string în număr întreg (anul)
        int an = Integer.parseInt(args[0]);

        // verificare dacă anul este în intervalul 1900-2016
        if (an < 1900 || an > 2016) {
            System.out.println("Anul trebuie să fie între 1900 și 2016.");
        } else {
            //  metodă pentru a verifica dacă anul este bisect
            if (AnBisect(an)) {
                System.out.println("Februarie are 29 zile în anul " + an);
            } else {
                System.out.println("Februarie are 28 zile în anul " + an);
            }
        }
    }

    //
    public static boolean AnBisect(int an) {
        return (an % 4 == 0 && an % 100 != 0) || (an % 400 == 0); */

        for(int i=2; i<=1000000; i++){
            boolean isPrime=true;
            for(int j=2; j<= i/2; j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.println("Number " + i + " is prime");
            }
        }
    }
}


