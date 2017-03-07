using BenchmarkDotNet.Attributes;
using Newtonsoft.Json;

namespace Benchmarks.Newtonsoft.Vs.Jackson
{
    public class NewtonsoftBenchmark
    {
        [Benchmark]
        public string TestSimpleClass()
        {
            return JsonConvert.SerializeObject(new SimpleClass() { Id = 1, Text = "Test" });
        }

        [Benchmark]
        public string TestComplexClass()
        {
            return JsonConvert.SerializeObject(
                new ComplexClass()
                {
                    Id = 1,
                    Simples = new[] {
                        new SimpleClass() { Id = 1, Text = "Test1" },
                        new SimpleClass() { Id = 2, Text = "Test2" } },
                    Value = 199.99
                });
        }

        class SimpleClass
        {
            public int Id { get; set; }
            public string Text { get; set; }
        }

        class ComplexClass
        {
            public int Id { get; set; }
            public SimpleClass[] Simples { get; set; }
            public double Value { get; set; }
        }
    }
}