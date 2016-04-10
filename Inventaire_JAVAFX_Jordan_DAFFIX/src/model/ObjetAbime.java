/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jordan
 */
public class ObjetAbime extends EtatObjet {
    
    
    @Override
    public int getPrix()
    {
        return super.getPrix()/2;
    }
    
    @Override
    public int getCoutReparation()
    {
        return super.getCoutReparation() * 2;
    }
    
    
}
