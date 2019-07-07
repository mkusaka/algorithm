pub fn sort_test() {
    println!("start: sort test");
    let x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
    let resp = insertion_sort(x);
    println!("{:?}", resp);
    // fail test
    assert_eq!(resp, vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236]);
    println!("finish: sort test");
}

pub fn insertion_sort(arr: Vec<u32>) -> Vec<u32> {
    let mut output = arr.clone();
    for j in 2..output.len() {
        let key = output[j];
        let mut i = j - 1;
        while i > 0 && output[i] > key {
            output[i + 1] = output[i];
            i = i - 1;
        }
        output[i + 1] = key;
    }
    println!("{:?}", output);
    return output
}
