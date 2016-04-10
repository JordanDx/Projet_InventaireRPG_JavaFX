package controller;

import java.io.File;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Objet;
import model.Personnage;
import model.ObjetListCell;
import model.Chargement;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.ObservateurConcret;

/**
 *
 * @author Jordan
 */
public class FenetreController {

    @FXML
    private TextArea nomPersonnage; 
    @FXML
    private Label viePersonnage;   
    @FXML
    private Label attaquePersonnage; 
    @FXML
    private Label defensePersonnage;
    @FXML
    private Label intelligencePersonnage;
    @FXML
    private Label manaPersonnage;
    @FXML
    private Label vitessePersonnage;
    @FXML
    private Label piecesPersonnage;

    @FXML
    private ListView<Objet> listeObjets;  
    @FXML
    private TextArea statistiquesObjet;
    @FXML
    private TextArea nombreObjetsInventaire;
    @FXML
    private ListView<Objet> equipement; 
    
    @FXML
    private Button boutonEquiper;
    @FXML
    private Button boutonDesequiper;
    @FXML
    private Button boutonDeteriorer;
    @FXML
    private Button boutonReparer;
    @FXML
    private Button boutonVendre;
    @FXML
    private Button boutonJeter;
    
    private Personnage personnage;

    //Son lancé quand on équipe.
    File fileEquiperSon = new File("src/sounds/EquiperSon.mp3");
    Media mediaEquiperSon = new Media(fileEquiperSon.toURI().toString()); 
    MediaPlayer mediaPlayerEquiperSon = new MediaPlayer(mediaEquiperSon); 

    //Son lancé quand on déséquipe.
    File fileDesequiperSon = new File("src/sounds/DesequiperSon.mp3");
    Media mediaDesequiperSon = new Media(fileDesequiperSon.toURI().toString()); 
    MediaPlayer mediaPlayerDesequiperSon = new MediaPlayer(mediaDesequiperSon);
    
    
    
    
    @FXML
    private void quitter() {
         Platform.exit();
    }
    
    @FXML
     private void equiper() {
       
         if(!listeObjets.getSelectionModel().isEmpty())
        {     
            if(!personnage.aUnObjetDeMemeType(listeObjets.getSelectionModel().getSelectedItem()))
           {

               //son_ou_image
              mediaPlayerEquiperSon.play();
              mediaPlayerEquiperSon.seek(mediaPlayerEquiperSon.getStartTime());


               personnage.equiper(listeObjets.getSelectionModel().getSelectedItem());
               equipement.getItems().setAll(personnage.getEquipement());
               listeObjets.getItems().setAll(personnage.getInventaire());
           }
        }
    }
     
    @FXML
    private void desequiper() {
         
        if(!equipement.getSelectionModel().isEmpty())
        {
            //son_ou_image
            mediaPlayerDesequiperSon.play();
            mediaPlayerDesequiperSon.seek(mediaPlayerDesequiperSon.getStartTime());
         
        
            personnage.desequiper(equipement.getSelectionModel().getSelectedItem());
            equipement.getItems().setAll(personnage.getEquipement());
            listeObjets.getItems().setAll(personnage.getInventaire());
        }
       
     }
     
    @FXML
    private void deteriorer()
    {
       if(!listeObjets.getSelectionModel().isEmpty())
        {
            personnage.deteriorer(personnage.getInventaire().get(listeObjets.getSelectionModel().getSelectedIndex()));
        }  
    }
     
    @FXML
    private void reparer()
    {
        if(!listeObjets.getSelectionModel().isEmpty())
        {
            personnage.reparer(personnage.getInventaire().get(listeObjets.getSelectionModel().getSelectedIndex()));
        }  
    }
     
    @FXML
    private void vendre()
    {
        if(!listeObjets.getSelectionModel().isEmpty())
        {
            personnage.vendre(listeObjets.getSelectionModel().getSelectedItem());
            listeObjets.getItems().setAll(personnage.getInventaire());
        }         
    }
     
