FROM openjdk:17

RUN apk update && apk add --no-cache \
    xorg-server \
    && rm -rf /var/cache/apk/*

COPY tentativa-looca-api-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/share/home

WORKDIR /usr/share/home

CMD ["java", "-jar", "tentativa-looca-api-1.0-SNAPSHOT-jar-with-dependencies.jar"]