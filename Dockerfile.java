FROM amazoncorretto:19


MAINTAINER tunombre_o_alias


COPY target/mad-0.0.1-SNAPSHOT.jar mad-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar","/mad-0.0.1-SNAPSHOT.jar"]