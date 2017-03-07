package gojson_test

import "testing"
import "encoding/json"

type SimpleClass struct {
	Id int
	Text string
}

type ComplexClass struct {
	Id int
	Simples []*SimpleClass
	Value float64
}

func BenchmarkSimpleClass(b *testing.B) {
    for i := 0; i < b.N; i++ {
        json.Marshal(&SimpleClass{1, "Test"});
    }
}

func BenchmarkComplexClass(b *testing.B) {
    for i := 0; i < b.N; i++ {
        json.Marshal(
		&ComplexClass{
			1,
			[]*SimpleClass{&SimpleClass{1, "Test1"}, &SimpleClass{2, "Test2"}},
			199.99});
    }
}

