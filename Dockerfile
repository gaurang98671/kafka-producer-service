FROM openjdk:11
ADD target/docker-kafka-producer.jar docker-kafka-producer.jar
EXPOSE 8080 
ENTRYPOINT [ "java", "-jar", "docker-kafka-producer.jar" ]