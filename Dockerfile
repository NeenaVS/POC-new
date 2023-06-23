FROM openjdk:8-jdk-slim
ENV CATALINA_HOME /opt/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME

RUN apt-get update
RUN apt-get install vim wget zip gettext -y

ENV TOMCAT_VERSION 10.1.9
COPY apache-tomcat-10.1.9.tar.gz .


RUN tar -xf apache-tomcat-10.1.9.tar.gz
RUN mv apache-tomcat-10.1.9-deployer/* /opt/tomcat/
RUN rm -rf apache-tomcat-10.1.9.tar.gz apache-tomcat-10.1.9-deployer

COPY poc-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh","run"]
