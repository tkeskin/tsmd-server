FROM openjdk:11

MAINTAINER tkeskin

EXPOSE 8761

# label for the image
LABEL Description="Eureka Server" Version="0.0.1"

ADD /build/libs/eureka-server*.jar /eureka-server.jar

ENTRYPOINT ["java","-jar","/eureka-server.jar"]
