# Java 17 slim imajını kullan
FROM openjdk:17-jdk-slim

# Container içinde /app klasörüne geç
WORKDIR /app

# Build edilen jar dosyasını container içine kopyala
COPY target/*.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]