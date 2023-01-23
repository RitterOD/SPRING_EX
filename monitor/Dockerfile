#FROM springci/spring-boot-ci-jdk17
#ARG JAR_FILE=./target/*.jar
#COPY ${JAR_FILE} application.jar
#ENTRYPOINT ["java", "-jar", "application.jar"]
FROM eclipse-temurin:17.0.5_8-jdk-alpine

ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY ./target/*.jar  $PROJECT_DIR/

EXPOSE 8080
EXPOSE 5432

CMD ["java", "-jar", "/opt/project/monitor-0.0.1-SNAPSHOT.jar"]