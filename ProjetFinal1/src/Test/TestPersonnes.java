package Test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import EmpolyeMaintenance.EmployeManitenance;
import EmpolyeMaintenance.Ingenieur;
import EmpolyeMaintenance.Ouvrier;
import ForceSecurite.Armee;
import ForceSecurite.ForceSecurite;
import ForceSecurite.Milice;
import Gestionnaire.Administrateur;
import Gestionnaire.Gestionnaire;
import Gestionnaire.Scientifique;
import Personne.Array;
import Personne.ClDate;
import Personne.Personne;

// ------------------------------------------------------------------Début du programme

/*----------------------------------------------------------------------------------------------------------------------------------------Instruction enum */
enum Recherche {
    FORCE_DE_SECURITE, GESTIONNAIRE, EMPLOYE_DE_MAINTENANCE
}

public class TestPersonnes {

    /*
     * -----------------------------------------------------------------------------
     * ------------------Données de la classe Scientifique
     */
    static String listeProjtes1[] = { "Projets neurone", "Projets douleur" };
    static String listeProjtes2[] = { "Projets fracture", "Projets blessure" };
    static String listeProjtes3[] = { "Projets handicap", "Projets emoragie" };
    static String listeProjtes4[] = { "Projets energie", "Projets trouble psychologique" };
    private static Scientifique unScientifique = new Scientifique("A24", "Laye", "dominique", "M",
            new ClDate(2002, 05, 02), true, 4, "Medecine", 2, listeProjtes1);
    private static Scientifique deuxScientifique = new Scientifique("A25", "Lebien", "rodrigue", "M",
            new ClDate(1998, 02, 10), true, 4, "Medecine", 2, listeProjtes2);
    private static Scientifique troisScientifique = new Scientifique("A26", "Mire", "sana", "F",
            new ClDate(2001, 05, 17), true, 4, "Medecine", 2, listeProjtes3);
    private static Scientifique quatreScientifique = new Scientifique("A27", "Marie", "Paul", "F",
            new ClDate(2000, 01, 29), true, 4, "Medecine", 2, listeProjtes4);

    /*--------------------------------------------------------------------------------------------------------- Données de la classe Administrateur */

    private static Administrateur unAdministrateur = new Administrateur("A20", "Mio", "dominique", "M",
            new ClDate(1988, 9, 01), true, 4, "Medecine", "Projets neurone", "Direteur de projet");
    private static Administrateur deuxAdministrateur = new Administrateur("A21", "Lee", "junior", "M",
            new ClDate(1998, 6, 01), true, 4, "Medecine", "Projets fracture", "Sous-Direteur de projet");
    private static Administrateur troisAdministrateur = new Administrateur("A22", "Lana", "priscilia", "F",
            new ClDate(1982, 9, 01), true, 4, "Medecine", "Projets handicap", "Diretrice de projet");
    private static Administrateur quatreAdministrateur = new Administrateur("A23", "Maurice", "lionnel", "M",
            new ClDate(1983, 9, 01), true, 4, "Medecine", "Projets trouble psychologique", "Direteur de projet");

    /*
     * -----------------------------------------------------------------------------
     * ----------------------------------------------Données de la classe Milice
     */

    private static Milice uneMilice = new Milice("A16", "Jiyo", "bred", "M",
            new ClDate(2000, 9, 23), true, "2", "Pistolet Beretta 92", 1, 0);
    private static Milice deuxMilice = new Milice("A17", "Bill", "garie", "M",
            new ClDate(2003, 5, 3), true, "1", "Pistolet Mitrailleur 92", 1, 1);
    private static Milice troisMilice = new Milice("A18", "Janeta", "shine", "F",
            new ClDate(1999, 4, 10), true, "3", "Pistolet Beretta 92", 3, 0);
    private static Milice quatreMilice = new Milice("A19", "Imelda", "valadaress", "F",
            new ClDate(2001, 11, 20), true, "2", "Mitrailleur PKM 92", 2, 0);

    /*------------------------------------------------------------------------------------------------------------------------ Données de la classe Armée */

    static String matricules1[] = { "B1", "B2", "B3" };
    static String matricules2[] = { "B4", "B5", "B6" };
    static String matricules3[] = { "B7", "B8", "B9" };
    static String matricules4[] = { "B10", "B11", "B12" };

    private static Armee uneArmee = new Armee("A12", "Mars", "beri", "M",
            new ClDate(2000, 9, 23), true, "2", "Pistolet Beretta 92", 1, 3, 4, matricules1);
    private static Armee deuxArmee = new Armee("A13", "Bele", "yan", "M",
            new ClDate(2001, 10, 13), true, "1", "Carabine", 2, 5, 4, matricules2);
    private static Armee troisArmee = new Armee("A14", "Yoji", "ken", "M",
            new ClDate(2002, 4, 03), true, "2", "Fusil", 2, 3, 6, matricules3);
    private static Armee quatreArmee = new Armee("A15", "Gari", "ye", "M",
            new ClDate(2000, 3, 12), true, "3", "Pistolet Beretta 92", 3, 3, 4, matricules4);

    /* Donnée de la classe Ouvrier */
    static int quart1[] = { 4, 8 };
    static int quart2[] = { 4, 8 };
    static int quart3[] = { 12, 4 };
    static int quart4[] = { 4, 8 };
    private static Ouvrier unOuvrier = new Ouvrier("A11", "Mars", "beri", "M",
            new ClDate(2004, 9, 24), true, "Epicerie", "Maxi Barkoff", quart1, "Commis", 4);
    private static Ouvrier deuxOuvrier = new Ouvrier("A10", "Nick", "martial", "M",
            new ClDate(2003, 5, 3), true, "Fruit", "IGA", quart1, "Commis", 4);
    private static Ouvrier troisOuvrier = new Ouvrier("A9", "Embolo", "loic", "M",
            new ClDate(2002, 9, 13), true, "Viande", "Walmart", quart1, "Commis", 4);
    private static Ouvrier quatreOuvrier = new Ouvrier("A8", "St-laurent", "yves", "M",
            new ClDate(2001, 8, 23), true, "Caisse", "Dollarama", quart1, "Commis", 4);

    /*--------------------------------------------------------------------------------------- Donnée de la classe Ingenieur */

    private static Ingenieur unIngenieur = new Ingenieur("A7", "Nel", "cruz", "M",
            new ClDate(1993, 2, 4), true, "Informatique", "ManelCanada", "genie logiciel", new ClDate(2012, 2, 4), 3);
    private static Ingenieur deuxIngenieur = new Ingenieur("A6", "Babi", "bel", "M",
            new ClDate(1992, 8, 16), true, "Electricite", "Hydro-Quebec", "genie ", new ClDate(2015, 8, 16), 3);
    private static Ingenieur troisIngenieur = new Ingenieur("A5", "Marie", "elown", "F",
            new ClDate(1993, 2, 14), true, "genie civil", "Mairie", "genie", new ClDate(2016, 2, 14), 3);
    private static Ingenieur quatreIngenieur = new Ingenieur("A4", "Miga", "nathanael", "F",
            new ClDate(1993, 2, 4), true, "Informatique", "OrdiPlus", "genie logiciel", new ClDate(2015, 2, 4), 3);

    /*---------------------------------------------------------------------------------------Instanciation de la classe Array */
    private static Array listForceSecurite = new Array();
    private static Array listEmployeMaintenance = new Array();
    private static Array listGestionnaire = new Array();

    /*---------------------------------------------------------------------------------------Utilisation de l'instruction enum */
    String nom;
    Recherche personne;

    public TestPersonnes(Recherche personne, String nom) {
        this.personne = personne;
        this.nom = nom;
    }

    public void rechercheNom() {
        switch (personne) {
            case FORCE_DE_SECURITE:

                System.out.println(listForceSecurite.rechercher(nom));

                break;
            case GESTIONNAIRE:

                System.out.println(listGestionnaire.rechercher(nom));

                break;
            case EMPLOYE_DE_MAINTENANCE:

                System.out.println(listEmployeMaintenance.rechercher(nom));

                break;

            default:
                break;
        }
    }

    // ---------------------------------------------------------------------------------------------------Méthode
    // main de la classe TestPersonne
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        // ------------------------------------------------------------------------------------------------------Déclaration
        // et intialisation des variables

        String choix[] = { "Ajouts des personnes", "Supressions des personnes", "Modifications des personnes",
                "Recherche des personnes", "Affiche les personnes",
                "Trie les personnes du moins agé au plus agé", "Mêle les positions des personnes",
                "Autres Trie", "Visualise les modifications",
                "Sauvegarder en fichier text", "Affichage des fichiers textes",
                "Quitter" };
        String strChoice = null;
        int choice = 0;
        int choicePersonne;
        int choiceTousPersonne;
        Personne unePersonne;

