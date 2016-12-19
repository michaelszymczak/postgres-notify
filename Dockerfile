FROM openjdk:8
COPY . /usr/src/postgresnotify
WORKDIR /usr/src/postgresnotify
# RUN ./gradlew clean shadowJar
COPY build/libs/postgresnotify.jar /usr/src/postgresnotify/build/libs/postgresnotify.jar
CMD ["java", "-jar", "/usr/src/postgresnotify/build/libs/postgresnotify.jar"]
