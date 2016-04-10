package model;

import java.util.ArrayList;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Jordan
 */
public class Personnage implements Sujet {
    
    private ArrayList<Observateur> observateurs;
    
    ObservableList<Objet> inventaireObservable = FXCollections.observableArrayList();
    
    ObservableList<Objet> equipementObservable = FXCollections.observableArrayList();
    
    private final ListProperty<Objet> inventaire = new SimpleListProperty<>(inventaireObservable);
        public ObservableList<Objet> getInventaire() {return inventaire.get();}
        public void setInventaire(ObservableList<Objet> value) {inventaire.set(value);}
        public ListProperty<Objet> inventaireProperty() {return inventaire;}
        
    private final ListProperty<Objet> equipement = new SimpleListProperty<>(equipementObservable);
        public ObservableList<Objet> getEquipement() {return equipement.get();}
        public void setEquipement(ObservableList<Objet> value) {equipement.set(value);}
        public ListProperty<Objet> equipementProperty() {return equipement;}
        
    private final ObjectProperty<Integer> pieces = new SimpleObjectProperty<>();
        public int getPieces() {return pieces.get();}
        public void setPieces(int value) {pieces.set(value);}
        public ObjectProperty piecesProperty() {return pieces;}

        
    private Statistiques statistiques;
    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }
    public Statistiques getStatistiques() {
        return statistiques;
    }
        
        
        

     public Personnage(String nom, int vie, int mana, int attaque, int defense, int vitesse, int intelligence, int pieces) {
        this.statistiques = new Statistiques(nom, vie, mana, attaque, defense, vitesse, intelligence);
        this.pieces.set(pieces);
        
        observateurs = new ArrayList<Observateur>();
    }        

     
     
    //Ajoute un nombre indéfini d'objets dans l'inventaire.
    public void addObjetsInventaire(Objet... args){
        inventaireObservable.addAll(args);
        notifier();
    }
    
    //Supprime un objet de l'inventaire.
    public void removeObjetInventaire(Objet objet)
    {
        inventaireObservable.remove(objet);
        notifier();
    }
       
    //Ajoute un nombre indéfini d'objets dans l'équipement.
      public void addObjetsEquipement(Objet... args){
        equipementObservable.addAll(args);
    }
         
    //Supprime un objet de l'équipement
    public void removeObjetEquipement(Objet objet)
    {
        equipementObservable.remove(objet);
    }
    
    //Ajoute un objet dans equipement et change les statistiques du personnage en fonction des statistiques de l'objet
    public void equiper(Objet objet)
    {
        addObjetsEquipement(objet);
        removeObjetInventaire(objet);
        this.getStatistiques().setVie(this.getStatistiques().getVie() + objet.getStatistiques().getVie());
        this.getStatistiques().setAttaque(this.getStatistiques().getAttaque() + objet.getStatistiques().getAttaque());
        this.getStatistiques().setDefense(this.getStatistiques().getDefense() + objet.getStatistiques().getDefense());
        this.getStatistiques().setIntelligence(this.getStatistiques().getIntelligence() + objet.getStatistiques().getIntelligence());
        this.getStatistiques().setMana(this.getStatistiques().getMana() + objet.getStatistiques().getMana());
        this.getStatistiques().setVitesse(this.getStatistiques().getVitesse() + objet.getStatistiques().getVitesse());
    }
    
    //Supprime un objet dans equipement et change les statistiques du personnage en fonction des statistiques de l'objet
    public void desequiper(Objet objet)
    {
        addObjetsInventaire(objet);
        removeObjetEquipement(objet);
        this.getStatistiques().setVie(this.getStatistiques().getVie() - objet.getStatistiques().getVie());
        this.getStatistiques().setAttaque(this.getStatistiques().getAttaque() - objet.getStatistiques().getAttaque());
        this.getStatistiques().setDefense(this.getStatistiques().getDefense() - objet.getStatistiques().getDefense());
        this.getStatistiques().setIntelligence(this.getStatistiques().getIntelligence() - objet.getStatistiques().getIntelligence());
        this.getStatistiques().setMana(this.getStatistiques().getMana() - objet.getStatistiques().getMana());
        this.getStatistiques().setVitesse(this.getStatistiques().getVitesse() - objet.getStatistiques().getVitesse());

    }
     
    //Retourne vrai si l'équipement a déjà un objet du même type, faux sinon.
    public boolean aUnObjetDeMemeType(Objet objet)
    {
        for(Objet o : equipement)
        {
            if(o.getType().equals(objet.getType()))
            {
                return true;
            } 
        }
        return false;
    }
     
    //Supprime un objet de l'inventaire.
    public void jeter(Objet objet)
    {
        removeObjetInventaire(objet);
    }
     
    //Le personnage gagne des sous égal au prix de l'objet, ce dernier est jeté de l'inventaire.
    public void vendre(Objet objet)
    {
        setPieces(this.getPieces() + objet.getPrix());
        this.jeter(objet);
    }
     
     
     
     
     
     
    public void deteriorer(Objet objet)
    {  
        if(objet.getEtatObjet() instanceof ObjetEnBonEtat)
        {
            
            objet.setEtatObjet(new ObjetAbime());  
            objet.setStatsProperty(objet.toString());
            
        }
        else if(objet.getEtatObjet() instanceof ObjetAbime)
        {
            objet.setEtatObjet(new ObjetCasse());
            objet.setStatsProperty(objet.toString());
        }  
    }
     
    public void reparer(Objet objet)
    {
        if(objet.getEtatObjet() instanceof ObjetCasse)
        {
            objet.setEtatObjet(new ObjetAbime());   
            this.setPieces(getPieces() - objet.getCoutReparation());
            objet.setStatsProperty(objet.toString());
        }
        else if(objet.getEtatObjet() instanceof ObjetAbime)
        {
            objet.setEtatObjet(new ObjetEnBonEtat());
            this.setPieces(getPieces() - objet.getCoutReparation());
            objet.setStatsProperty(objet.toString());
        }
    }
        
        
        
        
    @Override
    public void attacher(Observateur nouvelObservateur)
    {
        observateurs.add(nouvelObservateur);
    }

    @Override
    public void detacher(Observateur observateurSupprime)
    {
     int observateurIndex = observateurs.indexOf(observateurSupprime);   
     observateurs.remove(observateurIndex);
    }
    
    
     //Notifie tous les observateurs lors d'un changement d'état.
    @Override
    public void notifier()
    {
        
        for(int i=0; i<observateurs.size();i++)
        {
            observateurs.get(i).actualiser();
           
        }
    }
   
    
}
