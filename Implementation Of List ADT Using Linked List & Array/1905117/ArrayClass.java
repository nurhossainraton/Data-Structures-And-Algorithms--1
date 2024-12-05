public class ArrayClass <T> implements List<T>  {
   private int initialSize;
   private int maxSize,listSize,currentPos;
   private Object a[];
   ArrayClass()
   {
      this.a=new Object[1];
      this.initialSize=1;
      this. maxSize=1;
      this.listSize=0;
      this. currentPos=0;

   }
   ArrayClass(T array[],int k,int x)
   {

      this.maxSize=x;
      this.initialSize=x;
      this.listSize=k;
      this.currentPos=0;
      this.a=new Object[maxSize];
    //  a= (T[]) new Object[size];
      for(int i=0;i<k;i++)
      {
         a[i]=array[i];
      }
   }
   public void clear()
   {
      listSize=0;
      currentPos=0;
      this.a=new Object[maxSize];

   }
   public void insert(T b)
   {
      if(listSize==maxSize)
      {
         Object temp[]=a;
         maxSize+=initialSize;
         a=new Object[maxSize];
         for(int i=0;i<listSize;i++)
         {
            a[i]=temp[i];
         }

      }
      for(int i=listSize;i>currentPos;i--)
      {
         a[i]=a[i-1];
      }
      a[currentPos]=b;
      listSize++;
   }
   public void append(T b)
   {
      if(listSize==maxSize)
      {
         if(listSize==maxSize)
         {
            Object temp[]=a;
            maxSize+=initialSize;
            a=new Object[maxSize];
            for(int i=0;i<listSize;i++)
            {
               a[i]=temp[i];
            }

         }
      }
      a[listSize++]=b;
   }
   public T remove()
   {
      Object element=a[currentPos];
      for(int i=currentPos;i<listSize-1;i++)
      {
         a[i]=a[i+1];
      }
      listSize--;
      return (T) element;
   }
   public void moveToStart()
   {
      currentPos=0;
   }
   public void moveToEnd()
   {
      currentPos=listSize-1;
   }
   public void prev()
   {
      if(currentPos!=0)
         currentPos--;
   }
   public void next()
   {
      if(currentPos<listSize)
         currentPos++;
   }
   public int length()
   {
      return listSize;

   }
   public int currPos()
   {
      return currentPos;
   }
   public void moveToPos(int pos)
   {

      currentPos=pos;
   }
   public T getValue()
   {
     return (T) a[currentPos];
   }
   public int  Search(T b)
   {
      int isFound=-1;
      for(int i=0;i<listSize;i++)
      {
         if(a[i].equals(b))
            isFound=i;
      }
      return isFound;
   }



}
