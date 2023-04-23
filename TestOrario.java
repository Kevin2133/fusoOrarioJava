/*Il programma sarà formato anche da un’altra classe che contiene il main che gestisca un Vector 
della classe Orario e un menù con le seguenti voci: premi 0 per uscire premi 1 per creare un singolo 
oggetto della classe Orario e inserirlo nel Vector, impostando l’ora attuale con valori di ore, minuti 
e secondi presi in input; il nome della città con il valore preso in input premi 2 per visualizzare tutti
 gli attributi degli oggetti della classe Orario creati premi 3 per impostare l’ora legale a tutte le città 
 premi 4 per impostare l’ora solare a tutte le città premi 5 per impostare l’ora legale di una singola città,
  prendendo in input la città. Nel caso la città non esista dare un messaggio di errore premi 6 per impostare 
  l’ora solare di una singola città, prendendo in input la città. 
Nel caso la città non esista dare un messaggio di errore premi 7 per rimuovere un orario dal Vector, prendendo in input una città */

import java.util.*;

class TestOrario{

    public static int cercaCitta (String citta, Vector<Orario> a){
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).citta.equals(citta)){
                return i;
            }
        }

        return -1;
    }

    public static void main (String arg[]){
        Vector<Orario> a = new Vector<Orario>();
        int scelta, ore, minuti, secondi, ind;
        String citta;
        Scanner scanner = new Scanner(System.in);
        Orario o;

        do{
            System.out.println("0. esci");
            System.out.println("1. Inserisci una citta'");
            System.out.println("2. Visualizza tutte le citta'");
            System.out.println("3. Imposta ora legale a tutte le citta'");
            System.out.println("4. Imposta ora solare a tutte le citta'");
            System.out.println("5. Imposta ora legale di citta' presa in input");
            System.out.println("6. Imposta ora solare di citta' presa in input");
            System.out.println("7. Rimuovi una citta' presa in input");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 0:
                    break;
                case 1:
                    System.out.println("Inserisci nome della citta");
                    citta = scanner.nextLine();
                    System.out.println("Inserisci ore");
                    ore = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci minuti");
                    minuti = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci secondi");
                    secondi = scanner.nextInt();
                    scanner.nextLine();

                    o = new Orario(ore, minuti, secondi, citta);
                    a.add(o);
                    break;
                case 2:
                    if(a.size() > 0){
                        for(int i = 0; i < a.size(); i++){
                            a.get(i).visualizza();
                        }
                    }else{
                        System.out.println("Il vettore e' vuoto");
                    }
                    break;
                case 3:
                    if(a.size() > 0){
                        for(int i = 0; i < a.size(); i++){
                            a.get(i).cambiaOra(false);
                        }
                    }else{
                        System.out.println("Il vettore e' vuoto");
                    }
                    break;
                case 4:
                    if(a.size() > 0){
                        for(int i = 0; i < a.size(); i++){
                            a.get(i).cambiaOra(true);
                        }
                    }else{
                        System.out.println("Il vettore e' vuoto");
                    }
                    break;
                case 5:
                    System.out.println("Inserisci la citta' da cercare");
                    citta = scanner.nextLine();

                    ind = cercaCitta(citta, a);

                    if(ind > -1){
                        a.get(ind).cambiaOra(false);
                    }else{
                        System.out.println("Citta non trovata all'interno del vettore");
                    }
                    break;
                case 6:
                    System.out.println("Inserisci la citta' da cercare");
                    citta = scanner.nextLine();

                    ind = cercaCitta(citta, a);

                    if(ind > -1){
                        a.get(ind).cambiaOra(true);
                    }else{
                        System.out.println("Citta non trovata all'interno del vettore");
                    }
                    break;
                case 7:
                    System.out.println("Inserisci la citta' da cercare");
                    citta = scanner.nextLine();

                    ind = cercaCitta(citta, a);

                    if(ind > -1){
                        a.remove(ind);
                        System.out.println("Citta rimossa con successo");
                    }else{
                        System.out.println("Citta non trovata all'interno del vettore");
                    }                
                    break;
                default:
                    System.out.println("Scelta non prevista");
                    break;
            }
        }while(scelta != 0);
    }
}