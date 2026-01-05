package EmpolyeMaintenance;
import Personne.ClDate;
import Personne.Interface;
import Personne.Personne;

public abstract class EmployeManitenance extends Personne  implements Interface{
    protected String secteur;
    protected String lieuDeTravail;
    public EmployeManitenance(){
        super();
        this.secteur = "";
        this.lieuDeTravail="";
    }

    public EmployeManitenance(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, String secteur,String lieuDeTravail) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon);
        this.secteur = secteur;
        this.lieuDeTravail=lieuDeTravail;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getLieuDeTravail() {
        return lieuDeTravail;
    }

    public void setLieuDeTravail(String lieuDeTravail) {
        this.lieuDeTravail = lieuDeTravail;
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((secteur == null) ? 0 : secteur.hashCode());
        return result;
    }

    
    public boolean equals(EmployeManitenance obj) {
       
        return (secteur.equals(obj.getSecteur())
                &&
                lieuDeTravail.equals(obj.getLieuDeTravail())
                &&
                super.equals(obj));
    }

    
   
   
    public int compareTo(EmployeManitenance o) {
       
        return super.compareTo(o);
    }


    
    public int compare(EmployeManitenance obj1,EmployeManitenance obj2) {
        
      return super.compare(obj1, obj2);
        
    }

    public String toString() {
        System.getProperty ("line.separator");
        return "EmployeManitenance \n" + super.toString() +"\nSecteur: "+ secteur+"\nLieu de travail: "+lieuDeTravail ;
    }

 

    
    
}
