import java.sql.SQLOutput;
import java.util.Scanner;


public class main  {
    public static  void printStack(StackADT stack)
    {


        StackADT<Integer> stack1=new AStack(stack.length());
        //  StackADT<Integer> stack1=new LStack<>();
        System.out.print("<");



        int length=stack.length();


        for(int i=0;i<length;i++) {
            stack1.push((Integer) stack.pop());
        }

        for(int i=0;i< length-1;i++)
        {
            Integer t=stack1.pop();
            System.out.print(t);
            System.out.print(",");
            stack.push(t);
        }
        if(stack1.length()!=0) {
            Integer t = stack1.pop();
            System.out.print(t );
            stack.push(t);
        }
        System.out.println(">");

    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int k=scanner.nextInt();
        StackADT <Integer> stack =new AStack<Integer>(k);
        //StackADT<Integer> stack=new LStack<Integer>();
        int i;
        /*for(i=0;i<k;i++)
        {
            stack.push(scanner.nextInt());
        }*/
        printStack(stack);
        int P,Q;
        while(true) {

            Q = scanner.nextInt();
            P = scanner.nextInt();
            if(Q==0)
                break;
            else if(Q==1)
            {
                stack.clear();
                printStack(stack);
                System.out.println(-1);

            }
            else if(Q==2)
            {
                stack.push(P);
                printStack(stack);
                System.out.println(-1);
            }
            else if(Q==3)
            {
                Integer s= stack.pop();
                printStack(stack);
                System.out.println(s);
            }
            else if(Q==4)
            {

                printStack(stack);
                System.out.println(stack.length());
            }
            else if(Q==5)
            {

                Integer s= stack.topValue();
                printStack(stack);
                System.out.println(s);
            }
            else if(Q==6)
            {
                stack.setDirection(P);
            }

        }
    }


}
