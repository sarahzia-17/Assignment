class Node {
    int data;
    Node next;
}

public class SimpleLinkedListSort {
    public static void main(String[] args) {
       
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

       
        first.data = 30;
        second.data = 10;
        third.data = 20;

       
        first.next = second;
        second.next = third;
        third.next = null;

  
        int[] arr = {first.data, second.data, third.data};

    
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    
        System.out.println("Sorted list:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
