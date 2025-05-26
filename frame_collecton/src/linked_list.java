class Node {
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class linked_list {

    static boolean areIdentical(Node head1, Node head2)
    {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return (head1 == null && head2 == null);
    }

    public static void main(String[] args)
    {

        Node head1 = new Node(3);
        head1.next = new Node(2);
        head1.next.next = new Node(1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        if (areIdentical(head1, head2)==true)
            System.out.println("The linked lists are identical");
        else
            System.out.println("The linked lists are not identical");
    }
}