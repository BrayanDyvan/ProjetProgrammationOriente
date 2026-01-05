package EmpolyeMaintenance;
import Personne.ClDate;

public class Ingenieur extends EmployeManitenance {
    private String specialite;
    private ClDate dateFinEtude;
    private int niveauEtude ;
    public Ingenieur() {
        super();
        this.specialite = "";
        this.dateFinEtude = new ClDate();
        this.niveauEtude = 0;
    }
    public Ingenieur(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, String secteur, String lieuDeTravail,String specialite, ClDate dateFinEtude, int niveauEtude) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, secteur, lieuDeTravail);
        this.specialite = specialite;
        this.dateFinEtude = dateFinEtude;
        this.niveauEtude = niveauEtude;
    }
    
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public void setDateFinEtude(ClDate dateFinEtude) {
        this.dateFinEtude = dateFinEtude;
    }
    public void setNiveauEtude(int niveauEtude) {
        this.niveauEtude = niveauEtude;
    }
    public String getSpecialite() {
        return specialite;
    }
    public ClDate getDateFinEtude() {
        return dateFinEtude;
    }
    public int getNiveauEtude() {
        return niveauEtude;
    }
  
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((specialite == null) ? 0 : specialite.hashCode());
        result = prime * result + ((dateFinEtude == null) ? 0 : dateFinEtude.hashCode());
        result = prime * result + niveauEtude;
        return result;
    }
    
    public boolean equals(Ingenieur obj) {

        return (specialite.equals(obj.getSpecialite())
                &&
                dateFinEtude.equals(obj.getDateFinEtude())
                &&
                niveauEtude== obj.getNiveauEtude());
    }
    
    public int compareTo(EmployeManitenance o) {
        
        return super.compareTo(o);
    }
 
    
   
    
    public int compare(Ingenieur obj1,Ingenieur obj2) {
       
        return super.compare( obj1, obj2);
    }
    public String toString() {
        System.getProperty ("line.separator");
        return "\n\nIngenieur \n"+super.toString()+"\nSpecialite: " + specialite + "\nDateFinEtude: " + dateFinEtude + "\nNiveauEtude: " + niveauEtude
                ;
    }

    
    
}
