import java.util.Scanner;

public class main {
    public static void print(QueueADT queue) {
        int length= queue.length();
         QueueADT<Integer> tempQueue=new AQueue<>(length);
       // QueueADT<Integer> tempQueue=new LQueue<>(length);
         System.out.print("<");
        for(int i=0;i<length;i++) {
            tempQueue.enqueue((Integer) queue.dequeue());
        }

        for(int i=0;i< length-1;i++)
        {
            Integer t=tempQueue.dequeue();
            System.out.print(t);
            System.out.print(",");
            queue.enqueue(t);
        }
        if(tempQueue.length()!=0) {
            Integer t = tempQueue.dequeue();
            System.out.print(t );
            queue.enqueue(t);
        }
        System.out.println(">");


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        QueueADT<Integer> queue = new AQueue<>(k);
       // QueueADT<Integer> queue = new LQueue<>(k);
        int i;
        /*for(i=0;i<k;i++)
        {
            stack.push(scanner.nextInt());
        }*/

        int P, Q;
        while (true) {

            Q = scanner.nextInt();
            P = scanner.nextInt();
            if (Q == 0)
                break;
            else if (Q == 1) {
                queue.clear();
                print(queue);
                System.out.println(-1);

            } else if (Q == 2) {
                queue.enqueue(P);
                print(queue);
                System.out.println(-1);
            } else if (Q == 3) {
                Integer s = queue.dequeue();
                print(queue);
                System.out.println(s);
            } else if (Q == 4) {

                print(queue);
                System.out.println(queue.length());
            } else if (Q == 5) {

                Integer s = queue.frontValue();
                print(queue);
                System.out.println(s);
            } else if (Q == 6) {
                Integer s = queue.rearValue();
                print(queue);
                System.out.println(s);
            } else if (Q == 7) {
                Integer s = queue.leaveQueue();
                print(queue);
                System.out.println(s);
            }

        }
    }
}
