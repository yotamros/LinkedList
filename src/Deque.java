import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int size = 0;
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    
   /**
    * Is the deque empty?
    * @return
    */
   public boolean isEmpty() {
       return size == 0;
   }
   
   /**
    * Return the number of items on the deque
    * @return
    */
   public int size() {
       return size;
   }
   
   /**
    * Insert the item at the front
    * @param item
    */
   public void addFirst(Item item) {
       if (item == null) {
           throw new NullPointerException("Can't add a null object.");
       }
       Node tempFirst = first;
       Node newFirst = new Node();
       newFirst.item = item;
       newFirst.next = tempFirst;
       newFirst.prev = null;
       first = newFirst;
       size++;
   }
   
   /**
    * Insert the item at the end
    * @param item
    */
   public void addLast(Item item) {
       if (item == null) {
           throw new NullPointerException("Can't add a null object.");
       }
       Node tempLast = last;
       Node newLast = new Node();
       newLast.item = item;
       newLast.next = null;
       newLast.prev = tempLast;
       last = newLast;
       size++;
   }
   
   /**
    * Delete and return the item at the front
    * @return
    */
   public Item removeFirst() {
       if (size == 0) {
           throw new java.util.NoSuchElementException("Can't remove. The list is empty");
       }
       Node copyOfFirst = first;
       Node newFirst = first.next;
       first = newFirst;
       size--;
       return copyOfFirst.item;
   }
   
   /**
    * Delete and return the item at the end
    * @return
    */
   public Item removeLast() {
       if (size == 0) {
           throw new java.util.NoSuchElementException("Can't remove. The list is empty");
       }
       Node copyOfLast = last;
       Node newLast = last.prev;
       last = newLast;
       size--;
       return copyOfLast.item;
   }
   
   /**
    * Return an iterator over items in order from front to end
    * 
    */
   public Iterator<Item> iterator() {
       return null;
   }
   
   
   public static void main(String[] args) {
       Deque<String> test = new Deque<String>();
       System.out.println(test.isEmpty());
       test.addFirst("jojo");
       test.addFirst("momo");
       System.out.println(test.isEmpty());
       System.out.println("items in list: " +test.size);
       test.addLast("koko");
       System.out.println("items in list: " +test.size);
       System.out.println(test.removeFirst());
       System.out.println("items in list: " +test.size);
       System.out.println(test.removeLast());
       System.out.println("items in list: " +test.size);
       test.removeFirst();
       System.out.println("items in list: " +test.size);
       test.removeFirst();

   }
   
}