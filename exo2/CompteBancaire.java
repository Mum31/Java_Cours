package exo2;

public class CompteBancaire {
    private String titulaire;
    private double solde;

    public CompteBancaire(String titu, double sol) {
        this.titulaire = titu;
        this.solde = sol;
    }
    public void Deposer(double montant){
        if (montant > 0){
            this.solde += montant;
            System.out.println(this.titulaire + " a déposé " + montant + " euros");
            
        }
    }
    
}
