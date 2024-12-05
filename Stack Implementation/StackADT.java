public interface StackADT <T>  {
   public void clear();
   public void push( T item);
   public T pop();
   public int length();
   public T topValue();
   public void setDirection(int x);

}
