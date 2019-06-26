pub fn sort_test() {
    let mut x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
    insertion_sort(&mut x);
}

pub fn insertion_sort(arr: &mut [u32]) {
    print!("{:?}", &arr);
}
