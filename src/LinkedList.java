public class LinkedList {
    private Node head;
    public LinkedList() {
        head = null;
    }
    public void add(BankAccount data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)       {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean search (BankAccount value){
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void delete(BankAccount value){
        if (head == null){
            return;
        }
        if (head.data == value){
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value){
            current = current.next;
        }
        if (current.next != null){
            current.next = current.next.next;
        }

    }
    public void display(){
        System.out.println("Display elements in linked list:");
        Node current = head;
        while (current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("null");
    }


}
