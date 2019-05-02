//referenced from: https://www.programiz.com/dsa/kruskal-algorithm
#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>
#include <fstream>
using namespace std;
#define edge pair<int,int>
class Graph {
private:
    vector<pair<int, edge>> G; 
    vector<pair<int, edge>> T; 
    int *parent;
    int V;
public:
    Graph(int V);
    void AddWeightedEdge(int u, int v, int w);
    int find_set(int i);
    void union_set(int u, int v);
    void kruskal();
    void print();
};
Graph::Graph(int V) {
    parent = new int[V];
    for (int i = 0; i < V; i++){parent[i] = i;}
    G.clear();
    T.clear();
}
void Graph::AddWeightedEdge(int u, int v, int w) {G.push_back(make_pair(w, edge(u, v)));}
int Graph::find_set(int i) 
{
    if (i == parent[i]){return i;}
    else{return find_set(parent[i]);}
}
void Graph::union_set(int u, int v) {
    parent[u] = parent[v];
}
void Graph::kruskal() {
    int i, node1, node2;
    sort(G.begin(), G.end()); 
    for (i = 0; i < G.size(); i++) {
        node1 = find_set(G[i].second.first);
        node2 = find_set(G[i].second.second);
        if (node1 != node2) {
            T.push_back(G[i]); 
            union_set(node1, node2);
        }
    }
}
void Graph::print() {
    int sum=0;
    for (int i = 0; i < T.size(); i++) {
        sum+=T[i].first;
    }
    cout << sum;
}
int main() {
    Graph g(500);
    int sum = 0;
    int x;
    ifstream inFile;
    inFile.open("test.txt");
    int count=0;
    int arr[]={0,0,0};
    while (inFile >> x) 
    {
       arr[count]=x;
       count++;
       if(count%3==0)
       {
         g.AddWeightedEdge(arr[0], arr[1], arr[2]);
         arr[0]=0;
         arr[1]=0;
         arr[2]=0;
         count=0;
       }
    }
    g.kruskal();
    g.print();
    return 0;
}
//referenced from: https://www.programiz.com/dsa/kruskal-algorithm