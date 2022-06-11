FROM java:8
EXPOSE 8081
ARG JAR_FILE=build/libs/cicd-0.0.1-SNAPSHOT-plain.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]