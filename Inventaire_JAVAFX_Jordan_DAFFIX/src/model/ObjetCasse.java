package model;

/**
 *
 * @author Jordan
 */
public class ObjetCasse extends EtatObjet {
    

    @Override
    public int getPrix()
    {
        return 0;
    }
    
    @Override
    public int getCoutReparation()
    {
        return super.getCoutReparation() * 5;
    }
}
