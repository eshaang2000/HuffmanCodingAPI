import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandle {

    public static AVLTree getFromFile(String path) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(path));
        ArrayList<String> words = new ArrayList<String>();
        AVLTree pbj = new AVLTree();
//        HeapNode heap = new HeapNode();
        while(s.hasNext ())
        {
            String token = s.next ();
//            System.out.println(token);
            if(isAWord(token))
            {
//                System.out.println(token);
                if(token.contains ("."))
                {
                    token =  token.replace (".","");
                }
                if(token.contains (","))
                {
                    token = token.replace (",", "");
                }

                AVLTree tree= new AVLTree();
//                System.out.println(token);
                pbj.root=pbj.insert(pbj.root, token);
//                tree.preOrder(tree.root);
            }

        }
//        pbj.preOrder(pbj.root);
        for(int i=0;i<words.size();i++){
            System.out.println(words.get(i));
        }
        return pbj;
    }
    private static boolean isAWord(String token)
    {
        return true;
        //check if the token is a word
    }

}