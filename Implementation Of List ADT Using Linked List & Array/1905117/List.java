public interface List <T> {
    public void clear();
    public void insert(T b);
    public void append(T b);
    public T remove();
    public void moveToStart();
    public void moveToEnd();
    public void prev();
    public void next();
    public int length();
    public int currPos();
    public void moveToPos(int pos);
    public T getValue();
    public int  Search(T b);

}
