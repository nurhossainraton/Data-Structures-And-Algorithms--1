public class BinarySearchTree{
    class Node{
        int value;
        Node left,right;
        public Node(int item)
        {
            value=item;
            right=left=null;
        }
    }
    Node root;
    BinarySearchTree()
    {
        root=null;

    }
    public void insert(int item)
    {
        root=insertNode(root,item);
    }

    private Node insertNode(Node root, int item) {
        if(root == null)
        {
            root=new Node(item);
            return root;
        }
        if(item< root.value)
        {
            root.left=insertNode(root.left,item);
        }
        else if(item>root.value)
        {
            root.right=insertNode(root.right,item);
        }
        return root;

    }
    public void inorder()
    {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if(root!=null)
        {
            inorderTraversal(root.left);
            System.out.print(root.value+" ");
            inorderTraversal(root.right);
        }
    }
    public void preOrder()
    {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root) {
        if(root!=null)
        {
            System.out.print(root.value+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    public void postOrder()
    {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if(root!=null)
        {

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value+" ");
        }
    }

    public boolean delete(int key)
    {
        boolean s=findhelp(root,key);
        if(s) {
            root = deleteNode(root, key);
            return true;
        }
        else
            return false;
    }

    private Node deleteNode(Node root, int key) {
        if(root==null)
            return root;
        if(key < root.value)
        {
           root.left= deleteNode(root.left,key);
        }
        else if(key> root.value)
        {
            root.right=deleteNode(root.right,key);
        }

        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            root.value=maximumValue(root.left);
            root.left=deleteNode(root.left,root.value);
        }
        return root;
    }

    private int maximumValue(Node root) {
          int max= root.value;
          while(root.right !=null)
          {
              max=root.right.value;
              root=root.right;

          }
          return max;
    }
    public void Find(int item)
    {
        if(findhelp(root,item))
            System.out.println("True");
        else
            System.out.println("False");

    }

    private boolean findhelp(Node root, int item) {
        if(root==null)
            return false;

        while(root.value!=item)
        {
            if(root.value>item)
            {
                 return findhelp(root.left,item);
            }
            else return findhelp(root.right,item);
        }
        return true;
    }
    public void print()
    {
        printHelp(root);
    }
    public void printHelp(Node root) {
        if (root == null)
            return;
        else {
            if (root.left == null && root.right == null) {
                System.out.print(root.value);
            } else {
                System.out.print(root.value);
                System.out.print("(");
                printHelp(root.left);
                System.out.print(")");
                System.out.print("(");
                printHelp(root.right);
                System.out.print(")");
            }

        }
    }

}
