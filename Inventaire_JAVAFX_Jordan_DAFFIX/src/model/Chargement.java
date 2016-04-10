package model;

/**
 *
 * @author thlaurent3
 */
public class Chargement {

    
    
    private Personnage personnage;
    public Personnage getPersonnage() {
        return personnage;
    }
    
    
    public Chargement() {
        personnage = new Personnage("Thrall", 300, 50, 200, 160, 30, 5, 200);
        
        Objet objet1 = new Objet("Tete", "images/CasqueACornes.jpg", "Casque à  cornes", 50, 5, 15, 10, 2, 0, 20, 20);
        Objet objet2 = new Objet("Tete", "images/ChapeauAFleurs.jpg", "Chapeau à  fleurs", 40, 20, 10, 2, 20, 10, 1, 5);
        Objet objet3 = new Objet("Pieds", "images/Boots1.png", "Bottes de sept lieux", 15, 0, 3, 5, 70, 5, 5, 7);
        Objet objet4 = new Objet("Pieds", "images/Boots2.png", "Bottes en cuir", 15, 0, 5, 2, 30, 10, 10, 12);

        //Ajoute les objets à  l'inventaire du personnage
        personnage.addObjetsInventaire(objet1,objet2,objet3,objet4);
        
        

    }
    
}
