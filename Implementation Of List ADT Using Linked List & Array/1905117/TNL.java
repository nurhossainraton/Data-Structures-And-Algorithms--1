import java.util.Scanner;

public class TNL {
    public static void task1(List RS,List BS,List TS)
    {

        int rPos=RS.currPos();

        RS.moveToStart();
        for(int i = 0; i<RS.length()-1; i++) {
            System.out.print(RS.getValue());
            int temp=(int) RS.getValue();
            RS.next();
            while(temp!=(int)RS.getValue()){
                System.out.print(",");
                temp++;
            }
        }
        System.out.println(RS.getValue());
        RS.moveToPos(rPos);

        int bPos=BS.currPos();
        BS.moveToStart();
        for(int i = 0; i<BS.length()-1; i++) {
            System.out.print(BS.getValue());
            int temp=(int) BS.getValue();
            BS.next();
            while(temp!=(int)BS.getValue()){
                System.out.print(",");
                temp++;
            }
        }
        System.out.println(BS.getValue());
        BS.moveToPos(bPos);

        int tPos=TS.currPos();

        TS.moveToStart();
        for(int i = 0; i<TS.length()-1; i++) {
            System.out.print(TS.getValue());
            int temp=(int) TS.getValue();
            TS.next();
            while(temp!=(int)TS.getValue()){
                System.out.print(",");
                temp++;
            }
        }
        System.out.println(TS.getValue());
        TS.moveToPos(tPos);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rs = scanner.nextInt();
       /* List RS = new ArrayClass<>();
        List BS = new ArrayClass<>();
        List TS = new ArrayClass<>();*/
        List RS=new LinkedList<>(rs);
        List BS=new LinkedList<>(rs);
        List TS=new LinkedList<>(rs);
        for (int i = 0; i < rs; i++) {
            RS.append(i);
        }

        int bs=scanner.nextInt();

        for(int i=0;i<bs;i++)
        {
            BS.append(scanner.nextInt());
        }

        int ts=scanner.nextInt();

        for(int i=0;i<ts;i++)
        {
          TS.append(scanner.nextInt());
        }

        int a=scanner.nextInt();
        if(a==1)
        {
            task1(RS,BS,TS);
        }

    }

}
