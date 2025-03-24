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

    //delete methods
    public Node deleteAtbeginning(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    public Node deleteAtEnd(Node head){
         if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prevToLast = tail.back;
        tail.back = null;
        prevToLast.next = null;
        return head;
    }

    public Node deleteAtpos(Node head,int pos){
        if(head == null)
            return null;
        Node currNode = head;
        int count = 0;
        while(currNode != null){
            count++;
            if(count == pos){
               
                break;
            }
            currNode = currNode.next;
        }
        Node prevNode = currNode.back;
        Node nextNode = currNode.next;
        if(prevNode == null && nextNode == null){
                head = null;
        }else if(prevNode == null){
            currNode.next = null;
            nextNode.back = null;
            head = nextNode;
        }else if(nextNode == null){
            currNode.back = null;
            prevNode.next = null;
        }else{
            prevNode.next = nextNode;
            nextNode.back = prevNode;
            currNode.next = null;
            currNode.back = null;
        }
        return head;
    }



}