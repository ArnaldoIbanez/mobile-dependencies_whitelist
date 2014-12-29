FROM ubuntu:14.04

MAINTAINER Alexis Petalas, Gabriel Eisbruch <arquitectura@mercadolibre.com>

#ENV http_proxy http://proxy.meliglobal.com
#ENV https_proxy http://proxy.meliglobal.com

RUN sed 's/main$/main universe/' -i /etc/apt/sources.list
RUN apt-get update && apt-get install -y software-properties-common python-software-properties
RUN add-apt-repository ppa:webupd8team/java -y

# Install Java
RUN apt-get update
RUN echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java7-installer

#Instal make
RUN apt-get -y install make git-core

#Install gradlew
ADD ./fake_app /tmp/fake_app
WORKDIR /tmp/fake_app

RUN ./gradlew cacheDependencies

ENV AWS_ACCESS_KEY_ID AKIAJ7EIGFFJQC475PBQ
ENV AWS_SECRET_KEY Tn94YZD+EoeWjk4aQ9BVCJvn3ld+/fe4csjiXsOW
ENV S3_BUCKET melidata-catalog-versions
ENV CATALOG_DSL_FILE ./catalog/catalog.groovy
ENV proxyHost 172.16.0.89 
ENV proxyPort 80


