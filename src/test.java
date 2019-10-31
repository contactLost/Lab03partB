
/**
 * @author Tuna Dalbeler
 *
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			IntBag bag = new IntBag();
			
			bag.add(1);
			bag.add(2);
			bag.add(3);
			
			System.out.println(bag.toString());
			System.out.println(bag.size());
			
			System.out.println(bag.nextInt());
			System.out.println(bag.nextInt());
			System.out.println(bag.nextInt());
			System.out.println(bag.nextInt());
	}

}
