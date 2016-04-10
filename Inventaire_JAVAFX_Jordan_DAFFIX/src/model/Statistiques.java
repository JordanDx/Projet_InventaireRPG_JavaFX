/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jordan
 */
public class Statistiques {

    private final StringProperty nom = new SimpleStringProperty("");
        public String getNom() {return nom.get();}
        public void setNom(String value) {nom.set(value);}
        public StringProperty nomProperty() {return nom;}
            
    private final ObjectProperty<Integer> vie = new SimpleObjectProperty<>();
        public int getVie() {return vie.get();}
        public void setVie(int value) {vie.set(value);}
        public ObjectProperty vieProperty() {return vie;}

    private final ObjectProperty<Integer> mana = new SimpleObjectProperty<>();
        public int getMana() {return mana.get();}
        public void setMana(int value) {mana.set(value);}
        public ObjectProperty manaProperty() {return mana;}
    
    private final ObjectProperty<Integer> attaque = new SimpleObjectProperty<>();
        public int getAttaque() {return attaque.get();}
        public void setAttaque(int value) {attaque.set(value);}
        public ObjectProperty attaqueProperty() {return attaque;}

    private final ObjectProperty<Integer> defense = new SimpleObjectProperty<>();
        public int getDefense() {return defense.get();}
        public void setDefense(int value) {defense.set(value);}
        public ObjectProperty defenseProperty() {return defense;}

    private final ObjectProperty<Integer> vitesse = new SimpleObjectProperty<>();
        public int getVitesse() {return vitesse.get();}
        public void setVitesse(int value) {vitesse.set(value);}
        public ObjectProperty vitesseProperty() {return vitesse;}
    
    private final ObjectProperty<Integer> intelligence = new SimpleObjectProperty<>();
        public int getIntelligence() {return intelligence.get();}
        public void setIntelligence(int value) {intelligence.set(value);}
        public ObjectProperty intelligenceProperty() {return intelligence;}
    
    public Statistiques(String nom, int vie, int mana, int attaque, int defense, int vitesse, int intelligence) {
        this.nom.set(nom);
        this.vie.set(vie);
        this.mana.set(mana);
        this.attaque.set(attaque);
        this.defense.set(defense);
        this.vitesse.set(vitesse);
        this.intelligence.set(intelligence);
    }
    
    @Override
    public String toString()
    {
        String text;
        
        text = getNom().toUpperCase() + "\n";
        
        if(getVie() != 0)
            text += "Vie : " + getVie() + "\n";
        if(getAttaque()!= 0)
            text += "Attaque : " + getAttaque() + "\n";
        if(getDefense() != 0)
            text += "Defense : " + getDefense() + "\n";
        if(getIntelligence() != 0)
            text += "Intelligence : " + getIntelligence() + "\n";
        if(getMana() != 0)
            text += "Mana : " + getMana() + "\n";
        if(getVitesse() != 0)
            text += "Vitesse : " + getVitesse() + "\n";  
        
        return text;
    }
    
    
    

}
