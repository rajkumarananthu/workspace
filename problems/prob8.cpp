#include <iostream>

void stair (int n) {
	for (auto i = 1; i <= n; ++i) {
		for (auto j = n-i; j >= 1; --j) {
			std::cout<<" ";
		}
		for (auto k = i; k >= 1; --k) {
			std::cout<<"#";
		}
		std::cout<<"\n";
	}
}

int main () {
	int n;
	std::cout <<"Enter an integer: ";
	std::cin>>n;
	stair (n);
	return 0;
}
