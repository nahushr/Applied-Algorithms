import java.io.*;
class treeNode
{
  treeNode parent;
  treeNode lc;
  treeNode rc;
  int value;
}
class BST
{
  int size;
  treeNode root;
  int c=0;
  public BST()
  {
    root=new treeNode();
    size=0;
  }  
  public void inOrder(treeNode tn)
  {
    if(tn==null)
    {
      return;
    }
    inOrder(tn.lc);
    if(tn.value!=0)
    {
      System.out.println(tn.value);
    }
    inOrder(tn.rc);
  }
  public boolean search(treeNode tn, int val)
  {
    if(tn==null)
    {
      return false;
    }
    if(tn.value==val)
    {
      return true;
    }
    // go the left
    else if(tn.value>val)
    {
      return search(tn.lc, val);
    }
    //go to the right subtree
    else 
    {
      return search(tn.rc, val);
    }
  }
  public void insert(treeNode tn, int val)
  {
    //  System.out.println(c++);
      if(size==0)
      {
        root.value=val;
      }
      if(tn.value>=val)
      {
        if(tn.lc==null)
        {
          treeNode nlc=new treeNode();
          nlc.value=val;
          nlc.parent=tn;
          tn.lc=nlc;
        }
        else
        {
          insert(tn.lc, val);
        }
      }
      if(tn.value<=val)
      {
        if(tn.rc==null)
        {
          treeNode nrc=new treeNode();
          nrc.value=val;
          nrc.parent=tn;
          tn.rc=nrc;
        }
        else
        {
          insert(tn.rc, val);
        }
      }
      else
      {
        //do nothing
      }
      
  }
}
 
class Main {
  public static void main(String[] args) {
    //reading files and inserting into the bst
    int arr[]=new int[1000];
    BST bst=new BST();
    treeNode tn=new treeNode();
    int counter=0;
    String str;
    File file;
    try
    {
          file=new File("lab6_test_BST.txt");
          BufferedReader br=new BufferedReader(new FileReader(file));
          while((str=br.readLine())!=null)
          {
            if(counter!=0)
            {
              arr[counter-1]=Integer.parseInt(str);
              bst.insert(tn, Integer.parseInt(str));  
            }
            counter++;
          }
    }
    catch(Exception e)
    {
          //file not found exception
      System.out.print(e);
    }   
  // at this point all the elements have been inserted in the tree and now we perform our operations::
  System.out.println("Total number of elements in the tree are:"+ (counter-1));
  System.out.println("Search result for 100: "+bst.search(tn,100));
  System.out.println("Inoder traversal method");
  bst.inOrder(tn);
 
  }
}
