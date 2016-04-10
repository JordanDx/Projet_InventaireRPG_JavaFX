package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jordan
 */
public class ObservateurConcret implements Observateur {

    private Personnage personnage;

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }
    
    
    private final StringProperty nombreObjetsInventaire = new SimpleStringProperty("");
        public String getNombreObjetsInventaire() {return nombreObjetsInventaire.get();}
        public void setNombreObjetsInventaire(String value) {nombreObjetsInventaire.set(value);}
        public StringProperty nombreObjetsInventaireProperty() {return nombreObjetsInventaire;}
    
    
    
    
    public ObservateurConcret(Personnage personnage)
    {
        setPersonnage(personnage);
        setNombreObjetsInventaire("Nombre d'objets dans l'inventaire : " + getPersonnage().getInventaire().size());
    }
    
    
    
     //Méthode appelée automatiquement lors d'un changement de taille de l'inventaire du personnage.
    @Override
    public void actualiser()
    {
         setNombreObjetsInventaire("Nombre d'objets dans l'inventaire : " + getPersonnage().getInventaire().size()); 
    }
    
}
