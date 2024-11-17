# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.example.graal-test' is invalid and this project uses 'com.example.graal_test' instead.

# Getting Started

### Reference Documentation
To create the image, run the following goal:
```
$ ./gradlew bootBuildImage
```
```
$ docker run --rm -p 8080:8080 graal-test:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
```
$ ./gradlew clean nativeCompile
```

Then, you can run the app as follows:
```
$ cp application.properties build/native/nativeCompile/
$ cp my.props build/native/nativeCompile/
$ sudo build/native/nativeCompile/graal-test
```
