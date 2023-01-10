FROM amazoncorretto:19

COPY target/mad-0.0.1-SNAPSHOT.jar app-mad-0.0.1.jar

ENTRYPOINT ["java","-jar","/app-mad-0.0.1.jar"]