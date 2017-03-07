# Newtonsoft vs Jackson vs Go json
Benchmarks to compare Newtonsoft Json.net, Jackson and go json libraries

## To run:

1. Newtonsoft
```bash
cd newtonsoft && dotnet restore && dotnet run --configuration release
```

2. Jackson
```bash
cd jackson && mvn clean package && java -jar target/benchmarks.jar -f 1
```

3. Go json
```bash
cd gojson && go test -bench .
```
