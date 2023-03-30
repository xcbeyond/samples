FROM maven:3.8.6-jdk-8 AS maven-builder
LABEL maintainer=xcbeyond
WORKDIR /builder
ARG MODULE
COPY . /builder
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:8
WORKDIR /app
ARG MODULE VERSION
ENV VERSION ${VERSION:-v1}
COPY --from=maven-builder /builder/${MODULE}/target/${MODULE}-*.jar /app/
EXPOSE 8001 8002

CMD ["java", "-jar", ${MODULE}-*.jar]