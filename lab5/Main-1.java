import java.util.Scanner;
import java.io.*;
class BinaryHeap { 
    int[] Heap; 
    int heap_size; 
    int _size; 
    public BinaryHeap(int size) 
    { 
        this._size = size; 
        this.heap_size = 0; 
        Heap = new int[this._size + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    }
    private void swap(int index1, int index2) 
    { 
        int temp; 
        temp = Heap[index1]; 
        Heap[index1] = Heap[index2]; 
        Heap[index2] = temp; 
    } 
    private void shiftdown(int index) 
    { 
      int left=2*index;
      int right=left+1;
      if (index>heap_size) 
      {
          return;
      } 
      if (left<=_size && Heap[index] < Heap[left])
      {
              swap(index, left); 
              shiftdown(left); 
      } 
      if(right<=_size && Heap[index] < Heap[right]) 
      { 
                swap(index, right); 
                shiftdown(right); 
      } 
    } 
    //insert function code refered from: https://www.geeksforgeeks.org/max-heap-in-java/
    public void insert(int value) 
    { 
        //making the max-heap tree
        ++heap_size;
        Heap[heap_size] = value; 
        int current_size = heap_size; 
        while (Heap[current] > Heap[current_size/2]) 
        { 
            swap(current, current_size/2); 
            current = current_size/2; 
        } 
    } 
    //insert function code refered from: https://www.geeksforgeeks.org/max-heap-in-java/
    public int delmax() 
    { 
        int value = Heap[1]; 
        size--;
        Heap[1] = Heap[size]; 
        shiftdown(1); 
        return value; 
    } 
}
public class Main
{
    public static void main(String args[])
    {
        BinaryHeap object=new BinaryHeap(102);
        String str;
        File file;
        int counter=0;
        try
        {
          file=new File("input.txt");
          BufferedReader br=new BufferedReader(new FileReader(file));
          while((str=br.readLine())!=null)
          {
            if(counter!=0)
            {
              object.insert(Integer.parseInt(str));
            }
            counter++;
          }
        }
        
        catch(Exception e)
        {
          //file not found exception
          e.printStackTrace();
        }       
        try
        {
            FileWriter fileWriter = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0;i<20;i++)
            {
              printWriter.print(object.delmax()+"\n");
            }
            printWriter.close();
        }
        catch(Exception e)
        {
          //IOException
          e.printStackTrace();
        }
  }
}
