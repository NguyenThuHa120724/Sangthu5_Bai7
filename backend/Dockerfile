# --- GIAI ĐOẠN 1: BUILD (Sử dụng Maven để đóng gói file JAR) ---
FROM maven:3-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

# --- GIAI ĐOẠN 2: RUN (Chỉ chạy file JAR đã build) ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copy file jar từ giai đoạn builder sang
COPY --from=builder /app/target/*.jar app.jar

# Mở cổng 8080 (Khớp với cấu hình Slot S5 bạn đang đặt)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]