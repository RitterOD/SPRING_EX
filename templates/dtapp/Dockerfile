FROM maven:3.8.6-eclipse-temurin-17-alpine
ENV PROJECT_DIR=/opt/project

RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ADD ./pom.xml $PROJECT_DIR
RUN mvn dependency:resolve

ADD ./src/ $PROJECT_DIR/src
RUN mvn install
RUN ls -a target

FROM eclipse-temurin:17.0.5_8-jdk-alpine

ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/dtapp-0.0.1-SNAPSHOT.jar $PROJECT_DIR/

EXPOSE 8080
EXPOSE 5432

CMD ["java", "-jar", "/opt/project/dtapp-0.0.1-SNAPSHOT.jar"]