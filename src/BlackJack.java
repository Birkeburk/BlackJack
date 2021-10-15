import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args) {
        boolean spelStart = false;
        boolean programKörs = true;
        int total = 0;
        String[] kortlek = {"Ess", "Två", "Tre", "Fyra", "Fem", "Sex", "Sju", "Åtta", "Nio", "Tio", "Knäckt", "Dam", "Kung"};

        Scanner myScanner = new Scanner(System.in);

        startMeddelande();


        while (programKörs) {
            spelarMeny();

            int menyVal = myScanner.nextInt();


            switch (menyVal) {
                case 1:
                    spelStart = true;
                    break;
                case 2:
                    spelRegler();
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println("Spelet stängs av!");
                    programKörs = false;
                    break;
                default:
                    System.out.println("-------------------------------------");
                    System.out.println("Felaktigt menyval, försök igen!");
            }

            while (spelStart) {
                System.out.println("-------------------------------------");
                System.out.println("[1] Slå");
                System.out.println("[2] Stanna");
                System.out.print("> ");
                int spelVal = myScanner.nextInt();
                System.out.println("-------------------------------------");

                switch (spelVal) {
                    case 1:
                        int värde = 0;
                        String mittKort = kortlek[dragKort()];
                        System.out.println(mittKort);
                        if (mittKort.equals("Två")) {
                            värde = 2;
                        } else if (mittKort.equals("Tre")) {
                            värde = 3;
                        } else if (mittKort.equals("Fyra")) {
                            värde = 4;
                        } else if (mittKort.equals("Fem")) {
                            värde = 5;
                        } else if (mittKort.equals("Sex")) {
                            värde = 6;
                        } else if (mittKort.equals("Sju")) {
                            värde = 7;
                        } else if (mittKort.equals("Åtta")) {
                            värde = 8;
                        } else if (mittKort.equals("Nio")) {
                            värde = 9;
                        } else if (mittKort.equals("Tio")) {
                            värde = 10;
                        } else if (mittKort.equals("Knäckt")) {
                            värde = 10;
                        } else if (mittKort.equals("Dam")) {
                            värde = 10;
                        } else if (mittKort.equals("Kung")) {
                            värde = 10;
                        } else if (mittKort.equals("Ess")) {
                            if (total < 11) {
                                värde = 11;
                            } else {
                                värde = 1;
                            }
                        }
                        System.out.println(värde);
                        total = total + värde;
                        System.out.println("Poäng: " + total);
                        if (total > 21) {
                            System.out.println("Du blev tjock, och har förlorat");
                            total = 0;
                            spelStart = false;
                        }
                        break;
                    case 2:
                        huset(total, kortlek);
                        spelStart = false;
                        total = 0;
                        break;
                    default:
                        System.out.println("-------------------------------------");
                        System.out.println("Felaktigt menyval prova igen!");
                }
            }
        }
    }


    public static int dragKort() {
        Random random = new Random();
        return random.nextInt(13);
    }

    public static void spelRegler() {
        System.out.println("Försöka komma så nära 21 som möjligt.");
        System.out.println("Går man över 21 blir man tjock och förlorar automatiskt.");
        System.out.println("Om huset får mer än vad spelaren får, vinner huset.");
        System.out.println("Spelaren får välja mellan att få ett nytt kort och stanna.");
    }

    public static void startMeddelande() {
        System.out.println("*************************************");
        System.out.println("*************************************");
        System.out.println("**Välkommen till Olivers BlackJack!**");
        System.out.println("*************************************");
        System.out.println("*************************************");
    }

    public static void spelarMeny() {
        System.out.println("-------------------------------------");
        System.out.println("[1] Starta spel");
        System.out.println("[2] Spel regler");
        System.out.println("[3] Avsluta spel");
        System.out.print("> ");
    }

    public static int huset(int total, String[] kortlek) {
        int husetTotal = 0;
        int huset = 0;
        while (husetTotal < total) {

            String husetsKort = kortlek[dragKort()];
            if (husetsKort.equals("Två")) {
                huset = 2;
            } else if (husetsKort.equals("Tre")) {
                huset = 3;
            } else if (husetsKort.equals("Fyra")) {
                huset = 4;
            } else if (husetsKort.equals("Fem")) {
                huset = 5;
            } else if (husetsKort.equals("Sex")) {
                huset = 6;
            } else if (husetsKort.equals("Sju")) {
                huset = 7;
            } else if (husetsKort.equals("Åtta")) {
                huset = 8;
            } else if (husetsKort.equals("Nio")) {
                huset = 9;
            } else if (husetsKort.equals("Tio")) {
                huset = 10;
            } else if (husetsKort.equals("Knäckt")) {
                huset = 10;
            } else if (husetsKort.equals("Dam")) {
                huset = 10;
            } else if (husetsKort.equals("Kung")) {
                huset = 10;
            } else if (husetsKort.equals("Ess")) {
                if (total < 11) {
                    huset = 11;
                } else {
                    huset = 1;
                }
            }
            husetTotal = husetTotal + huset;
        }
        System.out.println("Husets poäng: " + husetTotal);
        if (husetTotal > total && husetTotal <= 21) {
            System.out.println("Huset vann!");
        } else if (husetTotal > 21) {
            System.out.println("Huset blev tjock. Grattis du har vunnit!");
        } else if (husetTotal == total && husetTotal <= 21) {
            System.out.println("Det blev oavgjort!");
        }
        return huset;
    }
}
