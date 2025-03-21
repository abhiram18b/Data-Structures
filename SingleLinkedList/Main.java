class Main{
    public static void main(String[] args) {
        LL obj = new LL();
        Node head = null;
        int arr[]={4,5,6,7,8,9,10};
        head = obj.arrayToLinkedList(arr, head);
        obj.dispalyLinkedList(head);
        head = obj.deleteAtbeginning(head);
        obj.dispalyLinkedList(head);
        head = obj.deletAtEnd(head);
        obj.dispalyLinkedList(head);
        head = obj.deleteAtPos(3, head);
        obj.dispalyLinkedList(head);
        head = obj.deleteOnVal(6, head);
        obj.dispalyLinkedList(head);
        head = obj.insertAtBeginning(4, head);
        obj.dispalyLinkedList(head);
        head = obj.insertAtEnd(10, head);
        obj.dispalyLinkedList(head);
        head = obj.insertAtPos(6, 3, head);
        obj.dispalyLinkedList(head);
        head = obj.insertAfterValue(6, 7, head);
        obj.dispalyLinkedList(head);
        head = obj.insertBeforeValue(10, 3, head);
        obj.dispalyLinkedList(head);

    }
}