        String matricule;
        String nom;
        String nomAModifier;
        String prenom;
        String sexe;
        String jour;
        String annee;
        String mois;
        int ijour;
        int iannee;
        int imois;
        ClDate dateNaissance;
        boolean vivantOuNon = true;
        String vie;
        String grade;
        String arme;
        String anneeDeService;
        String nombreDePlainte;
        int ianneeDeService;
        int inombreDeplainte;
        String nombreDeSortie;
        String nbrVictime;
        String matriculeDeTousHommes[] = {};
        String matriculeHomme;
        int inombreDeSortie;
        int inbrVictime;
        int a = 0;
        String nbrEmploye;
        int inbrEmploye;
        String secteur;
        String lieuDeTravail;
        String projet;
        String titre;
        int nbrprojets;
        String listedeProjets[] = {};
        String specialite;
        ClDate dateFinEtude;
        String niveauEtude;
        int iniveauEtude;
        int quartTravail[] = { 0 ,2};
        String genreTravail;
        int nbrSecteur;
        String heureDebut;
        String heureFin;
        int iheureDebut;
        int iheureFin;
        String position;
        int iPosition;
        boolean trouve = false;
        boolean repet = false;

        String choixPersonne[] = { "Force de sécurité", "Gestionnaire", "Employé de maintenance", "Quitter" };
        String choixTousPersonne[] = { "Force de sécurité", "Gestionnaire", "Employé de maintenance",
                "Tous les humains" };
        String choixForceSecurite[] = { "Milice", "Armée" };
        String choixGestionnaire[] = { "Administrateur", "Scientifique", };
        String choixEmployeMaintenance[] = { "Ingenieur", "Ouvrier" };
        String choixSuppression[] = { "nom", "position" };
        int choiceSuppression;
        String choixModification[] = { "nom", "position" };
        String choixTrieForceSecurite[] = { "Prenom", "Sexe" };
        int choiceTrieForceSecurite;
        String choixTrieGestionnaire[] = { "Prenom", "Sexe" };
        int choiceTrieGestionnaire;
        String choixTrieEmploye[] = { "Prenom", "Sexe" };
        int choiceTrieEmploye;
        String choixTriePersonne[] = { "Prenom", "Sexe" };
        int choiceTriePersonne;
        int choiceModification;
        int choiceForceSecurite;
        int choiceGestionnaire;
        int choiceEmployeMaintenance;
        int selectionForce = 0;
        int selectionGestion = 0;
        int selectionEmploye = 0;

        listForceSecurite.ajouter((ForceSecurite) uneArmee);
        listForceSecurite.ajouter((ForceSecurite) deuxArmee);
        listForceSecurite.ajouter((ForceSecurite) troisArmee);
        listForceSecurite.ajouter((ForceSecurite) quatreArmee);
        listForceSecurite.ajouter((ForceSecurite) uneMilice);
        listForceSecurite.ajouter((ForceSecurite) deuxMilice);
        listForceSecurite.ajouter((ForceSecurite) troisMilice);
        listForceSecurite.ajouter((ForceSecurite) quatreMilice);

        listGestionnaire.ajouter((Gestionnaire) unAdministrateur);
        listGestionnaire.ajouter((Gestionnaire) deuxAdministrateur);
        listGestionnaire.ajouter((Gestionnaire) troisAdministrateur);
        listGestionnaire.ajouter((Gestionnaire) quatreAdministrateur);
        listGestionnaire.ajouter((Gestionnaire) unScientifique);
        listGestionnaire.ajouter((Gestionnaire) deuxScientifique);
        listGestionnaire.ajouter((Gestionnaire) troisScientifique);
        listGestionnaire.ajouter((Gestionnaire) quatreScientifique);

        listEmployeMaintenance.ajouter((EmployeManitenance) unIngenieur);
        listEmployeMaintenance.ajouter((EmployeManitenance) deuxIngenieur);
        listEmployeMaintenance.ajouter((EmployeManitenance) troisIngenieur);
        listEmployeMaintenance.ajouter((EmployeManitenance) quatreIngenieur);
        listEmployeMaintenance.ajouter((EmployeManitenance) unOuvrier);
        listEmployeMaintenance.ajouter((EmployeManitenance) deuxOuvrier);
        listEmployeMaintenance.ajouter((EmployeManitenance) troisOuvrier);
        listEmployeMaintenance.ajouter((EmployeManitenance) quatreOuvrier);

        Array listPersonne = new Array();

        listPersonne.add(listForceSecurite.getListPersonnes());
        listPersonne.add(listEmployeMaintenance.getListPersonnes());
        listPersonne.add(listGestionnaire.getListPersonnes());
        // ------------------------------------------------------------Creation de
        // fichier par défaut
        File forceSecu = new File("Forces de securité");
        File gestion = new File("Gestion");
        File employes = new File("Employé de maintenance");

        FileWriter sortieforceSecu = null;
        FileWriter sortieGestion = null;
        FileWriter sortieEmploye = null;

        JFileChooser choixFichierForce = new JFileChooser();
        JFileChooser choixFichierGestion = new JFileChooser();
        JFileChooser choixFichierEmploye = new JFileChooser();

        // ------------------------------------------------------------------ Donne le
        // nom du fichier et selectionne son emplacement

