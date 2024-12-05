public class LStack<T> implements StackADT<T> {
    private Item<T> top;
    private int size;
    public LStack()
    {
        top=null;
        size=0;
    }
    public LStack(int size)
    {
        top=null;
        size=0;
    }
    @Override
    public void clear() {
       top=null;
       size=0;
    }

    @Override
    public void push(T item) {
    top=new Item<>(item,top);

    size++;

    }

    @Override
    public T pop() {
        T item=top.element();
        top=top.next();
        size--;
        return item;
    }

    @Override
    public int length() {

        return size;
    }

    @Override
    public T topValue() {

        return top.element();
    }

    @Override
    public void setDirection(int a) {

    }
}
