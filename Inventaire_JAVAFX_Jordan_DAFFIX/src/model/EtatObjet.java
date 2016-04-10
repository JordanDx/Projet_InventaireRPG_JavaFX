package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Jordan
 */
public abstract class EtatObjet {
    
    private final ObjectProperty<Integer> prix = new SimpleObjectProperty<>(10);
        public int getPrix() {return prix.get();}
        public void setPrix(int value) {prix.set(value);}
        public ObjectProperty prixProperty() {return prix;}
      
      
    private final ObjectProperty<Integer> coutReparation = new SimpleObjectProperty<>(10);
        public int getCoutReparation() {return coutReparation.get();}
        public void setCoutReparation(int value) {coutReparation.set(value);}
        public ObjectProperty coutReparationProperty() {return coutReparation;}
}
