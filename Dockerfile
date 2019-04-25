FROM openjdk:8-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]

ADD ./target/dependency/BOOT-INF/lib     /usr/share/myservice/lib

ARG JAR_FILE
ADD ./target/${JAR_FILE} /usr/share/myservice/myservice.jar