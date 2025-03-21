class Main{
    public static void main(String[] args) {
        int arr[] ={1,2,3,4};
        DoubleLL obj = new DoubleLL();
        Node head = null;
        head = obj.arrayToDoubleLL(arr, head);
        obj.displayDoubleLL(head);
    }
}