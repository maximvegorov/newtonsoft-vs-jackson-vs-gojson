# Newtonsoft vs Jackson vs Go json
Benchmarks to compare Newtonsoft Json.net, Jackson and go json libraries

## To run:

1. Newtonsoft
> dotnet restore && dotnet run --configuration release

2. Jackson
> mvn clean package && java -jar target/benchmarks.jar

3. Go json
> go test -bench .
