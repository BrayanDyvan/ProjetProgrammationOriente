package ForceSecurite;



import java.util.Arrays;

import Personne.ClDate;


public class Armee extends ForceSecurite {
    private int nombreDeSortie;
    private int nbrVictime;
    private  String matriculeDeTousHommes[];
    
    public Armee(){
        super();
        this.nombreDeSortie = 0;
        this.nbrVictime = 0;
        this.matriculeDeTousHommes = new String[5];
    }
    
    public Armee(String matricule, String nom, String prenom, String sexe, ClDate dateNaissance, boolean vivantOuNon,
            String grade, String arme, int anneeDeService, int nombreDeSortie, int nbrVictime,
            String[] matriculeDeTousHommes) {
        super(matricule, nom, prenom, sexe, dateNaissance, vivantOuNon, grade, arme, anneeDeService);
        this.nombreDeSortie = nombreDeSortie;
        this.nbrVictime = nbrVictime;
        this.matriculeDeTousHommes = matriculeDeTousHommes;
    }

    public void setNombreDeSortie(int nombreDeSortie) {
        this.nombreDeSortie = nombreDeSortie;
    }

    public void setNbrVictime(int nbrVictime) {
        this.nbrVictime = nbrVictime;
    }

    public void setMatriculeDeTousHommes(String[] matriculeDeTousHommes) {
        this.matriculeDeTousHommes = matriculeDeTousHommes;
    }

    public int getNombreDeSortie() {
        return nombreDeSortie;
    }

    public int getNbrVictime() {
        return nbrVictime;
    }

    public String[] getMatriculeDeTousHommes() {
        return matriculeDeTousHommes;
    }

 
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nombreDeSortie;
        result = prime * result + nbrVictime;
        result = prime * result + Arrays.hashCode(matriculeDeTousHommes);
        return result;
    }

    
    public boolean equals(Armee obj) {
    
        return (nombreDeSortie== obj.getNombreDeSortie()
                &&
                nbrVictime== obj.getNbrVictime()
                &&
                matriculeDeTousHommes.equals(matriculeDeTousHommes)
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
        return "\n\nArmee "+super.toString()+"\nNombreDeSortie: " + nombreDeSortie + "\nNbrVictime: " + nbrVictime + "\nMatriculeDeTousHommes: "
                + Arrays.toString(matriculeDeTousHommes)  ;
    }

    
    
}
