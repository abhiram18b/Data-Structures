

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

    public Node insertBeforeBeginning(int val,Node head){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        head.back = newNode;
        return newNode;

    }

    public Node insertBeforeEnd(int val,Node head){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        if(head.back == null && head.next == null){
            newNode.next = head;
            head.back = newNode;
            return newNode;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        Node prevNode = currNode.back;
        newNode.next = currNode;
        newNode.back = prevNode;
        prevNode.next = newNode;
        currNode.back = newNode;

        return head;

    }

    public Node insertBeforePos(int val,int pos,Node head){
        Node newNode = new Node(val);
        int count =0;
        Node currNode = head;
        while(currNode != null){
            count++;
            if(count == pos){
                break;
            }
            currNode = currNode.next;
        }
        if(currNode == null) return  head;
        Node prevNode = currNode.back;
        Node nextNode = currNode.next;
        if(( prevNode == null && nextNode== null) || (prevNode == null)){
            newNode.next = head;
            head.back = newNode;
            return newNode;
        }else{
            newNode.next = currNode;
            newNode.back = prevNode;
            prevNode.next = newNode;
            currNode.back = newNode;
        }
        return head;
        
    }

    public Node insertAfterBeginning(int val,Node head){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        Node nextNode = head.next;
        if(head.back == null && nextNode == null){
            head.next = newNode;
            newNode.back = head;
        }else{
            newNode.next = nextNode;
            newNode.back = head;
            head.next = newNode;
            nextNode.back = newNode;

        }
        return head;

    }

    public Node insertAfterEnd(int val,Node head){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.back = currNode;
        return head;
    }

    public Node insertAfterPos(int val,int pos,Node head){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        Node currNode = head;
        int count = 0;
        while(currNode != null){
            count++;
            if(count == pos){
                break;
            }
            currNode = currNode.next;
        }
        if(currNode == null) return  head;
        Node prevNode = currNode.back;
        Node nextNode = currNode.next;
        if((prevNode==null && nextNode==null) || nextNode == null){
            currNode.next = newNode;
            newNode.back = currNode;
        }else{
            newNode.next = nextNode;
            newNode.back = currNode;
            currNode.next = newNode;
            newNode.back = newNode;
        }
        return head;
    }

}