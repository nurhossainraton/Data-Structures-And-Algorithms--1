//#include <bits/stdc++.h>
#include <iostream>
#include <ctime>
#include <algorithm>
#include <fstream>
using namespace std;

int Partition(int ara[],int start,int end)
{
    int pivot=ara[end];
    int i= start-1;
    for (int j=start ;j<end;j++)
    {
        if(ara[j]<pivot)
        {
            i++;
            swap(ara[i],ara[j]);
        }
    }
    swap(ara[i+1],ara[end]);
    return (i+1);
}

int randomPartition(int ara[],int start,int end)
{
    srand(time(NULL));
    int random = start + rand() % (end - start);
    swap(ara[random],ara[end]);
    return Partition(ara,start,end);

}
void randomQuicksort(int ara[],int start,int end)
{
    if(start<end)
    {
        int pivot=randomPartition(ara,start,end);
        randomQuicksort(ara,start,pivot-1);
        randomQuicksort(ara,pivot+1,end);
    }
}
void Quicksort(int ara[],int start,int end)
{
    if(start<end)
    {
        int pivot=Partition(ara,start,end);
        Quicksort(ara,start,pivot-1);
        Quicksort(ara,pivot+1,end);
    }
}
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
        if(LeftAra[i]<=RightAra[j])
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
void insertionSort(int ara[],int n)
{
    int i,key,j;
    for (i=1;i<n;i++)
    {
        key=ara[i];
        j=i-1;
        while(j>=0 && ara[j]>key)
        {
            ara[j+1]=ara[j];
            j--;
        }
        ara[j+1]=key;
    }
}
int main()
{
    int n[] = {5,10,100,1000,10000,100000};
    int maxIteration =20;
    int nSize=sizeof(n)/sizeof(int);
    double average[nSize][7];
    for (int i=0;i<nSize;i++)
    {

        float MergeSortTime=0,QuickSortTime=0,QuickSortRandomTime=0,InsertionSortTime=0,sortedQuickSortTime=0,sortedQuickSortRandomTime=0,STLsortTime=0;
        for(int j=0;j<maxIteration;j++)
        {
            clock_t timer;
            int elementNum=n[i];
            int ara[elementNum];
            srand(elementNum+j);
            for(int k=0;k<elementNum;k++)
            {
                ara[k]=rand();
            }
            timer=clock();
            mergeSort(ara,0,elementNum-1);
            MergeSortTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            srand(elementNum+j);
            for(int k=0;k<elementNum;k++)
            {
                ara[k]=rand();
            }
            timer=clock();
            Quicksort(ara,0,elementNum-1);
            QuickSortTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            srand(elementNum+j);
            for(int k=0;k<elementNum;k++)
            {
                ara[k]=rand();
            }
            timer=clock();
            randomQuicksort(ara,0,elementNum-1);
            QuickSortRandomTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            srand(elementNum+j);
            for(int k=0;k<elementNum;k++)
            {
                ara[k]=rand();
            }
            timer=clock();
            insertionSort(ara,elementNum);
            InsertionSortTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            timer=clock();
            Quicksort(ara,0,elementNum-1);
            sortedQuickSortTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            timer=clock();
            randomQuicksort(ara,0,elementNum-1);
            sortedQuickSortRandomTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;

            srand(elementNum+j);
            for(int k=0; k<elementNum; k++)
            {
                ara[k]=rand();
            }
            timer=clock();
            sort(ara,ara+elementNum);
            STLsortTime+=(float(clock()-timer)*1000)/CLOCKS_PER_SEC;


        }
        int j=0;
        average[i][j++]=MergeSortTime/maxIteration;
        average[i][j++]=QuickSortTime/maxIteration;
        average[i][j++]=QuickSortRandomTime/maxIteration;
        average[i][j++]=InsertionSortTime/maxIteration;
        average[i][j++]=sortedQuickSortTime/maxIteration;
        average[i][j++]=sortedQuickSortRandomTime/maxIteration;
        average[i][j++]=STLsortTime/maxIteration;


    }
    /*for(int i=0; i<nSize; i++)
    {
        for(int j=0; j<7; j++)
        {
            cout<<average[i][j]<<"\t\t";
        }
        cout<<endl;
    }*/
    ofstream outputFile;
    outputFile.open("output.csv");
    outputFile<<"Time required in ms\n";
    outputFile<<"n,Merge Sort,Quick Sort,Randomized Quicksort,Insertion Sort,QuickSort with Sorted Input,Randomized QuickSort with Sorted Input,Stl sort() function";
    for(int i=0; i<nSize; i++)
    {
        outputFile<<n[i]<<",";
        for(int j=0; j<7; j++)
        {
            outputFile<<average[i][j]<<",";
        }
        outputFile<<endl;
    }
    outputFile.close();

}
