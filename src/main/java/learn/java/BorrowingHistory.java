package learn.java;

import java.util.ArrayList;
import java.util.List;

public class BorrowingHistory {
    private class Node {
        String borrower;
        Node next;

        Node(String borrower) {
            this.borrower = borrower;
            this.next = null;
        }
    }

    private Node head;

    public void addBorrower(String borrower) {
        Node newNode = new Node(borrower);
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

    public List<String> getBorrowers() {
        List<String> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.borrower);
            current = current.next;
        }
        return list;
    }
}