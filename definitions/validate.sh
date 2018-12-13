#!/bin/bash

version=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f2)
if [ $version -lt "8" ]; then
  echo "Java 1.8 or higher is required."
  echo "Please set JAVA_HOME env correctly"
  exit 1
fi

certs=$(for i in ../certificateChain_elb.pem ../trustedCertificates_elb.pem; do keytool -importcert -file $i -alias "presto_$i" -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit -noprompt; done)

./gradlew validate -q -Pargs="$*"
