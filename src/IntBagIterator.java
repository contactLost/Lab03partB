import java.util.Iterator;

/**
 * @author Tuna Dalbeler
 *
 */
public class IntBagIterator implements Iterator {

	IntBag aBag;
	int index;
	
	public IntBagIterator( IntBag bag) {
		aBag = bag;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(index < aBag.size() ) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Object next() {
		Integer innt;
		innt = aBag.get(index);
		index++;
		return innt;
	}

}
