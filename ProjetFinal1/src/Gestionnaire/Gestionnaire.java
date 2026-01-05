package Gestionnaire;
import Personne.ClDate;
import Personne.Interface;
import Personne.Personne;

public abstract class Gestionnaire extends Personne implements Interface {
    protected int nbrEmploye;
    protected String secteur;
    
    public Gestionnaire(){
        super();
        this.nbrEmploye = 0;
        this.secteur = "";
    }

  
    public Gestionnaire(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, int nbrEmploye, String secteur) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon);
        this.nbrEmploye = nbrEmploye;
        this.secteur = secteur;
    }


    public void setNbrEmploye(int nbrEmploye) {
        this.nbrEmploye = nbrEmploye;
    }


    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }


    public int getNbrEmploye() {
        return nbrEmploye;
    }


    public String getSecteur() {
        return secteur;
    }


   
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nbrEmploye;
        result = prime * result + ((secteur == null) ? 0 : secteur.hashCode());
        return result;
    }


 
    public boolean equals(Gestionnaire obj) {
      
        return (nbrEmploye== obj.getNbrEmploye()
                &&
                secteur.equals(obj.getSecteur())
                &&
                super.equals(obj));
    }


   
    public int compareTo(Gestionnaire o) {
        return super.compareTo(o);
    }


    public int compare(Gestionnaire obj1,Gestionnaire obj2) {
        
      return  super.compare(obj1, obj2);
    }
    public String toString() {
        System.getProperty ("line.separator");
        return "\nGestionnaire\n"+super.toString()+" \nNbrEmploye: " + nbrEmploye + "\nSecteur: " + secteur ;
    }
   
    
    
}
