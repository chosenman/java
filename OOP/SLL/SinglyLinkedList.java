class SinglyLinkedList {
  public Node head;
  public Node lastNode;

  SinglyLinkedList(){
    this.head = null;
    this.lastNode = null;
  }

  void add(int num){
    Node newNode = new Node(num);
    if(this.head == null) {
      this.head = newNode;
      this.lastNode = this.head;
    } else {
      this.lastNode.next = newNode;
      this.lastNode = this.lastNode.next;
    }
  }

  void remove(){
    if(this.head == null){
      System.out.println("you don't have nodes to remove");
    } else if (this.head.next == null) {
      this.head = null;
    } else {
      Node runner = this.head;
      while(runner.next.next != null) {
        runner = runner.next;
      }
      System.out.println("last node value: " + runner.next.value);
      runner.next = null;
      this.lastNode = runner;
      System.out.println("Last node removed... ");
    }
  }

  void printValues(){
    if(this.head == null){
      System.out.println("you don't have nodes to print");
    }else{
      Node runner = this.head;
      while(runner != null) {
        System.out.println(runner.value);
        runner = runner.next;
      }
    }
  }

}
