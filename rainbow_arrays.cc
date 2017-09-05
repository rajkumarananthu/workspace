/*Description: Rainbow arrays are such arrays in which
first a1 elements are 1
a2 elements are 2
a3 elemetns are 3
a4 elements are 4
a5 elements are 5
a6 elements are 6
a7 elements are 7
next a6 elements are 6
a5 elements are 5
a4 elements are 4
a3 elements are 3
a2 elements are 2
a1 elements are 1

the program checks for a given array if it is rainbowarray gives "yes",otherwise "no" */

#include<iostream>

 
using namespace std;

bool check_for_rainbow(int ar[],int size);

int main()
{
	int t;
	cin>>t;
	int n[t],ar[t][100];
	for(int i=0;i<t;i++)
	{
		cin>>n[i];
		for(int j =0;j<n[i];j++)
			cin>>ar[i][j];
	}
	for(int i =0;i<t;i++)
	{
		if(check_for_rainbow(ar[i],n[i]))
			cout<<"yes\n";
		else
			cout<<"no\n";
	}
	
	return 0;
}

bool check_for_rainbow(int ar[],int size)
{	
	int indx =0;
	int n =1;
	if (size%2 == 1)
	while((indx!=(size-1)/2))
	{
		if( ar[indx] == n+1)
			n = n+1;
		if(ar[indx] == ar[size-1-indx] && ar[indx] == n)
			indx++;
		else
			break;
	}
	 
	if ((indx == (size-1)/2) && ar[indx] == 7)
		return true;
	else
		return false;
}
