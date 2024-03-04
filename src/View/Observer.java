package View;

import State.StoreState;

public interface Observer {
	public void update(StoreState storeState);
}
