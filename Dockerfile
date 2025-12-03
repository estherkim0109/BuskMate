# 1단계: 빌드 용 (JDK 21 위에서 gradlew 실행)
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# 프로젝트 전체 복사
COPY . .

# gradlew 실행권한 부여 + JAR 빌드 (테스트는 일단 제외)
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon -x test

# 2단계: 실행 용 (JRE 21)
FROM eclipse-temurin:21-jre

WORKDIR /app

# 빌드된 JAR 복사
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
