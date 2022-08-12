FROM openjdk:11
ARG JAR_FILE=target/*.jar
EXPOSE 9001
ENV JAVA_OPTS=""
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

