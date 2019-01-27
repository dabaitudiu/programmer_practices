public static Node deleteK(Node head, int K) {
        if (head == null || K < 1) {
            throw new RuntimeException("Linked list is null or K smaller than 1");
        }
        Node cur = head;
        while(cur != null) {
            K--;
            cur = cur.next;
        }
        if (K > 0) {
            throw new RuntimeException("K is larger than the length of the linked list.");
        }
        if (K == 0) {
            head = head.next;
        }
        if (K < 0) {
            cur = head;
            while(++K != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static DoubleNode deleteK(DoubleNode head, int K) {
        if (head == null || K < 1) {
            throw new RuntimeException("Linked list is null or K smaller than 1");
        }
        DoubleNode cur = head;
        while(cur != null) {
            K--;
            cur = cur.next;
        }
        if (K > 0) {
            throw new RuntimeException("K is larger than the length of the linked list.");
        }
        if (K == 0) {
            head = head.next;
            head.last = null;
        }
        if (K < 0) {
            cur = head;
            while(++K != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next != null) {
                cur.next.last = cur;
            }
        }
        return head;
    }