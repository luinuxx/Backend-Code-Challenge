# Usa una imagen base que contenga Java y la máquina virtual de Spring Boot
FROM adoptopenjdk/openjdk11:alpine-jre

# Establece el directorio de trabajo
WORKDIR /Backend-Code-Challenge

# Copia el JAR construido a la imagen
COPY build/libs/codingchallenge-0.0.1-SNAPSHOT.jar codingchallenge-0.0.1-SNAPSHOT-plain.jar

# Expone el puerto en el que se ejecuta tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]