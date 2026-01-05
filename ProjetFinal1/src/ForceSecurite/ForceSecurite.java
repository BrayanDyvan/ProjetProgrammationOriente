package ForceSecurite;

import Personne.ClDate;
import Personne.Interface;
import Personne.Personne;

public abstract class ForceSecurite extends Personne implements Interface {
    protected String grade;
    protected String arme;
    protected int anneeDeService;

    public ForceSecurite() {
        super();
        this.grade = "";
        this.arme = "";
        this.anneeDeService = 0;
    }


    public ForceSecurite(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, String grade, String arme, int anneeDeService) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon);
        this.grade = grade;
        this.arme = arme;
        this.anneeDeService = anneeDeService;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setAnneeDeService(int anneeDeService) {
        this.anneeDeService = anneeDeService;
    }

    public String getGrade() {
        return grade;
    }

    public String getArme() {
        return arme;
    }

    public int getAnneeDeService() {
        return anneeDeService;
    }

   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
        result = prime * result + ((arme == null) ? 0 : arme.hashCode());
        result = prime * result + anneeDeService;
        return result;
    }

   
    public boolean equals(ForceSecurite obj) {
    
        return (grade.equals(obj.getGrade())
                &&
                arme.equals(obj.getArme())
                &&
                anneeDeService==obj.getAnneeDeService()
                &&
                super.equals(obj));
    }

    
    public int compareTo(ForceSecurite O) {
        
        return super.compareTo(O);
    }

    
  
   
    public int compare(ForceSecurite o1, ForceSecurite o2) {
        
        return super.compare(o1, o2);
    }


    public String toString() {
        System.getProperty ("line.separator");
        return "\nForceSecurite \n" +super.toString() + "\nGrade: "+grade + "\nArme: " + arme + "\nAnneeDeService: " + anneeDeService ;
    }

    
    
}
