## Step to build-ship-run

### Solution 1

1. Build JAR file
```
$docker container run --rm -v $(pwd):/src -w /src openjdk:8u212-b04-jdk-stretch  ./mvnw clean package
```

2. Build Docker Image + JAR file
```
$docker image build -t somkiat/tn:1.0 -f Dockerfile-step2 .
```

3. Run container
```
$docker container run -p 8080:8080 somkiat/tn:1.0
```

### Solution 2
1. Build Docker Image + JAR file
```
$docker image build -t somkiat/tn:1.0 -f Dockerfile-step1 .
```

2. Run container
```
$docker container run -p 8080:8080 somkiat/tn:1.0
```

