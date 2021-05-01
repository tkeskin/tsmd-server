FROM openjdk:11

MAINTAINER dberber

EXPOSE 5001

ENV TZ=Turkey
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# label for the image
LABEL Description="TSMD CENGIZ" Version="0.0.1"

ADD /build/libs/tsmd-cengiz*.jar /tsmd-cengiz.jar

ENTRYPOINT ["java","-jar","/tsmd-cengiz.jar"]
