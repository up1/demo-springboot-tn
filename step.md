## Step to build-ship-run

### Solution 1

1. Build JAR file
```
$docker container run --rm -v $(pwd):/src -w /src openjdk:8u212-b04-jdk-stretch  ./mvnw clean package
```

2. Build Docker Image + JAR file
```
$docker image build -t somkiat/tn:1.0 -f Dockerfile-step1 .
```

3. Run container
```
$docker container run -p 8080:8080 somkiat/tn:1.0
```

### Solution 2 :: using [Multi-stage build](https://docs.docker.com/develop/develop-images/multistage-build/)
1. Build Docker Image + JAR file
```
$docker image build -t somkiat/tn:1.0 -f Dockerfile-step2 .
```

2. Run container
```
$docker container run -p 8080:8080 somkiat/tn:1.0
```

### Solution 3 :: Improve performance

1. Caching Library/dependency of Apache Maven
```
// Create container and access to container
$docker container run -it -v $(pwd):/src -w /src openjdk:8u212-b04-jdk-stretch bash
>#./mvnw dependency:resolve
>#./mvnw package

// Create Docker image from container
$docker container commit 77bbe4ff2556 java_lib
```

2. Build Docker Image + JAR file
```
$docker image build -t somkiat/tn:1.0 -f Dockerfile-step3 .
```

3. Run container
```
$docker container run -p 8080:8080 somkiat/tn:1.0
```


