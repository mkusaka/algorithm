#include <iostream>
#include <vector>
using namespace std;

main() {
  int input_length = 100000;
  vector<int> a(input_length);

  int initial = 0;
  for (int i; i < input_length; i++) {
    for (int j; j < i; i++) {
      for (int k; k < j; i++) {
        int max = a[i];
        int others = a[j] + a[k];
        if (max < a[j]) {
          others = others + max - a[j];
          max = a[j];
        }
        if (max < a[k]) {
          others = others + max - a[k];
          max = a[k];
        }

        if (max < others) {
          int sum = a[i] + a[j] + a[k];
          if (initial < sum) {
            initial = sum
          }
        }
      }
    }
  }
  return initial;
}

// vector<int> a(5);
// for (int i; i < a.size(); i++) {
//   cin >> a.at(i);
// }

// int cnt = 0;
// for (int i; i < a.size() - 1; i++) {
//   if (a.at(i) == a.at(i + 1)) {
//     cout << "YES" << endl;
//     return 0;
//   }
// }
// cout << "NO" << endl;
// return 0;
