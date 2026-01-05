package Personne;
import java.io.Serializable;
import java.util.Comparator;

public abstract class Personne implements Comparable <Personne>, Comparator <Personne> ,Serializable{
    protected String matricule;
    protected String nom ;
    protected String prenom;
    protected String sexe;
    protected ClDate dateNaissance;
    protected boolean vivantOuNon;

    public Personne() {
        this.matricule = "";
                this.nom = "";
                this.prenom = "";
                this.sexe = "";
                this.dateNaissance = new ClDate();
                this.vivantOuNon = true;
    }
    public Personne(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.vivantOuNon = vivantOuNon;
    }

    public Personne(Personne unePersonne){
        this.matricule =unePersonne.getMatricule();
        this.nom = unePersonne.getNom();
        this.prenom = unePersonne.getPrenom();
        this.sexe = unePersonne.getSexe();
        this.dateNaissance = unePersonne.getDateNaissance();
        this.vivantOuNon = unePersonne.isVivantOuNon();
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public void setDateNaissance(ClDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setVivantOuNon(boolean vivantOuNon) {
        this.vivantOuNon = vivantOuNon;
    }
    public String getMatricule() {
        return matricule;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getSexe() {
        return sexe;
    }
    public ClDate getDateNaissance() {
        return dateNaissance;
    }
    public boolean isVivantOuNon() {
        return vivantOuNon;
    }
   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
        result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        result = prime * result + (vivantOuNon ? 1231 : 1237);
        return result;
    }

    public boolean equals(Personne obj) {
   
        return (matricule.equals(obj.getMatricule())
                &&      
                nom.equals(obj.getNom())
                &&
                prenom.equals(obj.getPrenom())
                &&
                sexe.equals(obj.getSexe())
                &&
                dateNaissance.equals(obj.getDateNaissance())
                &&
                vivantOuNon==obj.isVivantOuNon());
    }

    
    
  
    public int compareTo(Personne o) {
      if(  dateNaissance.compareTo(o.getDateNaissance()) == 0 ){
        return nom.compareTo(o.getNom());
      }
      else{
        return dateNaissance.compareTo(o.getDateNaissance());
      }
        
    }

    public int compare(Personne o1, Personne o2) {
        
        return o1.getPrenom().compareTo(o2.getPrenom());
    }
    public String toString() {
        System.getProperty ("line.separator");
        return "Personne \n\nMatricule: " + matricule + "\nNom: " + nom + "\nPrenom: " + prenom + "\nSexe: " + sexe
                + "\nDateNaissance: " + dateNaissance + "\nVivantOuNon: " + vivantOuNon ;
    }

    

    
}
