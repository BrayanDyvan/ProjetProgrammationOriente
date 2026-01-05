package ForceSecurite;
import Personne.ClDate;

public class Milice extends ForceSecurite  {
    private int nombreDeplainte;

    public Milice(){
        super();
        this.nombreDeplainte = 0;
    }

    public Milice(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance, boolean vivantOuNon,
            String grade, String arme, int anneeDeService, int nombreDeplainte) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, grade, arme, anneeDeService);
        this.nombreDeplainte = nombreDeplainte;
    }

    public void setNombreDeplainte(int nombreDeplainte) {
        this.nombreDeplainte = nombreDeplainte;
    }

    public int getNombreDeplainte() {
        return nombreDeplainte;
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nombreDeplainte;
        return result;
    }

   
    public boolean equals(Milice obj) {
       
        return (nombreDeplainte== obj.getNombreDeplainte()
                &&
                super.equals(obj));
    }

    

 
   
    public int compareTo(ForceSecurite O) {   
        return super.compareTo(O);
    }
    

    
    public int compare(ForceSecurite o1, ForceSecurite o2) {
    
        return o1.getPrenom().compareTo(o2.getPrenom());
    }

    public String toString() {
        System.getProperty ("line.separator");
        return "\n\nMilice "+super.toString()+"\nNombreDeplainte: " + nombreDeplainte ;
    }

    
    
}
