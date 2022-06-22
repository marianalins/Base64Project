FROM bellsoft/liberica-openjdk-alpine:11

WORKDIR /app

COPY target/Base*.jar /app/app.jar
EXPOSE 8089

ENTRYPOINT ["java","-jar","app.jar" ]




