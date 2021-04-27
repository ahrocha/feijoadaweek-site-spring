FROM openjdk:11.0.4-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN export
ENTRYPOINT ["java","-jar","/app.jar"]
