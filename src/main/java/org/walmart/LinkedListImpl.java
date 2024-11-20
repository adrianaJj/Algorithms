package org.walmart;

public class LinkedListImpl {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListImpl() {
        this.head = null;
    }


    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();

        // Inserting nodes
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        // Displaying the linked list
        System.out.print("Linked List: ");
        linkedList.display();
    }
}

