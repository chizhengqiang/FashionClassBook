FROM java:8
VOLUME /tmp
ADD fashionclassbook-0.0.1-SNAPSHOT.jar /fcb.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","fcb.jar"]