FROM openjdk:11.0.13-jre

COPY target/ /usr/local/service/

ENV JAVA_TOOL_OPTIONS "-XX:InitialRAMPercentage=10 -XX:MinRAMPercentage=25 -XX:MaxRAMPercentage=50"

ENTRYPOINT ["java", "-jar", "/usr/local/service/sb-service.jar", "--spring.config.location=optional:classpath:/application.properties"]
