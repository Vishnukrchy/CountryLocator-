# CountryLocator Project

## Description
The CountryLocator project is a Java-based application that determines the country based on given latitude and longitude coordinates using GeoTools and GeoJSON files.

## Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/CountryLocatorProject.git
   cd CountryLocatorProject
   ```

2. **Build the Project Using Maven**:
   ```bash
   mvn clean install
   ```

3. **Download the GeoJSON File**:
   Place the `countries.geojson` file in the `data/` directory.

## Usage
To run the application:
```bash
mvn exec:java -Dexec.mainClass="com.vishnu.Assignment.Main"
```

### Example
```java
CountryLocator locator = new CountryLocator("data/countries.geojson");
String countryCode = locator.getCountryCode(20.5937, 78.9629); // Coordinates for India
System.out.println("Country code: " + countryCode);
```

## Running Tests
To run the unit tests:
```bash
mvn test
```

## Project Structure
```plaintext
CountryLocatorProject/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── vishnu/
│   │               └── Assignment/
│   │                   ├── CountryLocator.java
│   │                   └── Main.java
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── vishnu/
│   │               └── Assignment/
│   │                   ├── CountryLocatorTest.java
│   │                   └── PerformanceTest.java
├── data/
│   └── countries.geojson
├── pom.xml
└── README.md
```

## Tools Used
- **GeoTools**: A Java library for geospatial data manipulation. Used for reading and processing GeoJSON files.
- **JUnit 5**: A testing framework for Java, used for unit and performance testing.
- **Maven**: A build automation tool used for managing project dependencies and building the project.
- **GPT-4**: Used for generating documentation and providing code explanations.

### `pom.xml`
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.vishnu</groupId>
    <artifactId>Assignment</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.geotools</groupId>
            <artifactId>gt-geojson</artifactId>
            <version>25.0</version>
        </dependency>
        <dependency>
            <groupId>org.geotools</groupId>
            <artifactId>gt-main</artifactId>
            <version>25.0</version>
        </dependency>
        <dependency>
            <groupId>org.geotools</groupId>
            <artifactId>gt-shapefile</artifactId>
            <version>25.0</version>
        </dependency>
        <dependency>
            <groupId>org.geotools</groupId>
            <artifactId>gt-cql</artifactId>
            <version>25.0</version>
        </dependency>
        <dependency>
            <groupId>org.geotools</groupId>
            <artifactId>gt-referencing</artifactId>
            <version>25.0</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <repositories>
        <repository>
            <id>osgeo</id>
            <url>https://repo.osgeo.org/repository/release/</url>
        </repository>
    </repositories>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
