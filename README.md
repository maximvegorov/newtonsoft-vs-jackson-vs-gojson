# newtonsoft_vs_jackson_vs_gojson
Benchmarks to compare Newtonsoft Json.net, Jackson and native go json libraries

To run:
1) Newtonsoft
dotnet restore && dotnet run --configuration release

2) Jackson
mvn clean package && java -jar target/benchmarks.jar

3) Go native json
go test -bench .
