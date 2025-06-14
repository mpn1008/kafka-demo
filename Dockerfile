FROM openjdk:21-jdk-slim
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Xms512m", "-Xmx2g", \
"-XX:+UseG1GC", "-Xlog:gc*:file=gc.log:time,uptime,level,tags", "-jar", "/app.jar"]
