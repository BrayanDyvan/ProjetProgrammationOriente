package Personne;
import java.io.Serializable;

public class ClDate implements Comparable <ClDate>,Serializable{

    private int annee;
    private int mois;
    private int jour;

    //Constructeur par défaut

    public ClDate(){
        annee=2000;
        mois=1;
        jour=1;
    }

    //Constructeur paramétrique

    public ClDate(int _annee, int _mois , int _jour){
        annee=_annee;
        setMois( mois);
        jour=_jour;
    }

    //Set get

    public void setAnnee(int annee){
        this.annee=annee;
        
    }

    public void setMois(int mois){
        this.mois=((mois>0 && mois<=12)? mois:1);

    }

    public void setJours(int jour){
        this.jour=((validerDateComplte(jour))?jour:1) ;

    }

    private boolean validerDateComplte(int jour2) {
        switch (mois) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(jour2>=1 && jour2<=31){

                    return true;
                }
                else{

                    return false;
                } 
                
            case 4:case 6: case 9:case 11:
                if(jour2>=1 && jour2<=30){
                    return true;
                }
                else{
                    return false;
                }
                case 2:
                    if(jour2>=1 && jour2<=28){
                        return true;
                    }
                    if (jour2==29) {
                        
                        if(annee%4==0){
                            if(annee%100==0){
                                if(annee%400==0){
                                    return true;
                                }  
                                else{
                                    return false;
                                }
                            }
                            else{
                                return true;
                            }
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
            default:
                return false;
              
        }
        
    }

    public int getAnnee(){
        return annee;
    }
    public int getMois(){
        return mois;
    }
    public int getJours(){
        return jour;
    }
    

   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + annee;
        result = prime * result + mois;
        result = prime * result + jour;
        return result;
    }

    
    public boolean equals(ClDate obj) {
       
        return (annee ==obj.getAnnee()
                &&
                mois == obj.getMois()
                &&
                jour == obj.getJours());
    }



    
    public int compareTo(ClDate o) {
        
        if (annee > o.getAnnee() ) {
            return 1;
        }
        else if (annee == o.getAnnee()){
            if (mois > o.getMois()) {
                return 1;
            }
            else if (mois == o.getMois()){
                if (jour > o.getJours()) {
                    return 1;
                }
                else if (jour == o.getJours()){
                    return 0;
                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    public String toString(){
        return "l'annee est :"+annee+", le mois est : "+mois+", le jour est : "+jour;
    }
}