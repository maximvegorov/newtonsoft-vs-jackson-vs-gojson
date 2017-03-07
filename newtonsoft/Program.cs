using BenchmarkDotNet.Running;

namespace Benchmarks.Newtonsoft.Vs.Jackson
{
    public class Program
    {
        public static void Main(string[] args)
        {
            BenchmarkRunner.Run<NewtonsoftBenchmark>();
        }
    }
}
