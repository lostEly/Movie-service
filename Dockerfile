FROM maven:3.6.0-jdk-11-slim AS build
COPY ./pom.xml ./pom.xml
COPY ./movie/src ./movie/src
COPY ./movie/pom.xml ./movie/pom.xml
RUN mvn dependency:go-offline -B
RUN mvn clean package -pl movie -am -DskipTests


FROM openjdk:11-jre-slim
VOLUME /tmp
COPY --from=build ./movie/target/*.jar /usr/local/lib/movie.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/movie.jar"]