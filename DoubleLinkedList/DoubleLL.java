class DoubleLL{
    public Node arrayToDoubleLL(int[] arr,Node head){
        int n = arr.length;
        head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<n;i++){
            Node newNode = new Node(arr[i]);
            newNode.back = prev;
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    public void displayDoubleLL(Node head){
        Node currNode = head;
        Node lastNode = null;
        System.out.println("frontal traversal");
        while(currNode != null){
            if(currNode.next == null) lastNode = currNode;
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("null");
        System.out.println("reverse traversal");
        while(lastNode != null){
            System.out.print(lastNode.data+"->");
            lastNode = lastNode.back;
        }
        System.out.println("null");
    }
}