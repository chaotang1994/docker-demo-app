FROM openjdk:8

ADD target/docker-demo-app.jar docker-demo-app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-demo-app.jar"]