    @FXML
    private void jeter()
    {
        if(!listeObjets.getSelectionModel().isEmpty())
        {
           personnage.jeter(listeObjets.getSelectionModel().getSelectedItem());
           listeObjets.getItems().setAll(personnage.getInventaire());
        }
    }
             

    

        


        private void chargerPersonnage()
    {
        Chargement chargement = new Chargement();
        personnage = chargement.getPersonnage();
        listeObjets.getItems().setAll(personnage.getInventaire());    //Met les objets de l'inventaire du personnage dans la ListView listeObjets
        equipement.getItems().setAll(personnage.getEquipement());    //Met les objets de l'équipement du personnage dans la ListView equipement
    }
        
    //Bind des statistiques du personnage.
    private void bindStatistiquesPersonnage()
    {
        nomPersonnage.textProperty().bind(personnage.getStatistiques().nomProperty());
        viePersonnage.textProperty().bind(personnage.getStatistiques().vieProperty().asString());
        attaquePersonnage.textProperty().bind(personnage.getStatistiques().attaqueProperty().asString());     
        defensePersonnage.textProperty().bind(personnage.getStatistiques().defenseProperty().asString());  
        intelligencePersonnage.textProperty().bind(personnage.getStatistiques().intelligenceProperty().asString());
        manaPersonnage.textProperty().bind(personnage.getStatistiques().manaProperty().asString());
        vitessePersonnage.textProperty().bind(personnage.getStatistiques().vitesseProperty().asString());
        piecesPersonnage.textProperty().bind(personnage.piecesProperty().asString()); 
    }
         

     private void creationEcouteurDuChangementDeSelectionObjet() {
        listeObjets.getSelectionModel().selectedItemProperty().addListener((obs,old,newV) -> {
            if (old != null) {
                statistiquesObjet.textProperty().unbind();
                statistiquesObjet.setText("");
            }
            if (newV != null) {
                statistiquesObjet.textProperty().bind(newV.statsProperty());
            }
        });
    }
    
    
    public void bindGrisementBoutons()
    {      
        //Grise le bouton boutonDesequiper quand aucun élément d'inventaire n'est sélectionné.
        boutonDesequiper.disableProperty().bind(equipement.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        
        //Grise le bouton boutonEquiper quand aucun élément d'équipement n'est sélectionné.
        boutonEquiper.disableProperty().bind(listeObjets.getSelectionModel().selectedIndexProperty().isEqualTo(-1));

         //Grise le bouton boutonReparer quand aucun élément d'équipement n'est sélectionné.
        boutonReparer.disableProperty().bind(listeObjets.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        
         //Grise le bouton boutonDeteriorer quand aucun élément d'équipement n'est sélectionné.
        boutonDeteriorer.disableProperty().bind(listeObjets.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        
         //Grise le bouton boutonJeter quand aucun élément d'équipement n'est sélectionné.
        boutonJeter.disableProperty().bind(listeObjets.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        
         //Grise le bouton boutonVendre quand aucun élément d'équipement n'est sélectionné.
        boutonVendre.disableProperty().bind(listeObjets.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }
    
    private void bindNombreObjetsInventaire()
    {
        ObservateurConcret oc = new ObservateurConcret(personnage);
        personnage.attacher(oc);
        nombreObjetsInventaire.textProperty().bind(oc.nombreObjetsInventaireProperty());
    }
    
    
    
  
        
    public void initialize(){
        
        chargerPersonnage();
        bindStatistiquesPersonnage();
        creationEcouteurDuChangementDeSelectionObjet();
        bindGrisementBoutons();
        bindNombreObjetsInventaire();
        
        listeObjets.setCellFactory(lo -> new ObjetListCell());  //Permet d'afficher l'image et le nom des objets de l'inventaire dans la ListView listeObjets  
        equipement.setCellFactory(lo -> new ObjetListCell());   //Permet d'afficher l'image et le nom des objets de l'inventaire dans la ListView equipement

        
        
           

    }

    
}

      