#include<bits/stdc++.h>
using namespace std;

void LongestCommonSubSequence(char *str1,char *str2,int m,int n)
{
    int LCS_table[m+1][n+1];
    for(int i=0;i<=m;i++)
    {
        for(int j=0;j<=n;j++)
        {
            if(i==0 || j==0)
            {
                LCS_table[i][j]=0;

            }
            else if(str1[i-1]== str2[j-1])
                LCS_table[i][j]=LCS_table[i-1][j-1]+1;

            else
                LCS_table[i][j]= max(LCS_table[i-1][j],LCS_table[i][j-1]);
        }
    }
    int index=LCS_table[m][n];
     cout<<index<<endl;
    char substring[index+1];
    substring[index]='\0';
    int i=m,j=n;
    while(i>0 && j>0)
    {
        if(str1[i-1]==str2[j-1])
        {
         substring[index-1]=str1[i-1];
         i--;
         j--;
         index--;
        }
        else if(LCS_table[i-1][j]>LCS_table[i][j-1])
            i--;
        else
            j--;
    }

    cout<<substring<<endl;
}
int main()
{
    char s1[50],s2[50];
    cin>>s1>>s2;
    int m=strlen(s1);
    int n=strlen(s2);
    LongestCommonSubSequence(s1,s2,m,n);
}
