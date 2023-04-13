# 도커 이미지의 base로 사용할 이미지
FROM openjdk:11-jdk-slim

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src /src

RUN chmod +x ./gradlew
RUN ./gradlew build

# 컨테이너 내부에서 8080번 포트를 사용
EXPOSE 8080

# 컨테이너가 시작될 때 jar 파일을 실행
ENTRYPOINT ["java", "-jar", "/build/libs/ssaibrary-0.0.1-SNAPSHOT.jar"]
