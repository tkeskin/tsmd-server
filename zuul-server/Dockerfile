FROM java:11
VOLUME /tmp

COPY /build/libs/zuul-server*.jar /zuul-server.jar
EXPOSE 8763

CMD java -Xms2048m -Xmx4096m -jar /zuul-server.jar
