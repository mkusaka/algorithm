#include <bits/stdc++.h>
using namespace std;

void p(int a) {
  cout << a << endl;
}

int main() {
  int x, a, b;
  cin >> x >> a >> b;

  x++;
  p(x);

  x *= (a + b);
  p(x);

  x *= x;
  p(x);

  x--;
  p(x);
}
