/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jordan
 */
 public class ObjetListCell extends ListCell<Objet> { 
     

    private final ImageView imageView = new ImageView();
  
    public ObjetListCell() { 
        super();  
    } 
    

    @Override
    protected void updateItem(Objet item, boolean empty) {
        super.updateItem(item, empty);
        
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            
           imageView.setImage(item.getImage());
           imageView.setFitWidth(40); 
           imageView.setFitHeight(40); 
                   
            setText(item.getStatistiques().getNom());         //A CHANGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ???
            setGraphic(imageView);
        }
    }
    
    

 } 
