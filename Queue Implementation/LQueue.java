public class LQueue<T> implements QueueADT<T> {
    private Link <T> front;
    private Link <T> rear;
    private int size;
    public LQueue()
    {

    }
    public LQueue(int size)
    {
        init();
    }
    public void init()
    {

        front=rear=new Link<>(null);
        size=0;
    }
    @Override
    public void clear() {
       init();
    }

    @Override
    public void enqueue(T item) {
        if(rear==null) {
             rear = rear.setNext(new Link<>(item, null));
             front=rear;
            size++;
        }

         else {
            rear = rear.setNext(new Link<>(item, null));
            size++;
        }


    }

    @Override
    public T dequeue() {

        T it=front.next().element();
        front.setNext(front.next().next());
        if(front==null) front=rear;
        size--;
        return it;
    }

    @Override
    public T frontValue() {
        return front.next().element();
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T rearValue() {
        return rear.element();
    }

    @Override
    public T leaveQueue() {
        Link temp=new Link(null);
        temp=front;
        for(int i=0;i<size-1;i++)
        {
            temp=temp.next();
        }
        rear=temp;
        T item= (T) temp.next().element();
        rear.setNext(null);
        return item;
    }
}
