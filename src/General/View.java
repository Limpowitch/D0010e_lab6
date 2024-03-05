package General;

import java.util.Observable;
import java.util.Observer; // Import Observer interface

<<<<<<< Updated upstream:src/General/View.java
public class View extends Observable {
	//oklart
	
=======
public class GeneralView implements Observer {

    // Method called when the observed object changes
    public void update(Observable o, Object arg) {
        // This method can be left empty if updates are handled by specific observer classes
    }
>>>>>>> Stashed changes:src/General/GeneralView.java
}
