class treeNode
{
  int value;
  double priority;
  treeNode lc;
  treeNode rc;
  int height;
  treeNode(int value)
  {
    this.height=0;
    this.value = value;
    this.priority = Math.random();
    this.lc = this.rc = null;
  }
}
class Treap
{
  public static int get_height(treeNode tn)
  {
    if(tn==null) return -1;
    else return tn.height;  
  }
  //rotatelc and rotaterc functions adapted from https://www.sanfoundry.com/java-program-implement-treap/
  public static treeNode rotatelc(treeNode tn)
  {
    treeNode R = tn.rc;
    treeNode X = tn.rc.lc;
    R.lc = tn;
    tn.rc = X;

    tn.height=Math.max(get_height(tn.lc),get_height(tn.rc))+1;
    R.height=Math.max(get_height(R.lc),tn.height)+1;
    return R;
  }
  public static treeNode rotaterc(treeNode tn)
  {
    treeNode L = tn.lc;
    treeNode Y = tn.lc.rc;
    L.rc = tn;
    tn.lc = Y;
    
    tn.height=Math.max(get_height(tn.lc),get_height(tn.rc))+1;
    L.height=Math.max(get_height(L.rc),tn.height)+1;
    return L;
  }
  public static treeNode insertNode(treeNode tn, int value)
  {
    if (tn == null) {
      return new treeNode(value);
    }
    if (value < tn.value)
    {
      tn.lc = insertNode(tn.lc, value);
      if (tn.lc != null){ 
        if(tn.lc.priority > tn.priority) {
        tn = rotaterc(tn);
        }
      }
    }
    else
    {
      tn.rc = insertNode(tn.rc, value);
      if (tn.rc != null){ 
        if(tn.rc.priority > tn.priority) {
        tn = rotatelc(tn);
        }
      }
    }
    return tn;
  }
}
class Main
{
  public static void main(String[] args)
  {
    for(int i=0;i<5;i++)
    {
      buildtreap();
    }
  }
  public static void buildtreap()
  {
    Treap treap=new Treap();
    treeNode root = null;
    for (int key=0;key<1000000;key++)
      root = treap.insertNode(root, key);

    // treap.printInorder(root);
    System.out.println("Details:");
    System.out.println("Root data, priority, height: "+root.value + "(" + root.priority + ")"+ "(" + root.height + ")");
    System.out.println("Root's lc child data, priority, height: "+root.lc.value + "(" + root.lc.priority + ")"+ "(" + root.lc.height + ")");  
    System.out.println("Root's rc child data, priority, height: "+root.rc.value + "(" + root.rc.priority + ")"+ "(" + root.rc.height + ")");    
    System.out.println("\n");
  }
}