package ModulesSpecialises;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ModuleSpecialise implements PropertyChangeListener{
    private PropertyChangeSupport support;
    private String suivi;

    public abstract void propertyChange(PropertyChangeEvent evt);

    public ModuleSpecialise(){
        support = new PropertyChangeSupport(this);
        suivi = "filler";
    }

    public ModuleSpecialise(String suivi){
        support = new PropertyChangeSupport(this);
        this.suivi = suivi;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

    public String getSuivi(){
        return suivi;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
