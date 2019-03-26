package main

import (
	"fmt"
	"strconv"
)

func main() {
	var a, b, c int
	fmt.Scan(&a)
	fmt.Scan(&b, &c)
	var d string
	fmt.Scan(&d)

	fmt.Println(strconv.Itoa(a+b+c) + " " + d)
}
