# Newtonsoft vs Jackson vs Go json
Benchmarks to compare Newtonsoft Json.net, Jackson and go json libraries

## To run:

### Newtonsoft
```bash
cd newtonsoft && dotnet restore && dotnet run --configuration release
```

### Jackson
```bash
cd jackson && mvn clean package && java -jar target/benchmarks.jar -f 1
```

### Go json
```bash
cd gojson && go test -bench .
```
