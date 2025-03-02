FROM ghcr.io/graalvm/jdk-community:23.0.2

ADD target/regapp*.jar app.jar

ENV JAVA_OPTS=''

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar