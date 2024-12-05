#include <iostream>
#define INF 1000000000
using namespace std;

int City_Cost(int **visitCost,int **dp_table,int n,int index,int bitmask)
{
    if(dp_table[index][bitmask] != -1)
    {
        return dp_table[index][bitmask];

    }
    else if(bitmask == (1<<n)-1)
    {
        int temp=0;
        for (int j=0; j<n; j++)
        {
            temp+=visitCost[index][j];
        }
        dp_table[index][bitmask]=temp;
        return temp;
    }
    else
    {
        int value=INF;
        for (int i=0; i<n; i++)
        {
            int newVal=0;
            for (int j=0; j<n; j++)
            {
                if(bitmask & (1<<j))
                {
                    newVal+=visitCost[index][j];
                }
            }
            if(!(bitmask & (1<<i)))
            {
                newVal+=City_Cost(visitCost,dp_table,n,i,(bitmask | 1<<i));
                value=min(value,newVal);

            }

        }
        dp_table[index][bitmask]=value;
        return value;
    }

}
int minimum_cost(int **visitCost,int **dp_table,int n)
{
    int val=INF;
    for (int i=0; i<n; i++)
    {
        int tempValue=City_Cost(visitCost,dp_table,n,i,(1<<i));
        val=min(val,tempValue);

    }
    return val;
}
int main()
{
    int n;
    cin>>n;
    int **visitCost=new int* [n];
    for(int i=0; i<n ; i++)
    {
        visitCost[i]=new int[n];
    }

    for(int i=0; i<n; i++)
    {
        for (int j=0; j<n; j++)
        {
            cin>>visitCost[i][j];
        }
    }
    int **dp_table = new int*[n];

    for(int i=0; i<n ; i++)
    {
        dp_table[i]=new int[1<<n];
    }
    for(int i=0; i<n; i++)
    {
        for (int j=0; j<(1<<n); j++)
        {
            dp_table[i][j]=-1;
        }
    }
    int value=minimum_cost(visitCost,dp_table,n);
    cout<<value<<endl;

    for(int i=0; i<n ; i++)
    {
        delete visitCost[i];
    }

    delete visitCost;

    for(int i=0; i<n ; i++)
    {
        delete dp_table[i];
    }

    delete dp_table;

}
