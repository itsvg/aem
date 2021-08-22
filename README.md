# aem
A Spring-boot application that takes in a number and outputs a Roman numeral

### Relevant Articles: 
- [Roman numerals wiki](https://en.wikipedia.org/wiki/Roman_numerals)

### Build the Project
```
./gradlew clean build
```

# Running the application
The application uses [Spring Boot](http://projects.spring.io/spring-boot/), so it is easy to run. You can start it any of a few ways:
* Run the `main` method from `AemApplication`
* Run the following command in a terminal window(in the complete): `./gradlew bootRun`
* Package the application as a JAR and run it using `java -jar aem.jar`

# Viewing the running application
To view the running application, visit [http://localhost:8080](http://localhost:8080) in your browser

### Use the REST API

```
curl http://localhost:8080/romannumeral?query={integer}
```
Or

Put the url with valid integer (from 1 to 255) in the browser:
```
http://localhost:8080/romannumeral?query={integer}
```

For Example: 

Endpoint: 
```
http://localhost:8080/romannumeral?query=254
```
output: 
```
{"input":"254","output":"CCLIV"}
```