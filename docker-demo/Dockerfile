FROM amazoncorretto:11-alpine-jdk
MAINTAINER maslov.org
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:9251
EXPOSE 8082 8765 5005 9251
COPY target/docker-demo-0.0.1-SNAPSHOT.jar docker-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/docker-demo-0.0.1-SNAPSHOT.jar"]