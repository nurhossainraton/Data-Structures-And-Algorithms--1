public class Link<T> {
    private T data;
    private Link<T> next;
    Link(T item, Link <T> nextval)
    {
        data=item;
        next=nextval;
    }
    Link(Link <T> nextval)
    {
        next=nextval;
    }
    Link<T> next()
    {
        return next;
    }
    Link <T> setNext(Link <T> nextval)
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
