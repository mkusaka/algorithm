pub fn sort_test() {
    println!("start: sort test");
    let mut x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
    insertion_sort(&mut x);
    // fail test
    assert_eq!(x, vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236]);
    println!("finish: sort test");
}

pub fn insertion_sort(output: &mut [u32]) {
    for j in 2..output.len() {
        let key = output[j];
        let mut i = j - 1;
        while i > 0 && output[i] > key {
            output[i + 1] = output[i];
            i = i - 1;
        }
        output[i + 1] = key;
        println!("print{:?}", output)
    }
    println!("print{:?}", output);
}
