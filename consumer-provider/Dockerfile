FROM maven:3.8.6-jdk-8 AS maven-builder
LABEL maintainer=xcbeyond
WORKDIR /builder
ARG MODULE
COPY . /builder
RUN mvn package -Dmaven.test.skip=true

FROM java:8
WORKDIR /app
ARG MODULE
COPY --from=maven-builder /builder/${MODULE}/target/${MODULE}-*.jar /app/

CMD ["java", "-jar", ${MODULE}-*.jar]