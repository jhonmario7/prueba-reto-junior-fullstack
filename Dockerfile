#Etapa 1: Usamos JDK (trae javac) para poder compilar

FROM eclipse-temurin:21-jdk AS build
WORKDIR /src

COPY . .

RUN chmod +x mvnw && ./mvnw clean package

#Etapa 2: imagen final, solo JRE (no necesita compilador)
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /src/target/app.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
