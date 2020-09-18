public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void display() {
        Node temp = head;
        int counter = 1;
        while (temp != null) {
            temp.display();
            System.out.print("\t");
            if (counter % 12 == 0) {
                System.out.println();
            }
            temp = temp.getNext();
            counter++;
        }
    }

    public void add(String s) {
        Node newNode = new Node(s);
            if (head == null) { //Make a first Node if non
                head = newNode;
            }
            //compareTo 0: they are the same: a=a
            // -1: if first is smaller than second: a - b
            // 1: first is bigger than second b - a
            else if (s.compareTo(head.getValue()) <= 0) { // add to front
                newNode.setNext(head);
                head = newNode;
            } else if (s.compareTo(head.getValue()) > 0) { //add middle or after
                Node current = head;
                Node previous = head;
            while (s.compareTo(current.getValue()) > 0) { //add to proper location
                previous = current;
                current = current.getNext();
                if (current == null) {
                    newNode.setNext(previous.getNext());
                    break;
                }
            }
            if (current != null) {
                newNode.setNext(current);
            }
            previous.setNext(newNode);
            } else {
            newNode.setNext(head);
            head = newNode;
        }
    }
    public void delete(int x, LinkedList l) {
        Node previous = head;
        Node current = head;
        int counter = 1;
        if (x == 1 || x <= 1 && head != null) {
            Node firstTemp = head;
            head = head.getNext();
            System.out.println();
            l.display();
            System.out.println("\n\n" + firstTemp.getValue() + " was removed from location 1");
        } else {
            while (counter < x) {
                previous = current;
                current = current.getNext();
                counter++;
            }
            previous.setNext(current.getNext());
            System.out.println();
            l.display();
            System.out.println("\n\n" + current.getValue() + " was removed from location " + counter);
        }
    }

    public Boolean findBoolean(String s) {
        Node current = head;
        while (current != null) {
            if (s.compareTo(current.getValue()) == 0) {
                return true;
            } else {
                current = current.getNext();
            }
        }
        return false;
    }

    public int findLocation(String s) {
        Node current = head;
        int counter = 1;
        while (current != null) {
            if (s.compareTo(current.getValue()) == 0) {
                return counter;
            } else {
                current = current.getNext();
                counter++;
            }
        }
        return counter;
    }
    public int getSize(){
        Node current = head;
        int counter = 1;
        while(current != null){
            current = current.getNext();
            counter++;
        }
        return counter;
    }
}
