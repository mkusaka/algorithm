package main

import (
	"fmt"
	"net/http"
	"time"
)

type Person struct {
	Name  string
	Phone string
}

func main() {
	expiration := time.Now()
	expiration = expiration.AddDate(1, 0, 0)
	cookie := http.Cookie{Name: "username", Value: "hogehoge", Expires: expiration}
	fmt.Println(cookie)
}
