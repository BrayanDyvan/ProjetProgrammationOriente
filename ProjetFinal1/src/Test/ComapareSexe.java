package Test;
import java.util.Comparator;

import Personne.Personne;

public class ComapareSexe implements Comparator <Personne> {

   
    public int compare(Personne o1, Personne o2) {
        
        return o1.getSexe().compareTo(o2.getSexe());
    }

 
    

}
