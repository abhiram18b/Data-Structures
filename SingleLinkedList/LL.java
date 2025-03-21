

class LL{
    public Node arrayToLinkedList(int[] arr,Node head){
        int n = arr.length;
        head = new Node(arr[0],null);
        Node currNode = head;
        for (int i= 1; i < n; i++) {
            Node newNode = new Node(arr[i],null);
            currNode.next = newNode;
            currNode = newNode; 
        }
        return head;
    }

    //delete methods

    public Node deleteAtbeginning(Node head){
        if(head == null){
            return null;
        }
        head = head.next;
        return head;
    }

    public Node deletAtEnd(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
        return head;
    }


    public Node deleteAtPos(int pos,Node head){
        if(head == null){
            return null;
        }

        if(pos == 1){
            head = head.next;
            return head;
        }

        Node currNode = head;
        Node prev = null;
        int count = 0; //to keep track of current position
        while(currNode != null){
            count++; 
            /*increment at beginning because we started currNode at head,
            so when we enter the loop our current position will be at currentElement index*/
            if(count == pos){
                prev.next = prev.next.next;
            }
            prev = currNode;
            currNode = currNode.next;
        }
        return head;


        /*Let our linked list be 5->6->7->8->9
            Case1:Now if we want to delete element at position 1 , we obviously understand that we need to delete head.
            Case2:For suppose if we want to delete element at postion 3,we need to traverse till 3rd element and then make the
            changes accordingly.

            Now coming to the code.
                position = 3 //given
                currNode = head;
                prev = null;
                count=0
                while loop starts
                    currNode != null true;
                    goes in to loop
                    first iteration started
                    count++ //at the beginning to keep track our current position because we started currNode at head;
                    checks if count= 1 ,pos = 3;
                    count != post not true
                    Now 
                        prev = currNode ----------> prev = 5
                        currNode = currNode.next -------------> currNode = 6
                    first iteration is completed
                    prev = 5
                    currNode =6
                    count = 1
                    ------------------------------------------------
                    again checks currNode != null in while which is true
                    goes in to loop
                    second iteration started
                    Now we can get clear understanding of why incrementing at beginning,
                    here currNode is at 6 which 2 position,now incrementing count makes our
                    count =2,now we are at our correct position(this is to consistently maintain zero based indexing which
                    might help in further data structures,if you are not comfortable you can use 1-based indexing 
                    and make changes in the code accordingly)
                    checks if count == pos
                    count = 2,pos = 3 false
                    Now 
                        prev = currNode ----------> prev = 6
                        currNode = currNode.next -------------> currNode = 7
                    second iteration is completed
                    prev = 6
                    currNode = 7
                    count = 2
                    ------------------------------------------------
                    again checks currNode != null in while which is true
                    goes in to loop
                    third iteration started
                    here currNode is at 7 which 3 position,now incrementing count makes our
                    count =3,now we are at our correct position
                    checks if count == pos
                    count = 3,pos = 3 true
                        Now prev =6,currNode =7
                        
                        prev.next = prev.next.next
                        which makes 5->6->7->8->9 to 5->6->8->9
                        break; goes out of the loop
                    Now 
                        prev = currNode ----------> prev = 6
                        currNode = currNode.next -------------> currNode = 7
                    in third iteration we found the position,deletes the currNode,breaks out of the loop
                    return head;
            Case 3:if position=5 in 5->6->7->8->9;
            goes till 9 currNode will be at 9,prev will be at 8
            prev.next = prev.next.next which is null
            which makes the linked list 5->6->7->8;

            Case 4: if position is greater than length of linked list,we delete nothing retrun the linked list as it is;
        */

    }

    public Node deleteOnVal(int val,Node head){
        if(head == null){
            return null;
        }
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node currNode = head; //(we can check from currNode = head.next making prev = head  but to maintain consistency I prefered head)
        Node prev = null;
        while(currNode != null){
            if(currNode.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = currNode;
            currNode = currNode.next;
        }
        return head;
    }

    //insert methods

    public Node insertAtBeginning(int val,Node head){
        Node newNode = new Node(val,null);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node insertAtEnd(int val,Node head){
        Node newNode = new Node(val,null);
        if(head == null){
            return newNode;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return head;
    }

    public Node insertAtPos(int val,int pos,Node head){
        Node newNode = new Node(val,null);
        if(head == null)
        {
            return null;
        }
        if(pos==1){
             newNode.next = head;
             head = newNode;
             return  head;
        }
        Node currNode = head;
        int count = 0;
        while(currNode != null){
            count++;
            if(count == pos-1){ //pos-1 allows us to stay at one node before insert position,which makes insertion easy
                newNode.next = currNode.next;
                currNode.next = newNode;
            }
            currNode = currNode.next;
        }
        return head;
    }

    public Node insertAfterValue(int val,int ele,Node head){
        Node newNode = new Node(ele,null);
        if(head == null){
            return null;
        }
        
        Node currNode = head;
        while(currNode != null){
            if(currNode.data == val){
                newNode.next = currNode.next;
                currNode.next = newNode;
                break;
            }
            currNode=currNode.next;
        }
        return head;
    }

    public Node insertBeforeValue(int val,int ele,Node head){
        Node newNode = new Node(ele,null);
        if(head == null){
            return null;
        }
        if(head.data == val){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node currNode = head;
        while(currNode.next != null){
            /*to insert before the value ,stand the node which is previuos to node with val ,
                do that by checking currNode.next.data,so you can stay at previous node and make an insertion
            */
            if(currNode.next.data == val){
                newNode.next = currNode.next;
                currNode.next = newNode;
                break;
            }
            currNode = currNode.next;
        }
        return  head;
        
    }

    //displaymethod
    public void dispalyLinkedList(Node head){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

}

