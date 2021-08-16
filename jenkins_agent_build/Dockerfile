FROM ubuntu:20.04 
LABEL maintainer="Andrei Trybukhouski andrei_trybukhouski@epam.com"

ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=Europe/Vilnius

RUN apt-get update 
    # apt-get -qy upgrade 
RUN    apt-get install -qy sudo git openssh-server && \
    sed -i 's|session    required     pam_loginuid.so|session    optional     pam_loginuid.so|g' /etc/pam.d/sshd && \
    mkdir -p /var/run/sshd && \
    apt-get install -qy openjdk-11-jdk 

RUN    apt-get install -qy make autoconf automake libtool  && \
       apt-get autoremove 

RUN    adduser --quiet jenkins && \
    echo "jenkins:jenkins" | chpasswd &&  adduser jenkins sudo &&\
    mkdir /home/jenkins/.m2 && \
    echo "jenkins  ALL=(ALL:ALL) NOPASSWD:ALL" >> /etc/sudoers

#COPY settings.xml /home/jenkins/.m2/

COPY .ssh/authorized_keys /home/jenkins/.ssh/authorized_keys
RUN chmod 600 /home/jenkins/.ssh/authorized_keys
RUN chown -R jenkins:jenkins /home/jenkins/.m2/ && \
    chown -R jenkins:jenkins /home/jenkins/.ssh/ && \
    mkdir -m 777 /buildroot 


EXPOSE 22 
 
CMD ["/usr/sbin/sshd", "-D"]
VOLUME [ "/buildroot" ]
