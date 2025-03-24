class Main{
    public static void main(String[] args) {
        int arr[] ={1,2,3,4};
        DoubleLL obj = new DoubleLL();
        Node head = null;
        head = obj.arrayToDoubleLL(arr, head);
        // obj.displayDoubleLL(head);
        // head = obj.deleteAtbeginning(head);
        // obj.displayDoubleLL(head);
        // head = obj.deleteAtEnd(head);
        // obj.displayDoubleLL(head);
        // head = obj.deleteAtpos(head, 4);
        // obj.displayDoubleLL(head);
        head = obj.insertAfterPos(0,5,head);
        obj.displayDoubleLL(head);
    }

}