        File fichierSauvegarde = new File("bunker");
        JFileChooser choixFichier = new JFileChooser();
        // ---------------------------------------------------------Petiit rappel sur la
        // sauvegarde de données
        JOptionPane.showMessageDialog(null,
                "Attention si vous cliquer sur annuler lors du choix de l'emplacement du fichier, \n un fichier par défaut nommé bunker.ser est créé dans le dossier ProjetFinal1",
                "Attention!", JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(null, "Ne mettez pas d'extention après le nom du fichier", "Petit Rappel",
                JOptionPane.INFORMATION_MESSAGE);
        // -----------------------------------------------------------Sélection de
        // l'emplacement du fichier
        choixFichier.setDialogTitle("Sélectionne l'emplacement du fichier et donne lui un nom.");

        int selection = choixFichier.showSaveDialog(null);

        if (selection == JFileChooser.APPROVE_OPTION) {
            fichierSauvegarde = choixFichier.getSelectedFile();
            System.out.println("Le fichier a été enregistrer sous :" + fichierSauvegarde.getAbsolutePath() + ".ser");
        }

        File test = new File(fichierSauvegarde + ".ser");
        FileInputStream ftmBinaireBunker = null;
        ObjectInputStream entree = null;

        FileOutputStream ftmBinaireSortieBunker = null;
        ObjectOutput sortie = null;

        // ---------------------------------------------------------------récupération
        // des données
        if (test.exists()) {

            try {
                // --------------------------------------------------------------------------------Vide
                // l'arraylist des personnes
                listPersonne.clear();
                System.out.println("\nRécupération des données...");
                System.out.println("La liste des personnes est prête.\n");
                ftmBinaireBunker = new FileInputStream(fichierSauvegarde + ".ser");
                entree = new ObjectInputStream(ftmBinaireBunker);
            } catch (IOException e) {
                System.out.println("Msg: " + e.getMessage());
                System.exit(0);
            }

            try {
                listPersonne.setListePersonne((ArrayList<Personne>) entree.readObject());
                // ---------------------------------------------------------------Chargement de
                // données
                listForceSecurite.clear(1);
                listGestionnaire.clear(1);
                listEmployeMaintenance.clear(1);

                for (int i = 0; i < listPersonne.size(); i++) {
                    Personne obj = listPersonne.getListPersonnes().get(i);
                    if (obj instanceof ForceSecurite) {

                        listForceSecurite.ajouter(obj);
                    } else if (obj instanceof Gestionnaire) {

                        listGestionnaire.ajouter(obj);
                    } else {

                        listEmployeMaintenance.ajouter(obj);
                    }

                }

                entree.close();

            } catch (IOException e) {
                System.out.println("Erreur de lecture 1: " + e.getMessage());
                System.exit(0);
            } catch (ClassNotFoundException e) {
                System.out.println("Erreur de lecture 1: " + e.getMessage());
                System.exit(0);
            }
        }
        // -------------------------------------------------------------------------------------------Création
        // du fichier
        else {

            try {

                ftmBinaireSortieBunker = new FileOutputStream(fichierSauvegarde + ".ser");
                sortie = new ObjectOutputStream(ftmBinaireSortieBunker);
            } catch (IOException e) {
                System.out.println("Msg: " + e.getMessage());
                System.out.println("Ne peut créer le canal de sortie pour: " + (fichierSauvegarde + ".ser"));
                System.exit(0);
            }

            try {
                // ---------------------------------------------------------------Remplisage du
                // fichier
                sortie.writeObject(listPersonne.getListPersonnes());
                sortie.close();
                System.out.println("Le fichier a été enregistrer sous :" + fichierSauvegarde.getAbsolutePath() + ".ser");

            } catch (IOException e) {
                System.out
                        .println("Erreur dans les opérations du canal de sortie lors de l'écriture: " + e.getMessage());
                System.exit(0);
            }
        }

        /*----------------------------------------------------------------------------------------------------------------------Définition du motif regexPattern */

        Pattern pattern = Pattern.compile("^[A-Z]{1}[0-9]*");

        do {
            try {
                // -----------------------------------------------------------------------------Liste
                // de choix d'opérations

                strChoice = (String) JOptionPane.showInputDialog(null, "Choix de l'option", "Options",
                        JOptionPane.PLAIN_MESSAGE, null, choix, choix[11]);
                System.out.println("\nChoix:------- " + strChoice + ".");

                switch (strChoice) {
                    case "Ajouts des personnes":
                        choice = 0;
                        break;
                    case "Supressions des personnes":
                        choice = 1;
                        break;
                    case "Modifications des personnes":
                        choice = 2;
                        break;
                    case "Recherche des personnes":
                        choice = 3;
                        break;
                    case "Affiche les personnes":
                        choice = 4;
                        break;
                    case "Trie les personnes du moins agé au plus agé":
                        choice = 5;
                        break;
                    case "Mêle les positions des personnes":
                        choice = 6;
                        break;
                    case "Autres Trie":
                        choice = 7;

                        break;
                    case "Visualise les modifications":
                        choice = 8;

                        break;
                    case "Sauvegarder en fichier text":
                        choice = 9;

                        break;
                    case "Affichage des fichiers textes":
                        choice = 10;

                        break;
                    case "Quitter":
                        choice = 11;
                        break;

                    default:
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Erreur dans la conversion  " + e.getLocalizedMessage());
            } catch (Exception exc) {
                System.out.println("Erreur Le choix ne doit pas etre null\nFin du Programme ");
                System.exit(0);
            }
            switch (choice) {

                // --------------------------------------------------------Opération ajouter

                case 0:
                    choicePersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixPersonne, choixPersonne[0]);
                    switch (choicePersonne) {

                        // ---------------------------------------------------------Ajouter une Force de
                        // sécurité

                        case 0:
                            choiceForceSecurite = JOptionPane.showOptionDialog(null, "Choix de force de sécurité",
                                    "Force de sécurité",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixForceSecurite,
                                    choixForceSecurite[0]);
                            switch (choiceForceSecurite) {
                                // -----------------------------------------------Ajoute une Milice
                                case 0:
                                    try {

                                        do {

                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(listEmployeMaintenance.getListPersonnes().get(i)
                                                        .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;

                                        nom = JOptionPane.showInputDialog("Entre le nom ");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog(" entre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = true;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = false;
                                        }
                                        grade = JOptionPane.showInputDialog("Entre le grade");
                                        arme = JOptionPane.showInputDialog("Entre l'arme");
                                        anneeDeService = JOptionPane
                                                .showInputDialog("Entre le nombre d'année de service");
                                        ianneeDeService = Integer.parseInt(anneeDeService);
                                        nombreDePlainte = JOptionPane.showInputDialog("Entre le nombre de plainte");
                                        inombreDeplainte = Integer.parseInt(nombreDePlainte);

                                        unePersonne = new Milice(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon,
                                                grade,
                                                arme, ianneeDeService, inombreDeplainte);
                                        listForceSecurite.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }

                                    break;

                                case 1:

                                    // --------------------------------------------------------Ajoute une armée

                                    try {
                                        do {
                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listEmployeMaintenance.getListPersonnes().get(i)
                                                                .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = false;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = true;
                                        }
                                        grade = JOptionPane.showInputDialog("Entre le grade");
                                        arme = JOptionPane.showInputDialog("Entre l'arme");
                                        anneeDeService = JOptionPane
                                                .showInputDialog("Entre le nombre d'année de service");
                                        ianneeDeService = Integer.parseInt(anneeDeService);
                                        nombreDeSortie = JOptionPane.showInputDialog("Entre le nombre de sortie");
                                        inombreDeSortie = Integer.parseInt(nombreDeSortie);
                                        nbrVictime = JOptionPane.showInputDialog("Entre le nombre de victime");
                                        inbrVictime = Integer.parseInt(nbrVictime);
                                        do {
                                            matriculeHomme = JOptionPane.showInputDialog(null,
                                                    "Entre le matricule de la personne\nEntre 0 pour terminer",
                                                    "Matricule des hommes", JOptionPane.PLAIN_MESSAGE);
                                            matriculeDeTousHommes[a] = matriculeHomme;
                                            a++;
                                        } while (matriculeHomme != "0");
                                        a = 0;
                                        unePersonne = new Armee(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon,
                                                grade,
                                                arme, ianneeDeService, inombreDeSortie, inbrVictime,
                                                matriculeDeTousHommes);
                                        listForceSecurite.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out
                                                .println(" Erreur dans la conversion  de " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;

                        // ----------------------------------------------------------Ajout de
                        // gestionnaire
                        case 1:
                            choiceGestionnaire = JOptionPane.showOptionDialog(null, "Choix de gestionaire",
                                    "Gestionnaire",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixGestionnaire,
                                    choixGestionnaire[0]);
                            switch (choiceGestionnaire) {
                                // --------------------------------------------Ajout d'un adminisatrateur
                                case 0:
                                    try {
                                        do {
                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listEmployeMaintenance.getListPersonnes().get(i)
                                                                .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = true;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = false;
                                        }
                                        nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                        inbrEmploye = Integer.parseInt(nbrEmploye);
                                        secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                        projet = JOptionPane.showInputDialog("quel est  le projet");
                                        titre = JOptionPane.showInputDialog("quel est  le titre");
                                        unePersonne = new Administrateur(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon,
                                                inbrEmploye, secteur, projet, titre);
                                        listGestionnaire.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }
                                    break;

                                // ----------------------------------------------------------------------Ajout
                                // d'un scientifique

                                case 1:
                                    try {
                                        do {
                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listEmployeMaintenance.getListPersonnes().get(i)
                                                                .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = true;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = false;
                                        }
                                        nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                        inbrEmploye = Integer.parseInt(nbrEmploye);
                                        secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                        projet = JOptionPane.showInputDialog("quel est  le nombre de projet");
                                        nbrprojets = Integer.parseInt(projet);
                                        do {
                                            projet = JOptionPane.showInputDialog(null,
                                                    "Entre le projet\nEntre 0 pour terminer", "Liste de projets",
                                                    JOptionPane.PLAIN_MESSAGE);
                                            listedeProjets[a] = projet;
                                            a++;
                                        } while (projet != "0");
                                        a = 0;
                                        unePersonne = new Scientifique(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon,
                                                inbrEmploye, secteur, nbrprojets, listedeProjets);
                                        listGestionnaire.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;

                        // --------------------------------------------------Ajout d'un employé de
                        // maintnance
                        case 2:
                            choiceEmployeMaintenance = JOptionPane.showOptionDialog(null,
                                    "Choix de employé de maintenance",
                                    "Employé de maintenance",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixEmployeMaintenance,
                                    choixEmployeMaintenance[0]);
                            switch (choiceEmployeMaintenance) {

                                // -----------------------------------------------------------------------Ajout
                                // d'uun ingénieur

                                case 0:
                                    try {
                                        do {
                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listEmployeMaintenance.getListPersonnes().get(i)
                                                                .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog("Eentre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = true;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = false;
                                        }

                                        secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                        lieuDeTravail = JOptionPane.showInputDialog("quel est  le lieu de travail?");
                                        specialite = JOptionPane.showInputDialog("quel est  la spécialité?");
                                        jour = JOptionPane.showInputDialog("Entre le jour de fin d'étude");
                                        annee = JOptionPane.showInputDialog("Entre l'année de fin d'étude");
                                        mois = JOptionPane.showInputDialog("Entre le mois de fin d'étude");
                                        ijour = Integer.parseInt(jour);
                                        imois = Integer.parseInt(mois);
                                        iannee = Integer.parseInt(annee);
                                        dateFinEtude = new ClDate(iannee, imois, ijour);
                                        niveauEtude = JOptionPane.showInputDialog("quel est  le niveau d'étude?");
                                        iniveauEtude = Integer.parseInt(niveauEtude);

                                        unePersonne = new Ingenieur(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon, secteur, lieuDeTravail,
                                                specialite, dateFinEtude, iniveauEtude);
                                        listEmployeMaintenance.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }
                                    break;
                                case 1:
                                    // -----------------------------------------------------Ajout d'un ouvrier

                                    try {
                                        do {
                                            matricule = JOptionPane.showInputDialog("Entre le matricule");
                                            for (int i = 0; i < listForceSecurite.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listForceSecurite.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listGestionnaire.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listGestionnaire.getListPersonnes().get(i).getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            for (int i = 0; i < listEmployeMaintenance.getListPersonnes().size(); i++) {
                                                if (matricule.equals(
                                                        listEmployeMaintenance.getListPersonnes().get(i)
                                                                .getMatricule())) {
                                                    trouve = true;
                                                    System.out.println("Ce matricule existe déjà");
                                                }
                                            }
                                            if (trouve) {
                                                repet = true;
                                                trouve = false;
                                            } else {
                                                repet = false;
                                            }

                                            Matcher matcher = pattern.matcher(matricule);
                                            boolean found = matcher.find();

                                            if (found) {

                                            } else {
                                                repet = true;
                                                System.out.println(
                                                        "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                            }
                                        } while (repet == true);
                                        trouve = false;
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        prenom = JOptionPane.showInputDialog("Entre le prenom");
                                        sexe = JOptionPane.showInputDialog("Entre le sexe");
                                        jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                        ijour = Integer.parseInt(jour);
                                        annee = JOptionPane.showInputDialog("Entre l'année");
                                        iannee = Integer.parseInt(annee);
                                        mois = JOptionPane.showInputDialog("Entre le mois");
                                        imois = Integer.parseInt(mois);
                                        dateNaissance = new ClDate(iannee, imois, ijour);
                                        vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                        if (vie.equals("1")) {
                                            vivantOuNon = true;
                                        } else if (vie.equals("2")) {
                                            vivantOuNon = false;
                                        }

                                        secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                        lieuDeTravail = JOptionPane.showInputDialog("quel est  le lieu de travail?");
                                        heureDebut = JOptionPane
                                                .showInputDialog("quel est  l'heure de début du quart de travail?");
                                        heureFin = JOptionPane
                                                .showInputDialog("quel est  l'heure de fin du quart de travail?");
                                        iheureDebut = Integer.parseInt(heureDebut);
                                        iheureFin = Integer.parseInt(heureFin);
                                        quartTravail[0] = iheureDebut;
                                        quartTravail[1] = iheureFin;
                                        genreTravail = JOptionPane.showInputDialog("quel est  le genre de travail?");
                                        secteur = JOptionPane.showInputDialog("quel est  le nombre de  secteur?");
                                        nbrSecteur = Integer.parseInt(secteur);

                                        unePersonne = new Ouvrier(matricule, nom, prenom, sexe, dateNaissance,
                                                vivantOuNon, secteur, lieuDeTravail, quartTravail, genreTravail,
                                                nbrSecteur);
                                        listEmployeMaintenance.ajouter(unePersonne);

                                        System.out.println("Ajout de " + nom + " éffectué avec succè");

                                    } catch (NumberFormatException e) {
                                        System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                                    } catch (Exception exc) {
                                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                // ---------------------------------------------------------------Opération de
                // suppréssions
                case 1:

                    choicePersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixPersonne, choixPersonne[0]);
                    switch (choicePersonne) {
                        // --------------------------------------------------suppréssion de force de
                        // sécurité
                        case 0:
                            try {
                                choiceSuppression = JOptionPane.showOptionDialog(null, "Supprime avec le | la ",
                                        "Suppression",
                                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixSuppression,
                                        choixSuppression[0]);
                                switch (choiceSuppression) {
                                    case 0:
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        listForceSecurite.supprimer(nom);
                                        break;
                                    case 1:
                                        position = JOptionPane.showInputDialog("Entre la position");
                                        iPosition = Integer.parseInt(position);
                                        listForceSecurite.supprimer(iPosition);
                                        break;

                                    default:
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                            } catch (IndexOutOfBoundsException exc) {
                                System.out.println("dépassement invalide = " + exc.getMessage());
                            } catch (Exception exc) {
                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                            }
                            break;
                        case 1:
                            // --------------------------------------------------------Suppréssion de
                            // gestionnaire
                            try {
                                choiceSuppression = JOptionPane.showOptionDialog(null, "Supprime avec le | la ",
                                        "Suppression",
                                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixSuppression,
                                        choixSuppression[0]);
                                switch (choiceSuppression) {
                                    case 0:
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        listGestionnaire.supprimer(nom);
                                        break;
                                    case 1:
                                        position = JOptionPane.showInputDialog("Entre la position");
                                        iPosition = Integer.parseInt(position);
                                        listGestionnaire.supprimer(iPosition);
                                        break;

                                    default:
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                            } catch (IndexOutOfBoundsException exc) {
                                System.out.println("dépassement invalide = " + exc.getMessage());
                            } catch (Exception exc) {
                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                            }
                            break;
                        case 2:
                            // -----------------------------------------------------------Suppréssion
                            // d'employé de maintenance
                            try {
                                choiceSuppression = JOptionPane.showOptionDialog(null, "Supprime avec le | la ",
                                        "Suppression",
                                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixSuppression,
                                        choixSuppression[0]);
                                switch (choiceSuppression) {
                                    case 0:
                                        nom = JOptionPane.showInputDialog("Entre le nom");
                                        listEmployeMaintenance.supprimer(nom);

                                        break;
                                    case 1:
                                        position = JOptionPane.showInputDialog("Entre la position");
                                        iPosition = Integer.parseInt(position);
                                        listEmployeMaintenance.supprimer(iPosition);
                                        break;

                                    default:
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(" Erreur dans la conversion  " + e.getLocalizedMessage());
                            } catch (IndexOutOfBoundsException exc) {
                                System.out.println("dépassement invalide = " + exc.getMessage());
                            } catch (Exception exc) {
                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                // --------------------------------------------------------------Opérations de
                // modification
                case 2:
                    choicePersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixPersonne, choixPersonne[0]);
                    switch (choicePersonne) {
                        case 0:
                            // ----------------------------------------Modification de force de sécurité
                            choiceModification = JOptionPane.showOptionDialog(null, "Modifie avec le | la ",
                                    "Modification",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixModification,
                                    choixModification[0]);
                            switch (choiceModification) {
                                // ----------------------------------------Modification de force de sécurité à
                                // partir du nom
                                case 0:
                                    choiceForceSecurite = JOptionPane.showOptionDialog(null,
                                            "Choix de force de sécurité",
                                            "Force de sécurité",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixForceSecurite,
                                            choixForceSecurite[0]);
                                    switch (choiceForceSecurite) {
                                        // -----------------------------------------------------Modification de Milice à
                                        // partir du nom de la personne
                                        case 0:
                                            try {
                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                                

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                grade = JOptionPane.showInputDialog("Entre le grade");
                                                arme = JOptionPane.showInputDialog("Entre l'arme");
                                                anneeDeService = JOptionPane
                                                        .showInputDialog("Entre le nombre d'année de service");
                                                ianneeDeService = Integer.parseInt(anneeDeService);
                                                nombreDePlainte = JOptionPane
                                                        .showInputDialog("Entre le nombre de plainte");
                                                inombreDeplainte = Integer.parseInt(nombreDePlainte);

                                                unePersonne = new Milice(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon,
                                                        grade,
                                                        arme, ianneeDeService, inombreDeplainte);
                                                listForceSecurite.modifier(nomAModifier, unePersonne);

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        case 1:
                                            // ----------------------------------------------------Modification d'armée
                                            // à partir du nom de la personne
                                            try {
                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                              

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                ijour = Integer.parseInt(jour);
                                                imois = Integer.parseInt(mois);
                                                iannee = Integer.parseInt(annee);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = false;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = true;
                                                }
                                                grade = JOptionPane.showInputDialog("Entre le grade");
                                                arme = JOptionPane.showInputDialog("Entre l'arme");
                                                anneeDeService = JOptionPane
                                                        .showInputDialog("Entre le nombre d'année de service");
                                                ianneeDeService = Integer.parseInt(anneeDeService);
                                                nombreDeSortie = JOptionPane
                                                        .showInputDialog("Entre le nombre de sortie");
                                                inombreDeSortie = Integer.parseInt(nombreDeSortie);
                                                nbrVictime = JOptionPane.showInputDialog("Entre le nombre de victime");
                                                inbrVictime = Integer.parseInt(nbrVictime);
                                                do {
                                                    matriculeHomme = JOptionPane.showInputDialog(null,
                                                            "Entre le matricule de la personne\nEntre 0 pour terminer",
                                                            "Matricule des hommes", JOptionPane.PLAIN_MESSAGE);
                                                    matriculeDeTousHommes[a] = matriculeHomme;
                                                    a++;
                                                } while (matriculeHomme != "0");
                                                a = 0;
                                                unePersonne = new Armee(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon,
                                                        grade,
                                                        arme, ianneeDeService, inombreDeSortie, inbrVictime,
                                                        matriculeDeTousHommes);
                                                listForceSecurite.modifier(nomAModifier, unePersonne);

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 1:
                                    // --------------------------------------------------------------Modification de
                                    // force de sécurité à partir de la position
                                    choiceForceSecurite = JOptionPane.showOptionDialog(null,
                                            "Choix de force de sécurité",
                                            "Force de sécurité",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixForceSecurite,
                                            choixForceSecurite[0]);
                                    switch (choiceForceSecurite) {
                                        // ----------------------------------------------------Modification de milice à
                                        // partir de la position de la personne
                                        case 0:
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                                
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");

                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                grade = JOptionPane.showInputDialog("Entre le grade");
                                                arme = JOptionPane.showInputDialog("Entre l'arme");
                                                anneeDeService = JOptionPane
                                                        .showInputDialog("Entre le nombre d'année de service");
                                                ianneeDeService = Integer.parseInt(anneeDeService);
                                                nombreDePlainte = JOptionPane
                                                        .showInputDialog("Entre le nombre de plainte");
                                                inombreDeplainte = Integer.parseInt(nombreDePlainte);

                                                unePersonne = new Milice(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon,
                                                        grade,
                                                        arme, ianneeDeService, inombreDeplainte);
                                                listForceSecurite.modifier(iPosition, unePersonne);

                                                System.out.println("Modification  éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        case 1:
                                            // ----------------------------------------------------Modification d'armée
                                            // à partir de la postion de la personne
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                                
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = false;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = true;
                                                }
                                                grade = JOptionPane.showInputDialog("Entre le grade");
                                                arme = JOptionPane.showInputDialog("Entre l'arme");
                                                anneeDeService = JOptionPane
                                                        .showInputDialog("Entre le nombre d'année de service");
                                                ianneeDeService = Integer.parseInt(anneeDeService);
                                                nombreDeSortie = JOptionPane
                                                        .showInputDialog("Entre le nombre de sortie");
                                                inombreDeSortie = Integer.parseInt(nombreDeSortie);
                                                nbrVictime = JOptionPane.showInputDialog("Entre le nombre de victime");
                                                inbrVictime = Integer.parseInt(nbrVictime);
                                                do {
                                                    matriculeHomme = JOptionPane.showInputDialog(null,
                                                            "Entre le matricule de la personne\nEntre 0 pour terminer",
                                                            "Matricule des hommes", JOptionPane.PLAIN_MESSAGE);
                                                    matriculeDeTousHommes[a] = matriculeHomme;
                                                    a++;
                                                } while (matriculeHomme != "0");
                                                a = 0;
                                                unePersonne = new Armee(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon,
                                                        grade,
                                                        arme, ianneeDeService, inombreDeSortie, inbrVictime,
                                                        matriculeDeTousHommes);
                                                listForceSecurite.modifier(iPosition, unePersonne);

                                                System.out.println("Modification  éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                default:
                                    break;
                            }
                            break;
                        case 1:
                            // ----------------------------------------------------Modification de
                            // Gestionnaires
                            choiceModification = JOptionPane.showOptionDialog(null, "Modifie avec le | la ",
                                    "Modification",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixModification,
                                    choixModification[0]);
                            switch (choiceModification) {
                                case 0:
                                    // ----------------------------------------------------Modification de
                                    // Gestionnaires à partir du nom
                                    choiceGestionnaire = JOptionPane.showOptionDialog(null, "Choix de gestionaire",
                                            "Gestionnaire",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixGestionnaire,
                                            choixGestionnaire[0]);
                                    switch (choiceGestionnaire) {
                                        // ----------------------------------------------------Modification
                                        // d'administrateurs à partir du nom de la personne
                                        case 0:
                                            try {
                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                                

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                                inbrEmploye = Integer.parseInt(nbrEmploye);
                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                projet = JOptionPane.showInputDialog("quel est  le projet");
                                                titre = JOptionPane.showInputDialog("quel est  le titre");
                                                unePersonne = new Administrateur(matricule, nom, prenom, sexe,
                                                        dateNaissance,
                                                        vivantOuNon,
                                                        inbrEmploye, secteur, projet, titre);
                                                listGestionnaire.modifier(nomAModifier, unePersonne);

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;

                                        case 1:
                                            // ----------------------------------------------------Modification de
                                            // scientifiques à partir du nom de la personne
                                            try {
                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                                

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                                inbrEmploye = Integer.parseInt(nbrEmploye);
                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                projet = JOptionPane.showInputDialog("quel est  le nombre de projet");
                                                nbrprojets = Integer.parseInt(projet);
                                                do {
                                                    projet = JOptionPane.showInputDialog(null,
                                                            "Entre le projet\nEntre 0 pour terminer",
                                                            "Liste de projets",
                                                            JOptionPane.PLAIN_MESSAGE);
                                                    listedeProjets[a] = projet;
                                                    a++;
                                                } while (projet != "0");
                                                a = 0;
                                                unePersonne = new Scientifique(matricule, nom, prenom, sexe,
                                                        dateNaissance,
                                                        vivantOuNon,
                                                        inbrEmploye, secteur, nbrprojets, listedeProjets);
                                                listGestionnaire.modifier(nomAModifier, unePersonne);

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 1:
                                    // ----------------------------------------------------Modification de
                                    // Gestionnaire à partir de la position
                                    choiceGestionnaire = JOptionPane.showOptionDialog(null, "Choix de gestionaire",
                                            "Gestionnaire",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixGestionnaire,
                                            choixGestionnaire[0]);
                                    switch (choiceGestionnaire) {

                                        case 0:
                                            // ----------------------------------------------------Modification
                                            // d'administrateurs à partir de la position de la personne
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                              
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                                inbrEmploye = Integer.parseInt(nbrEmploye);
                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                projet = JOptionPane.showInputDialog("quel est  le projet");
                                                titre = JOptionPane.showInputDialog("quel est  le titre");
                                                unePersonne = new Administrateur(matricule, nom, prenom, sexe,
                                                        dateNaissance,
                                                        vivantOuNon,
                                                        inbrEmploye, secteur, projet, titre);
                                                listGestionnaire.modifier(iPosition, unePersonne);

                                                System.out.println("Modification  éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;

                                        case 1:
                                            // ----------------------------------------------------Modification de
                                            // scientifiques à partir de la position de la personne
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                             
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }
                                                nbrEmploye = JOptionPane.showInputDialog("Entre le nombre d'employé");
                                                inbrEmploye = Integer.parseInt(nbrEmploye);
                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                projet = JOptionPane.showInputDialog("quel est  le nombre de projet");
                                                nbrprojets = Integer.parseInt(projet);
                                                do {
                                                    projet = JOptionPane.showInputDialog(null,
                                                            "Entre le projet\nEntre 0 pour terminer",
                                                            "Liste de projets",
                                                            JOptionPane.PLAIN_MESSAGE);
                                                    listedeProjets[a] = projet;
                                                    a++;
                                                } while (projet != "0");
                                                a = 0;
                                                unePersonne = new Scientifique(matricule, nom, prenom, sexe,
                                                        dateNaissance,
                                                        vivantOuNon,
                                                        inbrEmploye, secteur, nbrprojets, listedeProjets);
                                                listGestionnaire.modifier(iPosition, unePersonne);

                                                System.out.println("Modification   éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                default:
                                    break;
                            }
                            break;
                        case 2:
                            // ---------------------------------------------------------Modification
                            // d'employé de maintenance
                            choiceModification = JOptionPane.showOptionDialog(null, "Modifie avec le | la ",
                                    "Modification",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixModification,
                                    choixModification[0]);
                            switch (choiceModification) {
                                case 0:
                                    // ---------------------------------------------------------Modification
                                    // d'employé de maintenance à partir du nom
                                    choiceEmployeMaintenance = JOptionPane.showOptionDialog(null,
                                            "Choix de employé de maintenance",
                                            "Employé de maintenance",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                            choixEmployeMaintenance,
                                            choixEmployeMaintenance[0]);
                                    switch (choiceEmployeMaintenance) {
                                        // ----------------------------------------------------Modification de
                                        // ingénieure à partir du nom de la personne
                                        case 0:
                                            try {

                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                                

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                ijour = Integer.parseInt(jour);
                                                imois = Integer.parseInt(mois);
                                                iannee = Integer.parseInt(annee);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }

                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                lieuDeTravail = JOptionPane
                                                        .showInputDialog("quel est  le lieu de travail?");
                                                specialite = JOptionPane.showInputDialog("quel est  la spécialité?");
                                                jour = JOptionPane.showInputDialog("Entre le jour de fin d'étude");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année de fin d'étude");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois de fin d'étude");
                                                imois = Integer.parseInt(mois);
                                                dateFinEtude = new ClDate(iannee, imois, ijour);
                                                niveauEtude = JOptionPane
                                                        .showInputDialog("quel est  le niveau d'étude?");
                                                iniveauEtude = Integer.parseInt(niveauEtude);

                                                unePersonne = new Ingenieur(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon, secteur, lieuDeTravail,
                                                        specialite, dateFinEtude, iniveauEtude);
                                                listEmployeMaintenance.modifier(nomAModifier, unePersonne);

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        case 1:
                                            // ----------------------------------------------------Modification
                                            // d'ouvrier à partir du nom de la personne
                                            try {
                                                nomAModifier = JOptionPane.showInputDialog(
                                                        "Quel est le nom de la personne que tu veux modifier?");
                                                

                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }

                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                lieuDeTravail = JOptionPane
                                                        .showInputDialog("quel est  le lieu de travail?");
                                                heureDebut = JOptionPane
                                                        .showInputDialog(
                                                                "quel est  l'heure de début du quart de travail?");
                                                heureFin = JOptionPane
                                                        .showInputDialog(
                                                                "quel est  l'heure de fin du quart de travail?");
                                                iheureDebut = Integer.parseInt(heureDebut);
                                                iheureFin = Integer.parseInt(heureFin);
                                                quartTravail[0] = iheureDebut;
                                                quartTravail[1] = iheureFin;
                                                genreTravail = JOptionPane
                                                        .showInputDialog("quel est  le genre de travail?");
                                                secteur = JOptionPane
                                                        .showInputDialog("quel est  le nombre de  secteur?");
                                                nbrSecteur = Integer.parseInt(secteur);

                                                unePersonne = new Ouvrier(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon, secteur, lieuDeTravail, quartTravail, genreTravail,
                                                        nbrSecteur);
                                                listEmployeMaintenance.modifier(nomAModifier, unePersonne);
                                               

                                                System.out.println(
                                                        "Modification de " + nomAModifier + " éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } 
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 1:
                                    // ------------------------------------------------Modification d'employé de
                                    // maintenance à partir de la position
                                    choiceEmployeMaintenance = JOptionPane.showOptionDialog(null,
                                            "Choix de employé de maintenance",
                                            "Employé de maintenance",
                                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                            choixEmployeMaintenance,
                                            choixEmployeMaintenance[0]);
                                    switch (choiceEmployeMaintenance) {
                                        // ----------------------------------------------------Modification de
                                        // ingénieure à partir de la position de la personne
                                        case 0:
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                               
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }

                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                lieuDeTravail = JOptionPane
                                                        .showInputDialog("quel est  le lieu de travail?");
                                                specialite = JOptionPane.showInputDialog("quel est  la spécialité?");
                                                jour = JOptionPane.showInputDialog("Entre le jour de fin d'étude");
                                                annee = JOptionPane.showInputDialog("Entre l'année de fin d'étude");
                                                mois = JOptionPane.showInputDialog("Entre le mois de fin d'étude");
                                                ijour = Integer.parseInt(jour);
                                                imois = Integer.parseInt(mois);
                                                iannee = Integer.parseInt(annee);
                                                dateFinEtude = new ClDate(iannee, imois, ijour);
                                                niveauEtude = JOptionPane
                                                        .showInputDialog("quel est  le niveau d'étude?");
                                                iniveauEtude = Integer.parseInt(niveauEtude);

                                                unePersonne = new Ingenieur(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon, secteur, lieuDeTravail,
                                                        specialite, dateFinEtude, iniveauEtude);
                                                listEmployeMaintenance.modifier(iPosition, unePersonne);

                                                System.out.println("Modification   éffectué avec succè");

                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        case 1:
                                            // ----------------------------------------------------Modification
                                            // d'ouvrier à partir de la position de la personne
                                            try {
                                                position = JOptionPane
                                                        .showInputDialog("Entre la position de la personne à modifier");
                                                iPosition = Integer.parseInt(position);
                                              
                                                do {
                                                    matricule = JOptionPane
                                                            .showInputDialog(
                                                                    "Entre le matricule de la nouvelle personne");
                                                    for (int i = 0; i < listForceSecurite.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listForceSecurite.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listGestionnaire.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listGestionnaire.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    for (int i = 0; i < listEmployeMaintenance.getListPersonnes()
                                                            .size(); i++) {
                                                        if (matricule.equals(
                                                                listEmployeMaintenance.getListPersonnes().get(i)
                                                                        .getMatricule())) {
                                                            trouve = true;
                                                            System.out.println("Ce matricule existe déjà");
                                                        }
                                                    }
                                                    if (trouve) {
                                                        repet = true;
                                                        trouve = false;
                                                    } else {
                                                        repet = false;
                                                    }

                                                    Matcher matcher = pattern.matcher(matricule);
                                                    boolean found = matcher.find();

                                                    if (found) {

                                                    } else {
                                                        repet = true;
                                                        System.out.println(
                                                                "Ce matricule est incorrect, veuillez  l'écrire sous la forme: A50 ");
                                                    }
                                                } while (repet == true);
                                                trouve = false;
                                                nom = JOptionPane.showInputDialog("Entre le nom");
                                                prenom = JOptionPane.showInputDialog("Entre le prenom");
                                                sexe = JOptionPane.showInputDialog("Entre le sexe");
                                                jour = JOptionPane.showInputDialog("entre le jour de naissance");
                                                ijour = Integer.parseInt(jour);
                                                annee = JOptionPane.showInputDialog("Entre l'année");
                                                iannee = Integer.parseInt(annee);
                                                mois = JOptionPane.showInputDialog("Entre le mois");
                                                imois = Integer.parseInt(mois);
                                                dateNaissance = new ClDate(iannee, imois, ijour);
                                                vie = JOptionPane.showInputDialog("vie t'il encore\n1. Oui\n2. Non");
                                                if (vie.equals("1")) {
                                                    vivantOuNon = true;
                                                } else if (vie.equals("2")) {
                                                    vivantOuNon = false;
                                                }

                                                secteur = JOptionPane.showInputDialog("quel est  le secteur?");
                                                lieuDeTravail = JOptionPane
                                                        .showInputDialog("quel est  le lieu de travail?");
                                                heureDebut = JOptionPane
                                                        .showInputDialog(
                                                                "quel est  l'heure de début du quart de travail?");
                                                heureFin = JOptionPane
                                                        .showInputDialog(
                                                                "quel est  l'heure de fin du quart de travail?");
                                                iheureDebut = Integer.parseInt(heureDebut);
                                                iheureFin = Integer.parseInt(heureFin);
                                                quartTravail[0] = iheureDebut;
                                                quartTravail[1] = iheureFin;
                                                genreTravail = JOptionPane
                                                        .showInputDialog("quel est  le genre de travail?");
                                                secteur = JOptionPane
                                                        .showInputDialog("quel est  le nombre de  secteur?");
                                                nbrSecteur = Integer.parseInt(secteur);

                                                unePersonne = new Ouvrier(matricule, nom, prenom, sexe, dateNaissance,
                                                        vivantOuNon, secteur, lieuDeTravail, quartTravail, genreTravail,
                                                        nbrSecteur);
                                                listEmployeMaintenance.modifier(iPosition, unePersonne);

                                                System.out.println("Modification  éffectué avec succè");
                                            } catch (NumberFormatException e) {
                                                System.out.println(
                                                        " Erreur dans la conversion  " + e.getLocalizedMessage());
                                            } catch (IndexOutOfBoundsException exc) {
                                                System.out.println("dépassement invalide = " + exc.getMessage());
                                            } catch (Exception exc) {
                                                System.out.println(" Erreur Le matricule ne doit pas etre null ");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                default:
                                    break;
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                // ------------------------------------------------------Option de recherche
                case 3:
                    try {
                        choicePersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixPersonne,
                                choixPersonne[0]);
                        switch (choicePersonne) {
                            case 0:
                                // ---------------------------------------Utilisation de la méthode recherche de
                                // la classe TestPersonnes avec l'instrucion enum
                                nom = JOptionPane.showInputDialog("Entre le nom de la personne que vous chercher");
                                TestPersonnes forceDeSecu = new TestPersonnes(Recherche.FORCE_DE_SECURITE, nom);
                                forceDeSecu.rechercheNom();
                                break;
                            case 1:
                                // ---------------------------------------Utilisation de la méthode recherche de
                                // la classe TestPersonnes avec l'instrucion enum
                                nom = JOptionPane.showInputDialog("Entre le nom de la personne que vous chercher");
                                TestPersonnes gestio = new TestPersonnes(Recherche.GESTIONNAIRE, nom);
                                gestio.rechercheNom();

                                break;
                            case 2:
                                // ---------------------------------------Utilisation de la méthode recherche de
                                // la classe TestPersonnes avec l'instrucion enum
                                nom = JOptionPane.showInputDialog("Entre le nom de la personne que vous chercher");
                                TestPersonnes employe = new TestPersonnes(Recherche.EMPLOYE_DE_MAINTENANCE, nom);
                                employe.rechercheNom();

                                break;

                            default:
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                " Erreur dans la conversion  " + e.getLocalizedMessage());
                    } catch (Exception exc) {
                        System.out.println(" Erreur Le matricule ne doit pas etre null ");
                    }
                    break;
                // -------------------------------------------------------------option
                // Afficher
                case 4:
                    choiceTousPersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTousPersonne,
                            choixTousPersonne[0]);
                    switch (choiceTousPersonne) {
                        case 0:
                            // ----------------------------------------------------------Affiche les
                            // Forces de sécurités
                            System.out.println(".............................................Force de sécurité");
                            Collections.sort(listForceSecurite.getListPersonnes());
                            listForceSecurite.Afficher();
                            break;
                        case 1:
                            // ----------------------------------------------------------Affiche les
                            // Gestionnaires
                            System.out.println(".............................................Gestionnaire");
                            Collections.sort(listGestionnaire.getListPersonnes());
                            listGestionnaire.Afficher();

                            break;
                        case 2:
                            // ----------------------------------------------------------Affiche les
                            // employés de sécurités
                            System.out.println(".............................................Employé de maintenance");
                            Collections.sort(listEmployeMaintenance.getListPersonnes());
                            listEmployeMaintenance.Afficher();
                            break;
                        case 3:
                            // ----------------------------------------------------------Affiche toutes
                            // les personnes
                            Collections.sort(listForceSecurite.getListPersonnes());
                            Collections.sort(listGestionnaire.getListPersonnes());
                            Collections.sort(listEmployeMaintenance.getListPersonnes());
                            System.out.println(".............................................Force de sécurité");
                            listForceSecurite.Afficher();
                            System.out.println(".............................................Gestionnaire");
                            listGestionnaire.Afficher();
                            System.out.println(".............................................Employé de maintenance");
                            listEmployeMaintenance.Afficher();
                            break;

                        default:
                            break;
                    }

                    break;
                // ----------------------------Option affiche les personnes du plus agé au moins
                // agé
                case 5:
                    choiceTousPersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTousPersonne,
                            choixTousPersonne[0]);
                    switch (choiceTousPersonne) {
                        case 0:
                            System.out.println(".............................................Force de sécurité");
                            listForceSecurite.getListPersonnes().sort(Collections.reverseOrder());
                            System.out.println("Trie éffectuer avec succè");
                            break;
                        case 1:
                            System.out.println(".............................................Gestionnaire");
                            listGestionnaire.getListPersonnes().sort(Collections.reverseOrder());
                            System.out.println("Trie éffectuer avec succè");

                            break;
                        case 2:
                            System.out.println(".............................................Employé de maintenance");
                            listEmployeMaintenance.getListPersonnes().sort(Collections.reverseOrder());
                            System.out.println("Trie éffectuer avec succè");
                            break;
                        case 3:
                            listForceSecurite.getListPersonnes().sort(Collections.reverseOrder());
                            listGestionnaire.getListPersonnes().sort(Collections.reverseOrder());
                            listEmployeMaintenance.getListPersonnes().sort(Collections.reverseOrder());
                            System.out.println(".............................................Force de sécurité");

                            System.out.println(".............................................Gestionnaire");

                            System.out.println(".............................................Employé de maintenance");
                            System.out.println("Trie éffectuer avec succè");
                            break;

                        default:
                            break;
                    }
                    break;
                // ----------------------------------------------Option affiche les personnes
                // sans un ordre particulier
                case 6:
                    choiceTousPersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTousPersonne,
                            choixTousPersonne[0]);
                    switch (choiceTousPersonne) {
                        case 0:
                            System.out.println(".............................................Force de sécurité");
                            Collections.shuffle(listForceSecurite.getListPersonnes());
                            System.out.println("Trie éffectuer avec succè");
                            break;
                        case 1:
                            System.out.println(".............................................Gestionnaire");
                            Collections.shuffle(listGestionnaire.getListPersonnes());
                            System.out.println("Trie éffectuer avec succè");

                            break;
                        case 2:
                            System.out.println(".............................................Employé de maintenance");
                            Collections.shuffle(listEmployeMaintenance.getListPersonnes());
                            System.out.println("Trie éffectuer avec succè");
                            break;
                        case 3:
                            Collections.shuffle(listForceSecurite.getListPersonnes());
                            Collections.shuffle(listGestionnaire.getListPersonnes());
                            Collections.shuffle(listEmployeMaintenance.getListPersonnes());
                            System.out.println(".............................................Force de sécurité");

                            System.out.println(".............................................Gestionnaire");

                            System.out.println(".............................................Employé de maintenance");
                            System.out.println("Trie éffectuer avec succè");
                            break;

                        default:
                            break;
                    }
                    break;
                // --------------------------------------Options de Tris
                case 7:

                    choiceTousPersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTousPersonne,
                            choixTousPersonne[0]);
                    switch (choiceTousPersonne) {
                        case 0:
                            // ------------------------------Trie de forces de sécurités
                            choiceTrieForceSecurite = JOptionPane.showOptionDialog(null, "Choix du trie",
                                    "Trie force de sécurité",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTrieForceSecurite,
                                    choixTrieForceSecurite[0]);
                            switch (choiceTrieForceSecurite) {
                                case 0:
                                    // --------------------------------------Trie avec le prénom
                                    System.out
                                            .println(".............................................Force de sécurité");
                                    Collections.sort(listForceSecurite.getListPersonnes(), new Armee());
                                    System.out.println("Trie avec prénom éffectuée avec succè");
                                    break;
                                case 1:
                                    // -------------------------------------Trie avec le sexe
                                    System.out
                                            .println(".............................................Force de sécurité");
                                    Collections.sort(listForceSecurite.getListPersonnes(), new ComapareSexe());
                                    System.out.println("Trie avec sexe éffectuée avec succè");
                                    break;

                                default:
                                    break;
                            }
                            break;
                        case 1:
                            // ------------------------------Trie de gestionnaires
                            choiceTrieGestionnaire = JOptionPane.showOptionDialog(null, "Choix du trie",
                                    "Trie gestionnaire",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTrieGestionnaire,
                                    choixTrieGestionnaire[0]);
                            switch (choiceTrieGestionnaire) {
                                case 0:
                                    // --------------------------------------Trie avec le prénom
                                    System.out.println(".............................................Gestionnaire");
                                    Collections.sort(listGestionnaire.getListPersonnes(), new Scientifique());
                                    System.out.println("Trie avec prénom éffectuée avec succè");
                                    break;
                                case 1:
                                    // -------------------------------------Trie avec le sexe
                                    System.out.println(".............................................Gestionnaire");
                                    Collections.sort(listGestionnaire.getListPersonnes(), new ComapareSexe());
                                    System.out.println("Trie avec sexe éffectuée avec succè");
                                    break;

                                default:
                                    break;
                            }

                            break;
                        case 2:
                            // ------------------------------Trie de'employés de maintance
                            choiceTrieEmploye = JOptionPane.showOptionDialog(null, "Choix du trie",
                                    "Trie employé de maintenance",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTrieEmploye,
                                    choixTrieEmploye[0]);
                            switch (choiceTrieEmploye) {
                                case 0:
                                    // --------------------------------------Trie avec le prénom
                                    System.out.println(
                                            ".............................................Employé de maintenance");
                                    Collections.sort(listEmployeMaintenance.getListPersonnes(), new Ingenieur());
                                    System.out.println("Trie avec prénom éffectuée avec succè");
                                    break;
                                case 1:
                                    // -------------------------------------Trie avec le sexe
                                    System.out.println(
                                            ".............................................Employé de maintenance");
                                    Collections.sort(listEmployeMaintenance.getListPersonnes(), new ComapareSexe());
                                    System.out.println("Trie avec sexe éffectuée avec succè");
                                    break;

                                default:
                                    break;
                            }
                            break;
                        case 3:
                            // ------------------------------Trie de toutes les personnes
                            choiceTriePersonne = JOptionPane.showOptionDialog(null, "Choix du trie",
                                    "Trie toutes les personnes",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTriePersonne,
                                    choixTriePersonne[0]);
                            switch (choiceTriePersonne) {
                                case 0:
                                    // --------------------------------------Trie avec le prénom
                                    System.out
                                            .println(".............................................Force de sécurité");
                                    Collections.sort(listForceSecurite.getListPersonnes(), new Armee());

                                    System.out.println(".............................................Gestionnaire");
                                    Collections.sort(listGestionnaire.getListPersonnes(), new Scientifique());
                                    System.out.println(
                                            ".............................................Employé de maintenance");
                                    Collections.sort(listEmployeMaintenance.getListPersonnes(), new Ingenieur());

                                    System.out.println("Trie avec prénom éffectuée avec succè");
                                    break;
                                case 1:
                                    // -------------------------------------Trie avec le sexe
                                    System.out
                                            .println(".............................................Force de sécurité");
                                    Collections.sort(listForceSecurite.getListPersonnes(), new ComapareSexe());

                                    System.out.println(".............................................Gestionnaire");
                                    Collections.sort(listGestionnaire.getListPersonnes(), new ComapareSexe());

                                    System.out.println(
                                            ".............................................Employé de maintenance");
                                    Collections.sort(listEmployeMaintenance.getListPersonnes(), new ComapareSexe());
                                    System.out.println("Trie avec prénom éffectuée avec succè");
                                    break;

                                default:
                                    break;
                            }
                            break;
                        default:

                            break;
                    }
                    break;
                // ----------------------------------------------------------Option Visualise
                case 8:
                    choiceTousPersonne = JOptionPane.showOptionDialog(null, "Choix de personne", "Personnes",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choixTousPersonne,
                            choixTousPersonne[0]);
                    switch (choiceTousPersonne) {
                        case 0:
                            // ----------------------------------------------------------Visualise les
                            // Forces de sécurités
                            System.out.println(".............................................Force de sécurité");

                            listForceSecurite.Afficher();
                            break;
                        case 1:
                            // ----------------------------------------------------------Visualise les
                            // Gestionnaires
                            System.out.println(".............................................Gestionnaire");

                            listGestionnaire.Afficher();

                            break;
                        case 2:
                            // ----------------------------------------------------------Visualise les
                            // employés de sécurités
                            System.out.println(".............................................Employé de maintenance");

                            listEmployeMaintenance.Afficher();
                            break;
                        case 3:
                            // ----------------------------------------------------------Visualise toutes
                            // les personnes

                            System.out.println(".............................................Force de sécurité");
                            listForceSecurite.Afficher();
                            System.out.println(".............................................Gestionnaire");
                            listGestionnaire.Afficher();
                            System.out.println(".............................................Employé de maintenance");
                            listEmployeMaintenance.Afficher();
                            break;

                        default:
                            break;
                    }

                    break;
                // ----------------------------------------------------------------Option
                // sauvegarder en fichier texte
                case 9:

                    JOptionPane.showMessageDialog(null,
                            "Attention si vous cliquer sur annuler lors de du choix de l'emplacement,\n un fichier par défaut est créé dans le dossier PojetFinal1",
                            "Attention!", JOptionPane.WARNING_MESSAGE);

                    // ---------------------------------------------------------Choix d'emplacements
                    // des fichiers

                    choixFichierForce
                            .setDialogTitle("Sélectionne le dossier de sauvegarde du fichier force de sécurité");
                    choixFichierGestion.setDialogTitle("Sélectionne le dossier de sauvegarde du fichier gestionnaire");
                    choixFichierEmploye
                            .setDialogTitle("Sélectionne le dossier de sauvegarde du fichier Employé de maintenance");

                    selectionForce = choixFichier.showSaveDialog(null);
                    selectionGestion = choixFichier.showSaveDialog(null);
                    selectionEmploye = choixFichier.showSaveDialog(null);

                    if (selectionForce == JFileChooser.APPROVE_OPTION) {
                        forceSecu = choixFichier.getSelectedFile();
                        System.out.println("Le fichier a été enregistrer sous :" + forceSecu.getAbsolutePath());
                    }

                    if (selectionGestion == JFileChooser.APPROVE_OPTION) {
                        gestion = choixFichier.getSelectedFile();
                        System.out.println("Le fichier a été enregistrer sous :" + gestion.getAbsolutePath());
                    }

                    if (selectionEmploye == JFileChooser.APPROVE_OPTION) {
                        employes = choixFichier.getSelectedFile();
                        System.out.println("Le fichier a été enregistrer sous :" + employes.getAbsolutePath());
                    }
                    try {
                        sortieforceSecu = new FileWriter(forceSecu + ".txt");

                    } catch (IOException e) {
                        System.out.println("Msg : " + e.getMessage());
                        System.out.println("Ne peut créer un canal de sortie pour: " + sortieforceSecu);
                    }
                    try {
                        sortieGestion = new FileWriter(gestion + ".txt");

                    } catch (IOException e) {
                        System.out.println("Msg : " + e.getMessage());
                        System.out.println("Ne peut créer un canal de sortie pour: " + sortieGestion);
                    }
                    try {

                        sortieEmploye = new FileWriter(employes + ".txt");

                    } catch (IOException e) {
                        System.out.println("Msg : " + e.getMessage());
                        System.out.println("Ne peut créer un canal de sortie pour: " + sortieEmploye);
                    }

                    // ---------------------------------------------------------------------------------------Ecrire
                    // dans le fichier

                    try {

                        sortieforceSecu
                                .write("Le fichier texte <<Force de Securité.txt>> en date du " + new Date() + "\r\n");
                        sortieGestion.write("Le fichier texte <<Gestion.txt>> en date du " + new Date() + "\r\n");
                        sortieEmploye.write(
                                "Le fichier texte <<Employe de maintenance.txt>> en date du " + new Date() + "\r\n");

                        sortieforceSecu.write("\n" + listForceSecurite.getListPersonnes());
                        sortieGestion.write("\n" + listGestionnaire.getListPersonnes());
                        sortieEmploye.write("\n" + listEmployeMaintenance.getListPersonnes());

                        sortieforceSecu.close();
                        sortieGestion.close();
                        sortieEmploye.close();
                    } catch (IOException e) {
                        System.out.println("\nMsg: " + e.getMessage());
                        System.out.println("Erreur lors d'une opération d'entrée/Sortie");
                        try {
                            sortieforceSecu.close();
                            sortieGestion.close();
                            sortieEmploye.close();
                        } catch (IOException eclose) {
                            System.out.println("Msg: " + eclose.getMessage());
                            System.out.println("Erreur lors de la fermeture des fichiers");
                        }
                    }
                    break;
                // -------------------------------------------------options affichage des
                // fichiers texte
                case 10:
                    System.out.println(
                            "++++++++++++++++++++++++Le fichier texte <<Force de Securité.txt>> a été créé en date du "
                                    + new Date() + "\r\n");

                    System.out.println("\n" + listForceSecurite.getListPersonnes());

                    System.out.println(
                            "\n\n+++++++++++++++++++++++Le fichier texte <<Gestion.txt>> a été créé en date du "
                                    + new Date() + "\r\n");

                    System.out.println("\n" + listGestionnaire.getListPersonnes());

                    System.out.println(
                            "\n\n++++++++++++++++++++++++Le fichier texte <<Employe de maintenance.txt>> a été créé en date du "
                                    + new Date() + "\r\n");

                    System.out.println("\n" + listEmployeMaintenance.getListPersonnes());
                    break;
                default:
                    break;
            }
        } while (choice != 11);

        // -------------------------------------------------------------------Fin des
        // options

        // ----------------------------------------------------------------Sauvegarde
        // des données
        try {

            ftmBinaireSortieBunker = new FileOutputStream(fichierSauvegarde + ".ser");
            sortie = new ObjectOutputStream(ftmBinaireSortieBunker);

        } catch (IOException e) {
            System.out.println("Msg: " + e.getMessage());
            System.out.println("Ne peut créer le canal de sortie pour: " + (fichierSauvegarde + ".ser"));
            System.exit(0);
        }

        try {
            listPersonne.clear(2);
            listPersonne.add(listForceSecurite.getListPersonnes());
            listPersonne.add(listEmployeMaintenance.getListPersonnes());
            listPersonne.add(listGestionnaire.getListPersonnes());

            sortie.writeObject(listPersonne.getListPersonnes());
            sortie.close();
            System.out.println("\n\nSauvegarde des données... \nDonnées sauvegardées\nMerci et à bientôt");
        } catch (IOException e) {
            System.out
                    .println("Erreur dans les opérations du canal de sortie lors de l'écriture: " + e.getMessage());
            System.exit(0);
        }
        // ---------------------------------------------------------------------Fin du
        // programme
        System.exit(0);
    }

}
