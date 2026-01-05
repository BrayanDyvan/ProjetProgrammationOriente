package Gestionnaire;


import Personne.ClDate;
public class Administrateur extends Gestionnaire   {
    private String projet;
    private String titre;

    public Administrateur() {
        super();
        this.projet = "";
        this.titre = "";
    }
    public Administrateur(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance,
            boolean vivantOuNon, int nbrEmploye, String secteur, String projet, String titre) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, nbrEmploye, secteur);
        this.projet = projet;
        this.titre = titre;
    }
    public void setProjet(String projet) {
        this.projet = projet;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getProjet() {
        return projet;
    }
    public String getTitre() {
        return titre;
    }
   
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((projet == null) ? 0 : projet.hashCode());
        result = prime * result + ((titre == null) ? 0 : titre.hashCode());
        return result;
    }
  
    public boolean equals(Administrateur obj) {
       
        return (projet.equals(obj.getProjet())
                 &&
                 titre.equals(obj.getTitre()));
    }
    
    public int compareTo(Gestionnaire o) {
      
        return super.compareTo(o);
    }
  
    public int compare(Gestionnaire obj1,Gestionnaire obj2) {
        
        return  super.compare(obj1, obj2);
      }
    
    public String toString() {
        System.getProperty ("line.separator");
        return "\n\nAdministrateur \n"+super.toString()+" \nProjet: " + projet + "\nTitre: " + titre ;
    }

    
}
