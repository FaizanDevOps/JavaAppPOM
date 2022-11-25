FROM 710264925055.dkr.ecr.ap-south-1.amazonaws.com/maven:jdk-11 as build 
WORKDIR /app
COPY . /app 
RUN mvn clean verify sonar:sonar \
-Dsonar.projectKey=testingsonar \
-Dsonar.host.url=https://sonarqube.qritrim.com \
-Dsonar.login=sqp_89773aa3a750fa58f1dad4484b1b837cddb7cf95

RUN mvn clean install 

FROM 710264925055.dkr.ecr.ap-south-1.amazonaws.com/maven:openjdk-11-alpine
WORKDIR /app
RUN mkdir qivr
ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \ -Dcom.sun.management.jmxremote.authenticate=false \ -Dcom.sun.management.jmxremote.port=5000 \ -Dcom.sun.management.jmxremote.rmi.port=5000 \ -Dcom.sun.management.jmxremote.host=0.0.0.0 \ -Djava.rmi.server.hostname=0.0.0.0"
COPY --from=build /app/target/qivrtrack-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","/app/qivrtrack-0.0.1-SNAPSHOT.jar"]
