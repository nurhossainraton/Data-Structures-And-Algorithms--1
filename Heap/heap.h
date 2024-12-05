//#include <iostream>
#include <vector>
using namespace std;

class Heap
{
    int *harr,maxSize,heapsize;
    int getparentIndex(int i)
    {
        return (i-1)/2;
    }
    int getleftIndex(int i)
    {
        return 2*i+1;
    }
    int getrightIndex(int i)
    {
        return 2*i+2;

    }
    void swapValue(int i,int l)
    {
        int temp=harr[i];
        harr[i]=harr[l];
        harr[l]=temp;

    }
    void MaxHeapify(int i)
    {
        int l=getleftIndex(i);
        int r=getrightIndex(i);
        int largest=i;
        if(l<heapsize && harr[l]>harr[i])
        {
            largest=l;
        }
        else if(r<heapsize && harr[r]>harr[largest])
        {
            largest=r;
        }
        if(largest!=i)
        {
            //swap(harr[i],harr[largest]);
            swapValue(i,largest);
            MaxHeapify(largest);
        }

    }


public:
    Heap(int n)
    {
        maxSize=n;
        heapsize=0;
        harr=new int[n];
    }


    Heap(vector<int>&numbers)
    {

        maxSize=numbers.size();
        harr=new int[maxSize];
        heapsize=0;
        for(int i=0;i<numbers.size();i++)
        {
            insert(numbers[i]);

        }

    }
    void insert(int val)
    {
        if(heapsize<maxSize)
        {
            int temp=heapsize;
            harr[heapsize++]=val;

            while(getparentIndex(temp)>=0)
            {
                if(harr[temp]>harr[getparentIndex(temp)])
                {
                    //swap(harr[temp],harr[getparentIndex(temp)]);
                    swapValue(temp,getparentIndex(temp));
                    temp=getparentIndex(temp);
                }
                else
                    break;
            }
        }
    }
    ~Heap()
    {
        delete []harr;
    }

    int getMax()
    {
        return harr[0];
    }
    int size()
    {
        return heapsize;
    }
    void deleteKey()
    {
        harr[0]=harr[--heapsize];
        MaxHeapify(0);
    }

};
void heapsort(vector<int>&numbers)
    {

        Heap heap(numbers);
        int n=numbers.size();
        numbers.clear();
        for(int i=0;i<n;i++)
        {
            numbers.push_back(heap.getMax());
            heap.deleteKey();
        }
        for(int i=0;i<n;i++)
        {
            cout<<numbers[i]<<endl;
        }


    }

