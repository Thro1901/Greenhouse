package client;

import models.MeasuresClass;

import java.util.Scanner;

public class program {
    client c = new client();

    Scanner input = new Scanner(System.in);

    int choice,val,temp;

    program(){

        while (true){
            System.out.println("\n");
            System.out.println("hej! vad vill du göra?");
            System.out.println("\n");
            System.out.println("1. Få alla värden" );
            System.out.println("2. Få senaste värdet på temperaturen" );
            System.out.println("3. Få senaste värdet på fuktigheten" );
            System.out.println("4. Få senaste värdet på belysning" );
            System.out.println("5. Få senaste värdet på förbrukning" );
            System.out.println("6. Uppdatera värdet på fuktigheten" );
            System.out.println("7. Uppdatera värdet på temperaturen" );
            System.out.println("8. Uppdatera värdet på belysningen" );
            System.out.println("9. Samlad rapport över luftfuktighet, temperatur och belysning just nu" );
            System.out.println("10. Rapport över värdena på luftfuktighet samt medelvärdet" );
            System.out.println("11. Rapport över värdena på temperaturen samt medelvärdet" );
            System.out.println("12. Rapport över värdena på belysning samt medelvärdet" );
            System.out.println("13. Få systemets elkostnad" );
            System.out.println("14. Logga aktuella parametrar just nu" );


            System.out.println("Ange val:");

            choice = input.nextInt();
            input.nextLine();

            switch (choice){

                case 1 :
                    c.getList();
                    break;
                case 2 :
                    c.getLastValueTemp();
                    break;
                case 3 :
                    c.getLastValueHum();
                    break;
                case 4 :
                    c.getLastValuelight();
                    break;
                case 5 :
                    c.getLastValueConsumption();

                    break;
                case 6 :
                    System.out.println("Ange nya fuktigheten:");
                    if(input.hasNext()) {
                        val = input.nextInt();
                    }
                    c.updateHum(val);
                    break;

                case 7 :
                    System.out.println("Ange nya temperaturen:");
                    if(input.hasNext()) {
                        val = input.nextInt();
                    }
                    c.updateTemp(val);
                    break;
                case 8 :
                    System.out.println("Ange nya belysningen:");
                    if(input.hasNext()) {
                        val = input.nextInt();
                    }
                    c.updateLight(val);
                    break;
                case 9 :
                    c.getReport();
                    break;
                case 10 :
                    c.getReportAVG();
                    break;
                case 11 :
                    c.getReportTemp();
                    break;
                case 12 :
                    c.getReportLight();
                    break;
                case 13 :
                    System.out.println("Ange kostanden:");
                    if(input.hasNext()) {
                        val = input.nextInt();
                    }
                    c.getCost(val);
                    break;
                case 14:
                    c.greenhouseUpdate();
                    break;

                default:
                    System.out.println("Något blev fel...");
                    break;
            }
        }
    }
}
