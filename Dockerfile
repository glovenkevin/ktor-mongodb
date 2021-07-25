FROM openjdk:8-jre-alpine
WORKDIR /app
COPY build/install/com.jenjen.ktor-coroutine .
CMD ["./bin/com.jenjen.ktor-coroutine"]