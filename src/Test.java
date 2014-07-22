public class Test {
    
    private Node first = null;
    private Node last = null;
    
    private class Node {
        String item;
        Node next;
        Node last;
    }
 
    public boolean isEmpty() {
        return first == null; 
    }
    
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
    
    public static void main(String[] args) {
        Test a = new Test();
        System.out.println(a.isEmpty());
        a.push("jojo");
        System.out.println(a.isEmpty());
        a.pop();
        System.out.println(a.isEmpty());

    }
}

