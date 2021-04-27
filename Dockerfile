FROM openjdk:11.0.4-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
<<<<<<< HEAD
RUN export
ENTRYPOINT ["java","-jar","/app.jar"]
=======
ENTRYPOINT ["java","-jar","/app.jar"]
>>>>>>> 5c6899ca795ddb3ac249f4e8a8df3f5165686f4f
