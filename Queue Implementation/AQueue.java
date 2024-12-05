public class AQueue<T> implements QueueADT <T> {
    public static final int  defaultsize=10;
    private  int maxSize;
    private int front;
    private int rear;
    private T[] listArray;
    AQueue()
    {

    }
    AQueue(int size)
    {
        maxSize=size+1;
        front=1;
        rear=0;
        listArray= (T[]) new Object[maxSize];

    }

    @Override
    public void clear() {
        front=1;
        rear=0;
    }

    @Override
    public void enqueue(T item) {
        if((rear+2)% maxSize==front)
        {
            expand();
        }
        else{
            rear=(rear+1)%maxSize;
            listArray[rear]=item;
        }

    }

    @Override
    public T dequeue() {
        T item=listArray[front];
        front=(front+1)% maxSize;
        return item;
    }

    @Override
    public T frontValue() {
        return listArray[front];
    }

    @Override
    public int length() {
        return ((rear+maxSize)-front+1)%maxSize;
    }

    @Override
    public T rearValue() {

        return listArray[rear];
    }

    @Override
    public T leaveQueue() {
        T item=listArray[rear];
        rear=(rear-1)% maxSize;
        return item;

    }
    public void expand()
    {
        maxSize*=2;
        Object temp[] = listArray;
        listArray = (T[]) new Object[maxSize];
        for(int i=0;i<rear;i++)
        {
            listArray[i]= (T) temp[i];
        }

    }
}
