public class LeapYear {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Introdu un an între 1900 și 2016 ca argument la linia de comandă.");
            return;
        }

        // Convertire argumentul din string în număr întreg (anul)
        int an = Integer.parseInt(args[0]);

        // Verificare dacă anul este în intervalul 1900-2016
        if (an < 1900 || an > 2016) {
            System.out.println("Anul trebuie să fie între 1900 și 2016.");
        } else {
            // Metodă pentru a verifica dacă anul este bisect
            if (AnBisect(an)) {
                System.out.println("Februarie are 29 zile în anul " + an);
            } else {
                System.out.println("Februarie are 28 zile în anul " + an);
            }
        }
    }

    // Metoda pentru a verifica dacă anul este bisect
    public static boolean AnBisect(int an) {
        return (an % 4 == 0 && an % 100 != 0) || (an % 400 == 0);
    }
}