FROM openjdk:8-alpine

COPY target/uberjar/dexcom-api2.jar /dexcom-api2/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/dexcom-api2/app.jar"]
