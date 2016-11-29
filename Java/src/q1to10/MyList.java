package q1to10;

import java.util.ArrayList;

public class MyList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public T getOrElse(int idx, T defaultVal) {
		if(idx >= this.size() || this.isEmpty()) {
			return defaultVal;
		} else {
			return this.get(idx);
		}
	}
	
}