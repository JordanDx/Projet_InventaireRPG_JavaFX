package model;

import java.net.URL;
import java.util.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;


/**
 *
 * @author Jordan
 */
public final class Objet {
    
    
    private String type;

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    private Image image;   
    public Image getImage() {
        return image;
    }  
    public void setImage(Image image) {
        this.image = image;
    }
    
    
   
      
      
    private EtatObjet etatObjet;
    public void setEtatObjet(EtatObjet etatObjet) {
        this.etatObjet = etatObjet;
    }
    public EtatObjet getEtatObjet() {
        return etatObjet;
    }
    
     public int getPrix()
    {
        return this.getEtatObjet().getPrix();
    }
     
     

    public int getCoutReparation() {
        return this.getEtatObjet().getCoutReparation();
    }





    private Statistiques statistiques;
    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }
    public Statistiques getStatistiques() {
        return statistiques;
    }


    private StringProperty statsProperty = new SimpleStringProperty();
        public String getStatsProperty() { return statsProperty.get(); }
        public void setStatsProperty(String value) {statsProperty.set(value);}
        public StringProperty statsProperty() { return statsProperty; }
   


    public Objet(String type, String urlImage, String nom, int vie, int mana, int attaque, int defense, int vitesse, int intelligence, int prix, int coutReparation) {
        this.setType(type);
        this.image = new Image(urlImage);
        this.statistiques = new Statistiques(nom, vie, mana, attaque, defense, vitesse, intelligence);

        this.etatObjet = new ObjetAbime();    
        this.etatObjet.setPrix(prix);
        this.etatObjet.setCoutReparation(coutReparation);
        

        this.statsProperty.set(this.toString());

    }
 
   
    @Override
    public String toString()
    {
        String text;
        
        text = this.getStatistiques().toString();       
        text += "Prix : " + this.getPrix() + "\n";   
        text += "Coût réparation : " + this.getCoutReparation() + "\n";
   
        return text;
    }
    
    
    
    
}
