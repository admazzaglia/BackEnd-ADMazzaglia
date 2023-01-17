FROM amazoncorretto:1.8

MAINTAINER portfolio.mad

COPY target/mad-0.0.1-SNAPSHOT.jar app-mad-0.0.1.jar

ENTRYPOINT ["java","-jar","/app-mad-0.0.1.jar"]