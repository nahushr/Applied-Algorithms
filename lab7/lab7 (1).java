//final version

import java.util.Scanner;
import java.util.Random;
import java.io.*;
class treeNode
{
  treeNode parent;
  treeNode lc;
  treeNode rc;
  int value;
  int height;
  public treeNode(int n)
  {
 
        lc = null;
        rc = null;
        value = n;
        height = 0;
    }
}
class RBST
{
  treeNode root;
  public RBST()
  {
    root=null;
  }
  public int get_height(treeNode tn)
  {
    if(tn==null) return -1;
    else return tn.height;
  
  }
  public void insert(int element)
  {
    root=insert(root,element);
  }
 
   public treeNode insert(treeNode tn, int element)
  {
    if(tn==null) tn=new treeNode(element);
    
    else if(element<tn.value)
    {
      tn.lc=insert(tn.lc,element);
     
      tn=rotate(tn,element,1);

    }
    else if(element>tn.value)
    {
      tn.rc=insert(tn.rc, element);
    
      tn=rotate(tn,element,2);

    }
    else;
    tn.height=Math.max(get_height(tn.lc), get_height(tn.rc))+1;
    return tn;
  }

  public treeNode rotate_left(treeNode tn)
  {
    treeNode node=tn.lc;
    tn.lc=node.rc;
    node.rc=tn;

    tn.height=Math.max(get_height(tn.lc),get_height(tn.rc))+1;
    node.height=Math.max(get_height(node.lc),tn.height)+1;
    return node;
  }

  public treeNode rotate_right(treeNode tn)
  {
    treeNode node=tn.rc;
    tn.rc=node.lc;
    node.lc=tn;

    tn.height=Math.max(get_height(tn.lc),get_height(tn.rc))+1;
    node.height=Math.max(get_height(node.rc),tn.height)+1;
    return node;
  }

  private treeNode left_child_rotate(treeNode tn)
  {
      tn.lc = rotate_right(tn.lc);
      return rotate_left(tn);
  }
 
  private treeNode right_child_rotate(treeNode tn)
  {
      tn.rc = rotate_left(tn.rc);
      return rotate_right(tn);
  }
  public boolean search(int val)
  {
      return search(root, val);
  }
  public boolean search(treeNode tn, int element)
  {
    boolean flag=false;
    while((tn!=null) && !flag)
    {
      int value=tn.value;
      if(element<value) tn=tn.lc;
      else if(element>value) tn=tn.rc;
      else
      {
        flag=true;
        break;
      }
      flag=search(tn, element);
    }
    return flag;
  }
  public void inorder(treeNode tn)
  {
    if(tn!=null)
    {
      inorder(tn.lc);
      System.out.print(tn.value+ " ");
      inorder(tn.rc);
    }
  } 
  public void preorder(treeNode r)
  {
        if (r != null)
        {
            System.out.print(r.value + " ");
            preorder(r.lc);
            preorder(r.rc);
        }
  }
 
  public treeNode rotate(treeNode tn, int element, int incoming)
  {
    // if(tn==null)return tn;
    
    // if(tn==root)return;
    if(incoming==1)
    {
     if(get_height(tn.lc)-get_height(tn.rc)==2)
      {
        if(element<tn.lc.value)
        {
          tn=rotate_left(tn);
        }
        else
        {
          tn=left_child_rotate(tn);
        }
      }
    }
    else
    {
       if(get_height(tn.rc)-get_height(tn.lc)==2)
      {
        if(element>tn.rc.value)
        {
          tn=rotate_right(tn);
        }
        else
        {
          tn=right_child_rotate(tn);
        }
      }
    }
    return tn;
  }

}

class Main {
  public static void main(String[] args) {
    int counter=0;
    String str;
    File file;
    RBST object=new RBST();
    try
    {
          file=new File("test.txt");
          BufferedReader br=new BufferedReader(new FileReader(file));
          while((str=br.readLine())!=null)
          {
            if(counter!=0)
            {
              // arr[counter-1]=Integer.parseInt(str);
              object.insert(Integer.parseInt(str));  
            }
            counter++;
          }
    }
    catch(Exception e)
    {
      //file not found exception
      System.out.print(e);
    }   
    for(int i=0;i<100;i++)
    {
      object.insert(i);
    }
    for(int i=0;i<100;i=i+10)
    {
      boolean result=object.search(i);
      System.out.println("Search on value: "+i+" "+result);
    }
    System.out.println("Search on value: 1000 "+object.search(1000));
    System.out.println("In order traversal: ");
    object.inorder(object.root);
    System.out.println();
    // System.out.println("Pre order traversal: ");
    // object.preorder(object.root);
    System.out.println("tree root: "+object.root.value);
    System.out.println("tree height: "+(object.root.height+1));

  }
}