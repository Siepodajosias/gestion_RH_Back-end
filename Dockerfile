# ---- STAGE 1 : Build avec Gradle ----
FROM gradle:8.10-jdk21 AS builder
WORKDIR /app

# Copie uniquement les fichiers de configuration pour optimiser le cache
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Télécharge les dépendances (cette couche sera mise en cache)
RUN gradle dependencies --no-daemon

# Copie le code source
COPY src ./src

# Build de l'application
RUN gradle bootJar -x test --no-daemon

# ---- STAGE 2 : Image finale JRE ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Création d'un utilisateur non-root pour la sécurité
RUN addgroup -S spring && adduser -S spring -G spring

# Copie du JAR depuis le stage de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Change le propriétaire du fichier
RUN chown spring:spring app.jar

# Bascule vers l'utilisateur non-root
USER spring

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "/app/app.jar"]