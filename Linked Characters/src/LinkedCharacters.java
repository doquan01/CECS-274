import java.util.NoSuchElementException;

/**
 * A sequence of characters that an be mutated.
 * @author Alvaro Monge
 * @author Quan Do
 */
public class LinkedCharacters {
    public static final Character CURSOR = '|';
    private class Node{
        Character character;
        Node next;
        public Node(Character c, Node link){
            this.character = c;
            this.next = link;
        }
    }

    private Node first;
    private Node last;
    private Node cursor;
    private Node previous;  // previous to Node at cursor

    /**
     * Creates a linked list of Character objects, one from each of the characters in the text.
     * @param text The characters to create the linked list from
     */
    public LinkedCharacters(String text) {
        if (text != null && ! text.isEmpty()) {
            char[] characters = text.toCharArray();
            this.first = new Node(characters[0], null);
            Node current = first;
            for (int i=1; i < text.length(); i++) {
                current.next = new Node(characters[i], null);
                current = current.next;
            }
            last = current;

            cursor = this.first;
        }

        // otherwise, all Node instance variables remain null, their default value
    }

    /**
     * @author Quan Do
     * Insert a character at the current position of the cursor.
     * @param c the character to be inserted
     */
    public void insert(Character c) {
        if (previous == null) {
            Node newCharacter = new Node(c, null);
            newCharacter.next = first;
            first = newCharacter;
            previous = newCharacter;
        }
        else if (cursor != null) {
            Node newCharacter = new Node(c, cursor);
            previous.next = newCharacter;
            previous = previous.next;
        }
        else if (cursor == null){
            Node newCharacter = new Node(c, null);
            previous.next = newCharacter;
            previous = previous.next;
        }
    }

    /**
     * @return true if there's a next character after the cursor
     */
    public boolean hasNext() {
        return cursor != null;
    }

    /**
     * Position the cursor at the first Character in the sequence
     */
    public void first() {
        cursor = first;
        previous = null;
    }

    /**
     * Move the cursor forward from its current position
     * @return the Character that was bypassed when the cursor was moved
     * @throws NoSuchElementException when the cursor is past the last character as there's no next
     */
    public Character next() throws NoSuchElementException {
        if (cursor == null) {
            throw new NoSuchElementException();
        }

        Character result = cursor.character;
        previous = cursor;
        cursor = cursor.next;
        return result;
    }

    /**
     * Overwrites the character at the current position with the character provided.
     * @param c the character that replaces the current one at the cursor's position in the sequence
     * @throws NoSuchElementException
     */
    public void set(Character c) throws NoSuchElementException {
        if (cursor == null)
            throw new NoSuchElementException();

        cursor.character = c;
    }

    /**
     * Provides a String representation of the sequence and the position of the cursor.
     * The cursor is represented by a vertical bar | and is shown immediately before
     * the character where the cursor is positioned.
     * @return the String representation, e.g.: "Go| Beach"
     */
    public String toString() {
        String result = "";
        Node nodeIterator = first;
        boolean isCursorInserted = false;
        while ( nodeIterator != null) {
            if ( nodeIterator == cursor) {
                result += CURSOR;
                isCursorInserted = true;
            }

            result +=  nodeIterator.character;
            nodeIterator = nodeIterator.next;
        }

        if ( (first == null) || (first != null && !isCursorInserted) )
            result += CURSOR;

        return result;
    }
}