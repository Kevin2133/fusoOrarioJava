class Orario{
    String citta;
    int ore, minuti, secondi;
    boolean solare;

    public Orario (int ore, int minuti, int secondi, String citta){
        this.citta = citta; 
        this.ore = ore; 
        this.minuti = minuti;
        this.secondi = secondi;
        this.solare = true;
    }

    public void visualizza(){
        System.out.println("Citta: " + this.citta);
        System.out.println("Orario: " + this.ore + ":" + this.minuti + ":" + this.secondi);
        if(this.solare){
            System.out.println("E' impostata l'ora solare");
        }else{
            System.out.println("E' impostata l'ora legale");
        }
        System.out.println("*****************");
    }

    public void cambiaOra(boolean solare){
        if(this.solare == solare){
            System.out.println("L'orario di "+ this.citta + " e' gia' impostato correttamente");
        }else{
            this.solare = solare;
            if(this.solare){
                this.ore = this.ore - 1;
            }else{
                this.ore = this.ore + 1;
            }
            
            System.out.println("Orario di " + this.citta + " cambiato correttamente");
        }        
    }


}