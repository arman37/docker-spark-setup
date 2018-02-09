# Docker Spark setup

> A Docker Spark environment setup with a Java driver program.

The idea is to demonstrate how to to setup an apache spark environment with docker container and a Java driver application to test on one container.


# Complete Stack #

* [Docker](https://www.docker.com)
* [Apache Spark](https://spark.apache.org)
* [Apache Maven](https://maven.apache.org)
* [Java](http://www.oracle.com/technetwork/java/index.html)

# Prerequisites #
1. Install Docker(to install docker on your machine go to [Docker Setup](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-16-04) page).
2. Install Apache Maven(Skip this step if you just want to run the already existing jar file, otherwise follow this [Maven Setup](https://maven.apache.org/install.html) page).

STEPS TO RUN
========
1. Open a terminal and run this command `sudo docker pull mesosphere/spark` .
