import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class main {
    private static final String Inputfile = "InputFile.txt";

    public static void fileReader(BinarySearchTree bst) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(Inputfile));
        String str;
        while (true) {
            str = br.readLine();
            if (str == null) {
                break;
            }
            String data[] = str.split(" ");
            int index = 0, value = 1;
            if (data[index].equalsIgnoreCase("I")) {
                Integer temp = Integer.parseInt(data[value]);
                bst.insert(temp);
                bst.print();
                System.out.println(" ");


            } else if (data[index].equalsIgnoreCase("D")) {
                Integer temp = Integer.parseInt(data[value]);
                boolean del = bst.delete(temp);
                if (del) {
                    bst.print();
                    System.out.println(" ");
                }
                else
                    System.out.println("Invalid Operation");


            }


             else if (data[index].equalsIgnoreCase("F")) {
                Integer temp = Integer.parseInt(data[value]);
                bst.Find(temp);


            } else if (data[index].equalsIgnoreCase("T")) {

                if (data[value].equalsIgnoreCase("In")) {

                    bst.inorder();
                    System.out.println();

                }
                if (data[value].equalsIgnoreCase("Pre")) {

                    bst.preOrder();
                    System.out.println();

                }
                if (data[value].equalsIgnoreCase("Post")) {

                    bst.postOrder();
                    System.out.println();

                }


            }


        }
        br.close();

    }

    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        try{
            fileReader(bst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

