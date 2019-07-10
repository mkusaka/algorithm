pub fn sort_test() {
    let x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
    // let x = vec![2, 1];
    let y = insertion_sort(x);
    // fail test
    assert_eq!(y, vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236]);
}

pub fn insertion_sort(arr: Vec<u32>) -> Vec<u32> {
    let mut output = arr.clone();
    for j in 1..output.len() {
        let key = output[j];
        let mut i = (j as i8) - 1;
        while i >= 0 && output[i as usize] > key {
            output[(i as usize) + 1] = output[i as usize];
            println!("current i: {:?}", i);
            i = i - 1;
        }
        output[(i + 1) as usize] = key;
    }
    return output;
}

#[cfg(test)]
mod tests {
    use super::insertion_sort;

    #[test]
    fn is_valid_insertion_sort() {
        let x = vec![10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76];
        let y = insertion_sort(x);
        assert_eq!(y, vec![1, 4, 10, 10, 11, 20, 23, 30, 76, 220, 324, 330, 444, 4423, 4440, 8236]);
    }
}
