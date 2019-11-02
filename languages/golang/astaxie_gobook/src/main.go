package main

import (
	"fmt"
	"strconv"
)

type Human struct {
	name  string
	age   int
	phone string
}

// fmt.Printlnはstringを返すString() メソッドを呼び出すので、これを実装すればPrintln内で呼ばれる
func (h Human) String() string {
	return "❰" + h.name + " - " + strconv.Itoa(h.age) + " years - " + h.phone + "❱"
}

func main() {
	Bob := Human{"Bob", 39, "000-7777-XXX"}
	fmt.Println("This Human is : ", Bob)
}
