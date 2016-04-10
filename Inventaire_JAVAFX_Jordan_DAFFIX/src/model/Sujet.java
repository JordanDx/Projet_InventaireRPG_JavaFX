package model;

/**
 *
 * @author jordan
 */
public interface Sujet {
    
    public void attacher(Observateur o);
    public void detacher(Observateur o);
    public void notifier();
       
}
