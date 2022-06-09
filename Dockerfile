FROM java:8
EXPOSE 8081
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} 
COPY app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
