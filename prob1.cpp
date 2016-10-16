#include <iostream>
#include<math.h>
using namespace std;

int main()
{
 	long int n;
 	scanf("%ld",&n);
 	long int arr[(int)n];
 	for(long int i=0;i<n;i++)
 	{
 		scanf("%ld",&arr[i]);
 	}
 	 long int sum = 0;
 	 for(long int i=0;i<n;i++)
 	 {
 	 	for(long int j = i + 1;j < n;j++)
 	 	{
 	 		for(long int k = j + 1;k < n;k++)
 	 		{
 	 			long int up =0;
 	 			long int down =0;
 	 			up = arr[i]+arr[j]+arr[k];
 	 			down = arr[i]*arr[j]*arr[k];
 	 			sum = sum + floor(up/down);
 	 		}
 	 	}
 	 }
 	 printf("%ld",sum);
 	 return 0;
}
