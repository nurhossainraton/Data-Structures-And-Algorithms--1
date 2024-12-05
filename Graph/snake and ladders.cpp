#include <iostream>
#include <vector>
#include <list>
#include<fstream>
#include<algorithm>
using namespace std;
vector<int> *adj;
ifstream myfile("Input.txt");
ofstream oFile("Output.txt");
void replaceEdge(vector<int> *adj, int start, int newEdge,int n)
{

    for (int i = start - 1; i >= start - n && i > 0; --i)
    {
        replace(adj[i].begin(), adj[i].end(), start, newEdge);
    }
}
void BFS(vector<int> adj[],int parent[],int level[])
{
    list <int> queue;
    queue.push_back(1);
    vector<int>:: iterator itr;
    level[1]=0;
    parent[1]=0;

    while(!queue.empty())
    {
        int newVertex=queue.front();
        itr = adj[newVertex].begin();
        while(itr !=adj[newVertex].end())
        {
            if (level[*itr] == -1)
            {
                level[*itr] = level[newVertex] + 1;
                parent[*itr] = newVertex;
                queue.push_back(*itr);
            }
            ++itr;
        }
        queue.pop_front();
    }

}
void printSteps(int parent[],int destination)
{
    if(parent[destination]== 0)
    {
        oFile<<destination<<"->";
    }
    else
    {
        printSteps(parent, parent[destination]);
        oFile<<destination<<"->";
    }
}


int main()
{

    int t,n,x,l,s;
    if(myfile.is_open())
    {

        if(!myfile.eof())
        {
            myfile>>t;

            while(t--)
            {
                myfile>>n;
                myfile>>x;
                //cout<<x;
                myfile>>l;
                adj=new vector<int>[x+1];
                for(int i=1; i<=x; i++)
                {
                    for(int j=i+1; j<=i+n; j++)
                    {
                        adj[i].push_back(j);
                    }
                }
                vector<int> LStart;
                for(int i=0; i<l; i++)
                {

                    int startEdge,endEdge;

                    myfile>>startEdge;
                    LStart.push_back(startEdge);
                    myfile>>endEdge;

                    replaceEdge(adj,startEdge,endEdge,n);
                    adj[startEdge].clear();

                }
                myfile>>s;
                vector<int> SStart;
                for(int i=0; i<s; i++)
                {
                    int startEdge,endEdge;
                    myfile>>startEdge;
                    SStart.push_back(startEdge);
                    myfile>>endEdge;
                    replaceEdge(adj,startEdge,endEdge,n);
                    adj[startEdge].clear();

                }
                int parent[x + 1];
                int level [x + 1];
                for (int i = 1; i <= x; i++)
                {
                    parent[i] = -1;
                    level[i] = -1;
                    for(int j=0; j<LStart.size(); j++)
                    {
                        if(LStart[j]==i)
                        {
                            parent[i]=0;
                            break;
                        }
                    }
                    for(int j=0; j<SStart.size(); j++)
                    {
                        if(SStart[j]==i)
                        {
                            parent[i]=0;
                            break;
                        }
                    }
                }

                BFS(adj,parent,level);
                // cout<<10;
                oFile<<level[x]<<endl;
                if(parent[x]!=-1)
                    printSteps(parent,x);
                else
                {
                    oFile<<"No Solution";
                }
                oFile<<" "<<endl;
                int count=0;
                for(int i=1; i<=x; i++)
                {
                    if(parent[i]==-1)
                    {
                        oFile<<i<<" ";
                        count++;
                    }
                }
                if(count==0)
                {
                    oFile<<"All Reachable"<<endl;
                }
            }
        }
    }



}

