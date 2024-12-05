import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        int x;
        //int customerTime,taskTime;
        Scanner scanner=new Scanner(System.in);
        x= scanner.nextInt();
        Integer arr[][]=new Integer[x][2];
        int time1=0,time2=0,time3,index1,index2;
        QueueADT<Integer> queue1=new AQueue<>(x);
        QueueADT<Integer> queue2=new AQueue<>(x);
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<2;j++)
            {
                arr[i][j]=scanner.nextInt();

            }
        }
      //  time1=arr[0][0];
        for(int i=0;(i<x || queue1.length()!=0 || queue2.length()!=0);) {
            if(queue1.length()==0 && i<x)
            {
                queue1.enqueue(i++);
            }
            if(queue2.length()==0 && i<x)
            {
                queue2.enqueue(i++);
            }
          //  System.out.println(queue1.frontValue());
             index1=queue1.frontValue();


             index2=queue2.frontValue();


            if(time1<arr[index1][0]){

                time1=arr[index1][0];
            }


            if(time2<arr[index2][0]) {
                time2 = arr[index2][0];
            }

            if(time1+arr[index1][1] < time2+arr[index2][1])
            {
                time3=time1+arr[index1][1];
            }
            else
                time3=time2+arr[index2][1];


            while(i<x && arr[i][0]<time3)
            {
                if(queue2.length()>= queue1.length())
                queue1.enqueue(i++);
                else
                    queue2.enqueue(i++);

            }

            if(time1+arr[index1][1]==time3)
            {
                queue1.dequeue();
                time1=time1+arr[index1][1];

            }
            if(time2+arr[index2][1]==time3)
            {
                queue2.dequeue();
                time2=time2+arr[index2][1];

            }
            if(queue2.length()- queue1.length()>=2)
            {
                Integer item= queue2.leaveQueue();
                queue1.enqueue(item);


            }
            else if(queue1.length()- queue2.length()>=2)
            {
                Integer item= queue1.leaveQueue();
                queue2.enqueue(item);

            }
            while(i<x && arr[i][0]==time3)
            {
                if(queue2.length()>= queue1.length())
                {
                    queue1.enqueue(i++);
                }
                else
                    queue2.enqueue(i++);
            }

            System.out.println("Time2 is "+time2);
           System.out.println("Time1 is "+time1);

        }
         
        System.out.println(time1+" "+ time2);


    }
}
