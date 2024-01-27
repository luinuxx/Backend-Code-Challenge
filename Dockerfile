# Usa una imagen de OpenJDK para Java 11 como base
FROM adoptopenjdk:17-jre-hotspot

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR de la carpeta de compilación a la imagen
COPY build/libs/codingchallenge-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
