import java.util.Scanner;

public class DishWasher {
    public static void main(String[] args) {
        int n, x,count=0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        int timePeriod[] = new int[x];

        for (int i = 0; i < x; i++) {
            timePeriod[i] = scanner.nextInt();
        }
        int maxNum = n * x;
        int[][] data = new int[maxNum][3];
        for (int i = 0; i < maxNum; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = scanner.nextInt();

                if (data[i][0] == 0) {
                    break;
                }
            }
        }
        int time = data[0][1];
        StackADT<Integer> dirtyStack = new AStack<>(maxNum);
        StackADT<Integer> cleanStack = new AStack<>(maxNum);
        StackADT<Integer> finisher= new AStack<>(x);

        /*StackADT<Integer> dirtyStack = new LStack<>();
        StackADT<Integer> cleanStack = new LStack<>();
        StackADT<Integer> finisher= new LStack<>();*/
        /*Integer [] dish=new Integer[maxNum];
        StackADT<Integer> dirtyStack = new AStack<>(dish,1);
        StackADT<Integer> cleanStack = new AStack<>(dish,-1);
        StackADT<Integer> finisher= new AStack<>(x);*/

        dirtyStack.push(0);
        for (int i = 1; i < maxNum; ) {
            if (dirtyStack.length() != 0) {

                int index = dirtyStack.pop();
                if (time < data[index][1])
                    time = data[index][1];
                //System.out.println("Time "+time);

                time += timePeriod[data[index][2] - 1];
                while (data[i][0] != 0 && data[i][1] < time) {

                    dirtyStack.push(i++);

                }

                if(data[index][2]==x)
                {
                    finisher.push(data[index][0]);
                    count++;
                }
                cleanStack.push(time - 1);


            } else {
                if (data[i][0] != 0)
                    dirtyStack.push(i++);
            }
            if (data[i][0] == 0 && dirtyStack.length() == 0)
                break;
        }
        System.out.println(cleanStack.topValue());

        int length = cleanStack.length();
        StackADT<Integer> temp=new AStack(length);
        for(int i=0;i<length;i++) {
            temp.push((Integer) cleanStack.pop());
        }

        for (int i = 0; i < length - 1; i++) {
            Integer t = temp.pop();
            System.out.print(t);
            System.out.print(",");

        }

        System.out.println(temp.pop());
        if(count==x)
            System.out.println("Y");
        else
            System.out.println("N");
        int finisherLength=finisher.length();
        for(int i=0;i<finisherLength-1 ;i++)
            {
            Integer t = finisher.pop();
            System.out.print(t);
            System.out.print(",");

        }

        System.out.println(finisher.pop());


    }
}



