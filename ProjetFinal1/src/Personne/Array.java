package Personne;


import java.util.ArrayList;

public class Array implements Comparable <Array> {
    private ArrayList<Personne> listPersonne;

    public Array() {
        this.listPersonne = new ArrayList<Personne>();
    }

    public Array(Personne tabPersonne[]) {
        this.listPersonne = new ArrayList<>();

        for (int ctr = 0; ctr < tabPersonne.length; ctr++) {
            listPersonne.add(tabPersonne[ctr]);
        }
    }

    public void setListePersonne(ArrayList<Personne> listPersonne) {
        this.listPersonne = listPersonne;
        
    }

    public ArrayList<Personne> getListPersonnes() {
        return listPersonne;
    }

    public void add(ArrayList<Personne> liste) {
        for (int index = 0; index < liste.size(); index++) {

            listPersonne.add(liste.get(index));

        }
    }

    public void ajouter(Personne unePersonne) {

        listPersonne.add(unePersonne);
    }

    public boolean supprimer(String nom) {
        boolean trouve=true;
        for (int index = 0; index < listPersonne.size(); index++) {
            if (listPersonne.get(index).nom.equals(nom)) {
                trouve=false;
                listPersonne.remove(index);
                System.out.println("Suppression éffectuée avec succè");
            }
        }
        if (trouve) {
            System.out.println("Nom inconnu");
        }
        return trouve;
    }

    public void supprimer(int i) {

        listPersonne.remove(i);
        System.out.println("Suppression éffectuée avec succè");
    }

    public void modifier(int position, Personne unePersonne) {

        listPersonne.set(position, unePersonne);
    }

    public void modifier(String nom, Personne unePersonne) {
        boolean trouve=true;
        for (int index = 0; index < listPersonne.size(); index++) {
            if (listPersonne.get(index).nom.equals(nom)) {
                trouve=false;
                listPersonne.set(index, unePersonne);
            }
        }
        if (trouve) {
            System.out.println("Nom inconnu");
        }
    }

    public int index(String nom) {
        int in=0;
        for (int index = 0; index < listPersonne.size(); index++) {
            if (listPersonne.get(index).nom.equals(nom)) {
              in=index;
              
            }
        }
        return in;
    }
    
    public void clear() {
        listPersonne.clear();
        System.out.println("Ce fichier existe");
    }
    public void clear(int chiffre) {
        listPersonne.clear();
        
    }

    public String rechercher(String nom) {

        boolean a = false;
        int s = 0;
        for (int i = 0; i < listPersonne.size(); i++) {

            if (listPersonne.get(i).nom.equals(nom)) {

                a = true;
                s = i;
            }

        }
        if (a) {
            return ((Personne) (listPersonne.get(s))).toString();
        } else {
            return "Personne inconnue";
        }
    }

    public int indexOf(Personne obj) {

        return listPersonne.indexOf(obj);
    }

    public Personne lire(int position) {
        return listPersonne.get(position);
    }

    public int size() {
        return listPersonne.size();
    }

    public void Afficher() {
        for (int i = 0; i < listPersonne.size(); i++) {
            System.out.println(listPersonne.get(i).toString());

        }

    }

    public int compareTo(Array unaArray) {
        return 0;

    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listPersonne == null) ? 0 : listPersonne.hashCode());
        return result;
    }

    public boolean equals(Array uneList) {

        return listPersonne == uneList.getListPersonnes();
    }

    // public int compareTo(Personne o) {

    // return Personne.compareTo(o);
    // }

}
