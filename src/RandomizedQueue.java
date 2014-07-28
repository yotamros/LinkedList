import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] array = (Item[]) new Object[1];
    private int size = 0;
    
    /*
     * Construct an empty randomized queue
     */
    public RandomizedQueue() {
    }
    
    /*
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return ( size == 0 );
    }
    
    /*
     * Return the number of items on the queue
     */
    public int size() {
        return size;
    }
    
    /*
     * Add the item
     */
    public void enqueue(Item item) {
        
        if (item == null) {
            throw new NullPointerException("Can't add a null item");
        }
        
        if (array.length == size ) {
            resize(array.length*2);
        }
        
        array[size] = item;
        System.out.println("added " + item + " at " + size);
        size++;
        System.out.println("there are " + size + " items in the array and the "
                + "array length is " + array.length);
    }
    
    private void resize(int i) {
        Item[] copyArray = (Item[]) new Object[i];
        for (int j = 0; j < array.length; j++) {
            copyArray[j] = array[j];
            System.out.println(j + ": " + array[j]);
        }
        array = copyArray;
        System.out.println("Created a new array of size " + i);
    }

    private void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    /*
     * Delete and return a random item
     */
    public Item dequeue() {
        
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        int rand = rand(size);
        if (array[rand] == null) {
            rand = rand(size);
        }
        Item itemToRemove = array[rand];
        array[rand] = null;
        size--;
        if (size > 0 && size == array.length/4) {
            resize(array.length/2);
        }
        System.out.println("removed " + itemToRemove + " there are " + 
        size + " items and the length is " + array.length);
        return itemToRemove;
    }
    
    private int rand(int length) {
        Random rand = new Random();
        int randNum = rand.nextInt(length);
        return randNum;
    }
    
    /*
     * Return (but do not delete) a random item
     */
    public Item sample() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        int rand = rand(size);
        if (array[rand] == null) {
            rand = rand(size);
        }
        Item sample = array[rand];
        System.out.println("sample: " + sample);
        return sample;
    }
    
    
    /*
     * (non-Javadoc) Return an independent iterator over items in random order
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item> {
        
        int current = 0;
        
        public boolean hasNext() {
            return array[current] == null;
            
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            
        }
        
    }
    
    
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("jojo");
        rq.enqueue("momo");

        rq.sample();

    }
}