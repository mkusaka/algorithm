#include <bits/stdc++.h>
using namespace std;

void p(string a) {
  cout << a;
}

int main() {
  int a, b;

  cin >> a >> b;

  p("A:");
  int i = 0;
  while (i < a) {
    p("]");
    i++;
  }
  cout << endl;
  p("B:");
  int j = 0;
  while (j < b) {
    p("]");
    j++;
  }
  cout << endl;
}
