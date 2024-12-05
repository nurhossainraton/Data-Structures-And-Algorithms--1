public interface QueueADT<T> {
        public void clear();
        public void enqueue(T item);
        public T dequeue();
        public T frontValue();
        public int length();
        public T rearValue();
        public T leaveQueue();


}
