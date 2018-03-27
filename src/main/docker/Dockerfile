FROM openjdk:8
VOLUME /tmp
ADD pharmademo-*.jar app.jar
RUN apt-get update -y && \
    apt-get install -y sudo
ENV MAVEN_VERSION 3.5.0 
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH
RUN cd ~ && \
    wget http://www-us.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    tar -zxf apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    mv apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm -f apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    apt-get clean

ADD service.sh /service.sh
chmod 700 /service.sh
CMD["mvn"]
ENTRYPOINT ./service.sh