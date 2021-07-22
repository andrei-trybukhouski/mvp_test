FROM ubuntu:18.04 

LABEL maintainer="Andrei Trybukhouski andrei_trybukhouski@epam.com"

RUN apt-get update && \
    apt-get -qy full-upgrade && \
    apt-get install -qy git && \
    apt-get install -qy openssh-server && \
    sed -i 's|session    required     pam_loginuid.so|session    optional     pam_loginuid.so|g' /etc/pam.d/sshd && \
    mkdir -p /var/run/sshd && \
    apt-get install -qy openjdk-8-jdk 
# Install maven
RUN    apt-get install -qy maven && \
#
    apt-get -qy autoremove && \
    adduser --quiet jenkins && \
    echo "jenkins:jenkins" | chpasswd && \
    mkdir /home/jenkins/.m2

#ADD settings.xml /home/jenkins/.m2/

COPY .ssh/authorized_keys /home/jenkins/.ssh/authorized_keys
RUN chmod 600 /home/jenkins/.ssh/authorized_keys
RUN chown -R jenkins:jenkins /home/jenkins/.m2/ && \
    chown -R jenkins:jenkins /home/jenkins/.ssh/

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]
