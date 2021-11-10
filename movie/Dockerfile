FROM maven:3.6.0-jdk-11-slim AS build
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
RUN mvn clean package -DskipTests


FROM openjdk:11-jre-slim
VOLUME /tmp
COPY --from=build ./target/*.jar /usr/local/lib/movie.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/movie.jar"]