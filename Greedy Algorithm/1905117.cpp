#include <iostream>
using namespace std;

void merge(int ara[],int start,int mid,int end)
{
    int LSize=mid-start+1;
    int RSize=end-mid;
    int LeftAra[LSize];
    int RightAra[RSize];
    for (int i=0;i<LSize;i++)
    {
        LeftAra[i]=ara[start+i];
    }
    for(int j=0;j<RSize;j++)
    {
        RightAra[j]=ara[mid+j+1];
    }
    int i=0;
    int j=0;
    int k=start;
    while(i<LSize && j<RSize)
    {
        if(LeftAra[i]>=RightAra[j])
        {
            ara[k++]=LeftAra[i++];
        }
        else
        {
            ara[k++]=RightAra[j++];

        }
    }
    while(i<LSize)
    {
        ara[k++]=LeftAra[i++];
    }
    while(j<RSize)
    {
        ara[k++]=RightAra[j++];
    }
}
void mergeSort(int ara[],int start,int end)
{

    if(start>=end)
        return;
    int mid=start+(end-start)/2;
    mergeSort(ara,start,mid);
    mergeSort(ara,mid+1,end);
    merge(ara,start,mid,end);
}

long long int minimumCost(int ara[],int n,int k)
{
    mergeSort(ara,0,n-1);
    int i;
    long long int minCost=0;
    i=0;
    for(int j=0;j<n;j++)
    {

        minCost+=(i+1)*ara[j];

        if((j+1)%k ==0)
        {
            i++;
        }
    }
    return minCost;
}

int main()
{
    int n,k;
    cin>>n>>k;
    int *ara=new int[n];
    for(int i=0;i<n;i++)
    {
        cin>>ara[i];
    }
    long long int cost;
    cost=minimumCost(ara,n,k);

    cout<<cost;

}
