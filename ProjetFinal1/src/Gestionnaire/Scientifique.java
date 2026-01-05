package Gestionnaire;
import java.util.Arrays;

import Personne.ClDate;


public class Scientifique extends Gestionnaire {
    private int nbrProjets;
    private String listeProjets[];

    public Scientifique() {
        super();
        this.nbrProjets = 0;
        this.listeProjets= new String[100];
    }
    public Scientifique(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, int nbrEmploye, String secteur, int nbrProjets, String[] listeProjets) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, nbrEmploye, secteur);
        this.nbrProjets = nbrProjets;
        this.listeProjets = listeProjets;
    }
    
    public void setNbrProjets(int nbrProjets) {
        this.nbrProjets = nbrProjets;
    }
    public void setListeProjets(String[] listeProjets) {
        this.listeProjets = listeProjets;
    }
    public int getNbrProjets() {
        return nbrProjets;
    }
    public String[] getListeProjets() {
        return listeProjets;
    }
  
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nbrProjets;
        result = prime * result + Arrays.hashCode(listeProjets);
        return result;
    }
    
    public boolean equals(Scientifique obj) {
      
        return (nbrProjets== obj.getNbrProjets()
                 &&
                 listeProjets==obj.getListeProjets());
    }
   
    public int compareTo(Gestionnaire o) {
        
        return super.compareTo(o);
    }

    public int compare(Gestionnaire obj1,Gestionnaire obj2) {
        
        return  super.compare(obj1, obj2);
      }
      
    public String toString() {
        System.getProperty ("line.separator");
        return "\n\nScientifique "+super.toString()+"\nNbrProjets: " + nbrProjets + "\nListeProjets: " + Arrays.toString(listeProjets) ;
    }

    
}
