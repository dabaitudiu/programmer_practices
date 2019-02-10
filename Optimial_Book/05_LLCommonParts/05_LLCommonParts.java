public class Node {
    private int value;
    private Node next;

    public Node(int data) {
        this.value = data;
    }
}

public void printCommonPart(Node nodeA, Node nodeB) {
    System.out.println("Common part: ");
    while(nodeA != null && nodeB !=null) {
        if (nodeA.value > nodeB.value) {
            nodeB = nodeB.next;
        } else if (nodeA.value < nodeB.value) {
            nodeA = nodeA.next;
        } else {
            System.out.println(nodeA.value + " ");
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
    }
}