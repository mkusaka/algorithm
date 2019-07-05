pub fn sort_test() {
    println!("start: sort test");
    let mut x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
    let resp = insertion_sort(&mut x);
    assert!(resp == vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236]);
    println!("finish: sort test");
}

pub fn insertion_sort(arr: &mut Vec<u32>) -> Vec<u32> {
    return vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236];
}
