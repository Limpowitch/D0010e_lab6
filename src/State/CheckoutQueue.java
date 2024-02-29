package State;
import java.time.LocalTime;
import java.util.*;
public class CheckoutQueue{

	private int queueTime;
	private int queuedCostumers;
	List<Integer> queue = new ArrayList<Integer>();
	
	
	
	public float queueTimer() {
		/* The timer is supposed to detect if there is someone in the queue or not and start if there
		 * is someone present and finish and calculate total time that there has been costumers in the queue
		 */
		//LocalTime startTimer = new LocalTime.now();
		
		
		
	}
	
	
	public void addToRegisterQueue(int costumer)
	{
		queue.add(costumer);
		return;
	}
	
	
	
}
