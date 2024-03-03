package Helper_Functions;

import java.util.ArrayList;

public class FIFO {

	private ArrayList<Object> FIFO;
	private int maxSize = 0;
	
	public FIFO() {
		this.FIFO = new ArrayList<>();
	}
	
	public void add(Object item) {
		FIFO.add(item);
        if (FIFO.size() > maxSize()) {
            maxSize++;
        }
	}
	
	public void removeFirst() {
		if (!FIFO.isEmpty()) {
            FIFO.remove(0);
        }
	}
	
	public int getSize() {
		return FIFO.size();
	}
	
	public int maxSize() {
		return maxSize;
	}
	
	public Object getFirst() {
		return FIFO.get(0);
	}
}