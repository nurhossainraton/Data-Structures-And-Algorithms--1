public class Item <T> {
    private T data;
    private Item<T> next;
    Item(T item,Item <T> nextval)
    {
        data=item;
        next=nextval;
    }
    Item(Item <T> nextval)
    {
        next=nextval;
    }
    Item<T> next()
    {
        return next;
    }
    Item <T> setNext(Item <T> nextval)
    {
        next=nextval;
        return next;
    }
    T element()
    {
        return data;
    }
    T setElement(T item)
    {
        data =item;
        return  data;
    }
}
