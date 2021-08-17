FROM jenkins/jenkins:lts-jdk11
LABEL maintainer="Andrei Trybukhouski andrei_trybukhouski@epam.com"
ENV JENKINS_REF /usr/share/jenkins/ref
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
USER root
RUN apt-get update && apt-get install -y apt-transport-https \
       ca-certificates curl gnupg2 \
       software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/debian \
       $(lsb_release -cs) stable"
RUN apt-get update && apt-get install -y docker-ce-cli

COPY /keys/id_rsa /home/jenkins/id_ssh_agent
RUN chmod 777 /home/jenkins/id_ssh_agent

USER jenkins

COPY plugins.txt $JENKINS_REF/plugins.txt
RUN jenkins-plugin-cli --plugin-file $JENKINS_REF/plugins.txt

COPY ./jobs $JENKINS_REF/jobs/
COPY ./init.groovy.d $JENKINS_REF/init.groovy.d/
COPY ./dsl $JENKINS_REF/dsl/

ENV CASC_JENKINS_CONFIG /var/jenkins_home/casc.yaml
COPY casc.yaml /var/jenkins_home/casc.yaml
COPY /keys /home/jenkins/.ssh
