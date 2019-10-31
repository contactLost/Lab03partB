import java.util.Iterator;

/** This class creates an array that holds int
 * @author Tuna Dalbeler
 * @date 10.10.19
 */
public class IntBag implements IntIterator {

	private final int SENTINEL = -1;

	//Properties

	private int[] intBag;
	private int indexSentinel;
	private Iterator iterator;

	//Constructor

	/** Construct an int bag.
	 * 
	 */ 
	public IntBag(){

		iterator = iterator();

		intBag = new int[4];
		intBag[0] = SENTINEL;
		indexSentinel = 0;
	}

	//Methods

	/** Adds value to end of the array
	 * 
	 * @param input
	 */ 
	public void add(int input){      
		boolean added = false;

		if(indexSentinel == intBag.length -1){
			addSpace();
		}

		intBag[indexSentinel +1] = -1;
		intBag[indexSentinel] = input;
		indexSentinel++;
	}

	/**Adds value to specified index
	 * 
	 * @param i index
	 * @param input value
	 */ 
	public void addTo(int i, int input){

		if(i > size()){
			//check i is within bounds
			if(i < intBag.length){

				int[] newIntBag = new int[intBag.length+1];
				System.arraycopy(intBag, 0, newIntBag, 0, i );
				System.arraycopy(intBag, i-1, newIntBag, i, intBag.length - i+1 );

				intBag = newIntBag;

				intBag[i] = input;
				indexSentinel++;
			}     
		}else{ System.out.println("Invalid index"); }
	}

	/**Doubles the array size
	 */ 
	private void addSpace(){    
		int[] longerIntBag = new int[ intBag.length * 2 ];  
		System.arraycopy(intBag, 0, longerIntBag, 0, intBag.length); 
		intBag = longerIntBag;        
	}

	/**LOOKremoves the value from index
	 * @param index
	 */ 
	public void remove(int index){

		intBag[index] = intBag[indexSentinel -1];

		intBag[indexSentinel -1] = -1;

		intBag[indexSentinel] = 0;

		indexSentinel--;

	}

	/** Removes all the specified value from array
	 * @param input
	 * 
	 */ 
	public void removeAll(int input){
		int counter = 0;
		for(int i = 0; i < intBag.length; i++){

			if(intBag[i] == input){
				counter++;
			}

		}

		for(int c= 0; c < counter; c++){

			for(int i= 0; i < intBag.length; i++){

				if(intBag[i] == input ){

					remove(i);
				}
			}
		}
	}

	/** Counts how many nonzero values exist
	 * 	@return counter
	 */ 
	public int size(){
		int counter = 0;

		for(int i = 0; !(-1 == intBag[i]) ; i++){
			counter++;
		}
		return counter;
	}

	/**Gets the number in ith position
	 * @param i
	 * @return result i position
	 */
	public int get(int i) {
		int result;
		result = intBag[i];
		return result;
	}

	/**Outputs a string representation of the array
	 * @return string string
	 */ 
	public String toString(){
		String string;
		string = "";

		for(int i=0; i < size() ; i++){           
			string = string + " " + intBag[i] ;
		}
		string = "{ " + string + " }";
		return string; 
	}

	/**Creates the iterator object and returns it
	 * 
	 * @return Iterator
	 */
	public Iterator iterator() {

		Iterator it = new IntBagIterator( this );

		return it;
	}

	/**IntBagIterator class. Provides IntBag class to iterator utilities
	 * 
	 * @author tunad
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

	/**Checks if there is a next int in the bag
	 * @return is there next object
	 */
	@Override
	public boolean hasNext() {		
		return iterator.hasNext();
	}

	/**Returns the next integer in Integer wrapper class.
	 * 
	 */
	@Override
	public Object next() {
		return iterator.next();
	}

	/**Returns the next int in the collection
	 * @return int next int
	 */
	@Override
	public int nextInt() {
		int integer;
		integer = ((Integer) iterator.next());
		return integer;
	}






}