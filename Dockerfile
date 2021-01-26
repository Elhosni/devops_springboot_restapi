# En utilise une image de base openjdk-8
FROM openjdk:8-jdk-alpine

#Maintainer de l'application
LABEL maintainer="elhosnimtz@gmail.com"

# Le jar de l application
ARG JAR_FILE=target/*.jar

#Deplacer le jar dans le container ici le container et le workspace de l'application 
ADD ${JAR_FILE} springboot-restapi.jar

# Exposer le port 8090 à l'extérieur de container
EXPOSE 8080

CMD ["java", "-jar", "/springboot-restapi.jar"]