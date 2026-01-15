public class SingleLinkedList {
    Node head;
    public void insertTail(Mahasiswa data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.print("null");
    }

    public void pop(){
        if(head != null){
            head = head.next;
        }
    }

    public void sortByNim() {
        if (head == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (Long.parseLong(j.data.nim) > Long.parseLong(j.next.data.nim)) {
                    Mahasiswa temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }
}
