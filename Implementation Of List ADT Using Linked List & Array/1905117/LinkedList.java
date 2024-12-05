import org.w3c.dom.Node;

import java.io.*;
import java.util.Arrays;

public class LinkedList<T> implements List<T>  {
    private Item<T> head;
    private Item<T> tail;
    private Item<T> currentNode;
    int currentPos,count;
    int Size;

    LinkedList(int size) {
        this();}
        LinkedList( ){
            head=tail=currentNode=new Item<>(null);
            count=0;


        }
    LinkedList(T[] list)
    {
       head=tail=currentNode=new Item<>(null);
       count=0;
    }


    @Override
    public void clear() {
        head.setNext(null);
        head=tail=currentNode=new Item<T>(null);
        count=0;
    }

    @Override
    public void insert(T b) {
      currentNode.setNext(new Item<T>(b,currentNode.next()));
      if(tail==currentNode)
          tail=currentNode.next();
      count++;
    }

    @Override
    public void append(T b) {

        tail=tail.setNext(new Item(b,null));
        count++;
    }

    @Override
    public T remove() {
       
        if(currentNode.next()==null) return null;
        T a=currentNode.next().element();
        if(tail==currentNode.next())
            tail=currentNode;
        currentNode.setNext(currentNode.next().next());
        count--;
        return a;
    }

    @Override
    public void moveToStart() {
        currentNode=head;
    }

    @Override
    public void moveToEnd() {
        Item <T> temp = head;
        while(temp.next()!=tail)
        {
            temp=temp.next();
        }
      currentNode=temp;
    }

    @Override
    public void prev() {
        if(currentNode==head)
            return ;
        Item <T> temp = head;
        while(temp.next()!=currentNode)
        {
            temp=temp.next();
        }
        currentNode=temp;
    }

    @Override
    public void next() {
      if(currentNode!=null)
          currentNode=currentNode.next();
    }

    @Override
    public int length() {

        return count;
    }

    @Override
    public int currPos() {
        Item <T> temp=head;
        int i;
        for( i=0;temp!=currentNode;i++)
        {
            temp=temp.next();
        }
        return i;

    }

    @Override
    public void moveToPos(int pos) {
       currentNode=head;
       for(int i=0;i<pos;i++)
       {
           currentNode=currentNode.next();
       }
    }

    @Override
    public T getValue() {
        if(currentNode!=null)
            return currentNode.next().element();
        else
        return null;
    }

    @Override
    public int Search(T b) {
        Item <T> temp=head;
        int i;
        for( i=0;temp!=null;i++)
        {
            if(temp.element()==(b))
            {
                return i-1;

            }
            else
            temp=temp.next();
        }
       return -1;
    }

}

