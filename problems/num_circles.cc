/* Description: in this we calculate the integral radius of circle in which the k number of given points are located. we output the radius of the circle*/

#include<iostream>
#include<string>
#include<iterator>
#include<vector>
#include<algorithm>
#include<map>

using namespace std;

int main()
{
	int n,k;
	cin>>n>>k;
	vector< pair<int,int> > coords;
	int a[n],b[n];
	for(int i =0;i<n;i++)
		cin>>a[i];
	for(int i =0;i<n;i++)
		cin>>b[i];
		//coords[i].second = a;
	for(int i=0;i<n;i++)
		coords.push_back(pair<int,int>(a[i],b[i]));
		//cout<<"\t"<<oords[i].first<<"\t"<<coords[i].second<<"\n";
	int r=1;
	while(true)
	{
		int count = 0;
		for(int i=0;i<n;i++)
		{
			if((coords[i].first * coords[i].first + coords[i].second * coords[i].second - r*r) <= 0)
				count++;
		}
		if(count >= k)
			break;
		else
			r = r+1;
	}
	cout<<r;
	return 0;
/* 3 3 1 -1 1 1 -1 -1*/
}
