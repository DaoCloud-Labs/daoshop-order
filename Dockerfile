FROM openjdk:8-jre-alpine

LABEL maintainer="jian.tan@daocloud.io"

ENV DIST_NAME=order \
    APP_VERSION=0.0.1-SNAPSHOT \
    AGENT_REPO_URL="https://nexus.daocloud.io/repository/labs/io/daocloud/mircoservice/skywalking/agent/2.0.1/agent-2.0.1.gz"

ADD $AGENT_REPO_URL /

COPY target/"$DIST_NAME-$APP_VERSION.jar" /"$DIST_NAME.jar"

RUN set -ex; \
    tar -zxf /agent-2.0.0.gz; \
    rm -rf agent-2.0.0.gz;

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

EXPOSE 18082

ENTRYPOINT java -javaagent:/skywalking-agent/skywalking-agent.jar \
           -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /$DIST_NAME.jar
