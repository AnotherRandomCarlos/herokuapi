# Fichero docker de la API
FROM openjdk:11-jdk-slim
COPY "./target/api-0.0.1-SNAPSHOT.jar" "app.jar"
COPY "./Usuarios.json" "Usuarios.json"
COPY "./Prestamos.json" "Prestamos.json"
COPY "./Equipos.json" "Equipos.json"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]