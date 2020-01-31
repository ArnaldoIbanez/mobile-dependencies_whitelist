FROM ubuntu:14.04

MAINTAINER Alexis Petalas, Gabriel Eisbruch <arquitectura@mercadolibre.com>

#ENV http_proxy http://proxy.meliglobal.com
#ENV https_proxy http://proxy.meliglobal.com

RUN sed 's/main$/main universe/' -i /etc/apt/sources.list
RUN apt-get update && apt-get install -y software-properties-common python-software-properties python python-pip python-dev build-essential
RUN pip install --upgrade pip
RUN pip install --upgrade virtualenv
RUN add-apt-repository ppa:webupd8team/java -y

# Install Java
RUN apt-get update
RUN apt install -y openjdk-8-jre-headless

#Instal make
RUN apt-get -y install make git-core unzip


#DEPRECATED (set in build.gradle)
#ENV CAT_AWS_ACCESS_KEY_ID AKIAJ7EIGFFJQC475PBQ
#ENV CAT_AWS_SECRET_KEY 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
#ENV CATALOG_S3_BUCKET melidata-catalog-versions
#ENV CATALOG_DSL_FILE ./src/main/resources/catalog/catalog.groovy
ENV CATALOG_FILE /var/cache/drone/src/github.com/mercadolibre/melidata-catalog/definitions/catalog.csv

ENV PRESTO_CATALOG_S3_BUCKET /melidata-jobs/catalog/
ENV PRESTO_AWS_ACCESS_KEY_ID AKIAIRJ4DFA72UDCX7QA
ENV PRESTO_AWS_SECRET_KEY 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

#ENV METRICS_DSL_DIR ./src/main/resources/metrics/
#ENV METRICS_S3_BUCKET melidata-jobs

ENV proxyHost 172.16.0.89
ENV proxyPort 80
#Install gradle
WORKDIR /tmp/fake_app
ADD fake_app /tmp/fake_app
RUN cd /tmp/fake_app
RUN ./gradlew cacheDependencies
