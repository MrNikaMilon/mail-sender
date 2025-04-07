LABEL  author="Nikon Sergeev"
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

COPY build.gradle settings.gradle gradle.properties* ./
COPY gradle gradle
RUN gradle dependencies

COPY . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-jre-alpine AS runtime
WORKDIR /app

COPY --from=build /app/build/libs/*.jar mail-sender.jar

EXPOSE 8099

# Запуск
ENTRYPOINT ["java", "-jar", "mail-sender.jar"]