FROM hub.furycloud.io/mercadolibre/java:1.8-mini

# Default value in image is "build".
# Override the following env variable to call another task for packaging your app
ENV GRADLE_PACKAGE="bootRepackage"

ENV GRADLE_PACKAGE_PATH="/tmp/definitions/*.war"

# Default value in image is "test jacocoTestReport".
# Override the following env variable to call another task for testing your app
ENV GRADLE_TEST="test jacocoTestReport"


# Default value in image is "check".
# Override the following env variable to call another task for running your app when using "fury run"
ENV GRADLE_RUN="bootRun"


# Make sure to add your CodeCov token!
##### CODECOV #####
ENV CODECOV_TOKEN=""

ADD ./commands/test.sh /commands/test.sh
RUN chmod a+x /commands/test.sh

#ADD ./commands/execute_after_test.sh /commands/execute_after_test.sh
#RUN chmod a+x /commands/execute_after_test.sh

ADD ./commands/execute_before_package.sh /commands/execute_before_package.sh
RUN chmod a+x /commands/execute_before_package.sh

ADD ./commands/execute_after_package.sh /commands/execute_after_package.sh
RUN chmod a+x /commands/execute_after_package.sh
