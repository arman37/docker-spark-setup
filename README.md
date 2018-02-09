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
1. Pull Docker Image From DockerHub: Open a terminal and run this command `sudo docker pull mesosphere/spark` .
This may take a while to download the spark docker image.
2. Test Image Download: When image download completes, run this command `sudo docker images` .
If your screen looks like the screen shot below, that means you have successfully downloaded the spark docker image on your machine.
![Docker Images](/screenshots/sp1.jpg)

3. Clone docker-spark-setup Repo: Open another terminal and run this git command `git clone https://github.com/arman37/docker-spark-setup.git` .
After cloning completes, cd to docker-spark-setup directory ( `cd docker-spark-setup` ).

4. Packaging Driver Program: If you skipped prerequisite step 2 skip this step too. Otherwise follow along.
cd to driver-apps/java ( `cd driver-apps/java` ). After that, run maven command `mvn test` .
If your screen looks like the screen shot below, that means your maven test command successfully executed.
![maven build](/screenshots/sp2.png)

After that, run maven command `mvn package` .
your screen should look like the screen shot below
![maven package](/screenshots/sp3.png)

5. Running Docker Composer: If you followed step 4 then cd back to docker-spark-setup directory ( `cd ../..` ).
From docker-spark-setup directory run command `sudo docker-compose up` . Please make sure no other service on your machine using port 8080.
This command will run three docker container on your machine, your screen should look like the screen shot below
![maven package](/screenshots/sp4.png)

To check running docker containers run this command `sudo docker ps` .
your screen should look like the screen shot below
![maven package](/screenshots/sp5.png)

6. Open Container spark-worker-1 Bash: From any terminal run command `sudo docker exec -ti spark-worker-1 bash` .
your screen should look like the screen shot below
![maven package](/screenshots/sp6.png)
