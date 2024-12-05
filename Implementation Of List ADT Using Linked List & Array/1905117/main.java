import java.sql.SQLOutput;
import java.util.Scanner;

public class main {
    private static void print(List list)
    {
        int cp=list.currPos();
        list.moveToStart();
        System.out.print("<");
        for(int i=0;i< list.length();i++)
        {

            if(i==cp)
            {
                System.out.print("|"+" ");
                System.out.print(list.getValue()+" ");
            }
            else
            {
                System.out.print(list.getValue()+" ");
            }
            list.next();

        }
        System.out.print(">");
        System.out.println(" ");
        list.moveToPos(cp);

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int x=scanner.nextInt();

       // List<Integer> list=new LinkedList<>(k);
        List<Integer> list=new ArrayClass<>();
        Integer [] arr=new Integer[k];
        for(int i=0;i<k;i++)
           list.append(scanner.nextInt());

        print(list);
        int Q;
        int P;
        while(true)
        {

            Q=scanner.nextInt();
            P=scanner.nextInt();
            if(Q==0)
                break;
            else if(Q==1)
            {
                list.clear();
                print(list);
                System.out.println(-1);
            }
            else if(Q==2)
            {
                list.insert(P);
               print(list);
                System.out.println(-1);

            }
            else if(Q==3)
            {
                list.append(P);
             print(list);
                System.out.println(-1);
            }

            else if(Q==4)
            {
               Integer s= (Integer) list.remove();
                print(list);
                System.out.println(s);

            }
            else if(Q==5)
            {
                list.moveToStart();
                print(list);
                System.out.println(-1);
            }
            else if(Q==6)
            {
                list.moveToEnd();
               print(list);
                System.out.println(-1);
            }
            else if(Q==7)
            {
                list.prev();
                print(list);
                System.out.println(-1);
            }
            else if(Q==8)
            {
                list.next();
                print(list);
                System.out.println(-1);
            }
            else if(Q==9)
            {
                print(list);
                System.out.println( list.length());

            }
            else if(Q==10)
            {
                System.out.println(list.currPos());
               print(list);

            }
            else if(Q==11)
            {
                list.moveToPos(P);
                print(list);
                System.out.println(-1);

            }
            else if(Q==12)
            {
                Integer s= (Integer) list.getValue();
                print(list);
                System.out.println(s);

            }

            else if(Q==13)
            {
                print(list);
                System.out.println( list.Search(P));


            }



        }


    }


}
