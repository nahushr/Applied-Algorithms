import java.util.*;
import java.io.*; 
import java.util.LinkedList; 
import java.util.Queue; 

class GraphNode
{
  int id;
  List<Integer> neighbors = new ArrayList<Integer>();
  boolean visited;
  int distance;
  GraphNode()
  {

  }

  GraphNode(int id)
  {
    this.id=id;
    this.visited=false;
  }
  public void add_neighbor(int node_id)
  {
    this.neighbors.add(node_id);
  }
  
  public List<Integer> get_neighbors()
  {
    return this.neighbors;
  }
  public GraphNode[] build_graph(String input_file)
  {
    // List<Object> graph = new ArrayList<Object>();
    GraphNode[] graph=new GraphNode[50];
    for(int i=0; i<50; i++)
    {
      // graph.add(new GraphNode(i));
      graph[i]=new GraphNode(i);
    }

    File file = new File(input_file); 
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(file)); 
      String st; 
      while ((st = br.readLine()) != null) 
      {
        String[] words=st.split(" ");
        graph[Integer.parseInt(words[0])].add_neighbor(Integer.parseInt(words[1]));
      } 
    }
    catch(Exception e)
    {
      System.out.println(e);
    }

    return graph;
  }
  public int bfs(GraphNode[] graph, int source_id, int destination_id)
  {
    if(source_id==destination_id)
    {
      return 0;
    }
    else
    {
      //set al graph nodes visited field to 0
      for(int i=0; i<50; i++)
      {
        graph[i].visited=false;
      }

      graph[source_id].visited=true;
      graph[source_id].distance=0;
      Queue<Integer> q = new LinkedList<>(); 
      q.add(source_id);

      while(!q.isEmpty())
      {
        // System.out.println(q.size());
        int node_id=q.remove();
        int cur_distance=graph[node_id].distance;

        List<Integer> n = new ArrayList<Integer>();
        n=graph[node_id].get_neighbors();
        // System.out.println(node_id+"->"+n);
        for (int i = 0; i < n.size(); i++) 
        {
            if(n.get(i)==destination_id)
            {
              return cur_distance+1;
            }
            if(graph[n.get(i)].visited==false)
            {
              graph[n.get(i)].visited=true;
              graph[n.get(i)].distance=cur_distance+1;
              q.add(n.get(i));
            }
  
        }
      }
      // return graph[destination_id].distance;
      return -1;
    }
  }
}

class Main {
  public static void main(String[] args) {
    GraphNode[] graph=new GraphNode[50];
    GraphNode obj=new GraphNode();
    graph=obj.build_graph("lab10_test_bfs.txt");
    
    System.out.println("distance between 15 and 38 is " +obj.bfs(graph, 15, 38));
    System.out.println("distance between 23 and 11 is " +obj.bfs(graph, 23, 11));
    System.out.println("distance between 39 and 4 is " +obj.bfs(graph, 39, 4));

   
  }
}