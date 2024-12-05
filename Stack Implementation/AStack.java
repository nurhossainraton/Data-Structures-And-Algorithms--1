public class AStack<T> implements StackADT<T> {
    private int defaultValue= 10;
    private int maxSize=defaultValue;
    public int top;
    public int direction=1;
    private T [] listarray;
    private int currPos;
    AStack(int size)
    {

        this.maxSize=size;
        top=0;
        this.listarray= (T[]) new Object[maxSize];

        if(direction==1)
        {
            top=0;

        }
        else
        {
            top=maxSize-1;
        }
    }
    AStack(T array[],int direction)
    {
       // maxSize= array.length;

        if(direction==1)
        {
            top=0;

        }
        else
        {
            top=maxSize-1;
        }
        this.listarray= (T[]) new Object[maxSize];
        for(int i=0;i<array.length;i++)
        {
            listarray[i]=array[i];
        }
    }
    @Override
    public void clear() {
        if(direction==1)
          top=0;
        else
            top=maxSize-1;
    }

    @Override
    public void push(T item) {
        if (direction == 1) {
            if (top == maxSize) {
                Object temp[] = listarray;
                maxSize += defaultValue;
                listarray = (T[]) new Object[maxSize];
                for (int i = 0; i < top; i++) {
                    listarray[i] = (T) temp[i];
                }
            } else
                listarray[top++] = item;
        } else {
            listarray[top--] =item;
        }
    }

    @Override
    public T pop() {
        if(direction==1)
        return listarray[--top];
        else
            return listarray[top++];
    }

    @Override
    public int length() {
        if(direction==-1)
        return maxSize-top;
        return top;
    }

    @Override
    public T topValue() {
        if(direction==1)
        return listarray[top-1];
        else
            return listarray[top];
    }

    @Override
    public void setDirection(int direction) {
        if (listarray.length == 0) {
            this.direction = direction;
        }
    }
}
