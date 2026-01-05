package EmpolyeMaintenance;
import java.util.Arrays;

import Personne.ClDate;

public class Ouvrier extends EmployeManitenance {
    private int quartTravail[];
    private String genreTravail;
    private int nbrSecteur;

    public Ouvrier() {     
        super();
        this.quartTravail = new int[2];
        this.genreTravail = "";
        this.nbrSecteur = 0;
    }
    public Ouvrier(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance, boolean vivantOuNon,
            String secteur,String lieuDeTravail,int quartTravail[], String genreTravail, int nbrSecteur) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, secteur, lieuDeTravail);
        this.quartTravail = quartTravail;
        this.genreTravail = genreTravail;
        this.nbrSecteur = nbrSecteur;
    }
    public void setQuartTravail(int quartTravail[]) {
        this.quartTravail = quartTravail;
    }
    public void setGenreTravail(String genreTravail) {
        this.genreTravail = genreTravail;
    }
    public void setNbrSecteur(int nbrSecteur) {
        this.nbrSecteur = nbrSecteur;
    }
    public int[] getQuartTravail() {
        return quartTravail;
    }
    public String getGenreTravail() {
        return genreTravail;
    }
    public int getNbrSecteur() {
        return nbrSecteur;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(quartTravail);
        result = prime * result + ((genreTravail == null) ? 0 : genreTravail.hashCode());
        result = prime * result + nbrSecteur;
        return result;
    }
   
    public boolean equals(Ouvrier obj) {
     
        return (quartTravail == obj.getQuartTravail()
                &&
                genreTravail.equals(obj.getGenreTravail())
                &&
                nbrSecteur==obj.getNbrSecteur());
    }
   
    public int compareTo(EmployeManitenance o) {
        
        return super.compareTo(o);
    }
    
    public int compare(Ouvrier obj1,Ouvrier obj2) {
       
        return super.compare(obj1, obj2);
    }
   
    public String toString() {
        System.getProperty ("line.separator");
        return ("\n\nOuvrier \n"+super.toString() +"\nQuartTravail: " + Arrays.toString(quartTravail) + "\nGenreTravail: " + genreTravail
                + "\nNbrSecteur: " + nbrSecteur) ;
    }
    
   
   

    
}
