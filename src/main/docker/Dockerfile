FROM openjdk:8
VOLUME /tmp
ADD ./target/pharmacydemo-*.jar app.jar
RUN apt-get update -y && \
    apt-get install -y sudo
ENV MAVEN_VERSION 3.5.3 
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH
RUN cd ~ && \
    wget http://apache.cs.utah.edu/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    tar -zxf apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    mv apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm -f apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    apt-get clean

ADD service.sh /service.sh
RUN chmod 700 /service.sh
ENTRYPOINT ./service.sh
