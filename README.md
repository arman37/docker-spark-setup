# Docker Spark setup

> A Docker Spark environment setup with a Java driver program.

The idea is to demonstrate how to to setup an apache spark environment with docker container and a Java driver application to test on one container.


### Complete Stack

* [Docker](https://www.docker.com)
* [Docker Compose](https://docs.docker.com/compose)
* [Apache Spark](https://spark.apache.org)
* [Apache Maven](https://maven.apache.org)
* [Java](http://www.oracle.com/technetwork/java/index.html)

### Prerequisites
1. Install Docker(to install docker on your machine go to [Docker Setup](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-16-04) page).
2. Install Docker Compose(to install docker compose on your machine go to [Docker Compose Setup](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-14-04) page).
3. Install Apache Maven(Skip this step if you just want to run the already existing jar file, otherwise follow this [Maven Setup](https://maven.apache.org/install.html) page).

### STEPS TO RUN
1. Pull Docker Image From DockerHub: Open a terminal and run this command `sudo docker pull mesosphere/spark` .
This may take a while to download the spark docker image.
2. Test Image Download: When image download completes, run this command `sudo docker images` .
If your screen looks like the screen shot below, that means you have successfully downloaded the spark docker image on your machine.
![Docker Images](/screenshots/sp1.jpg)

3. Clone docker-spark-setup Repo: Open another terminal and run this git command `git clone https://github.com/arman37/docker-spark-setup.git` .
After cloning completes, cd to docker-spark-setup directory ( `cd docker-spark-setup` ).

4. Packaging Driver Program: If you skipped prerequisite step 3, skip this step too. Otherwise follow along.
cd to driver-apps/java ( `cd driver-apps/java` ). After that, run maven command `mvn test` .
If your screen looks like the screen shot below, that means your maven test command successfully executed.
![maven build](/screenshots/sp2.png)

After that, run maven command `mvn package` .
your screen should look like the screen shot below
![maven package](/screenshots/sp3.png)

5. Running Docker Compose: If you followed step 4 then cd back to docker-spark-setup directory ( `cd ../..` ).
From docker-spark-setup directory run command `sudo docker-compose up` . Please make sure no other service on your machine using port 8080.
This command will run three docker container on your machine, your screen should look like the screen shot below
![maven package](/screenshots/sp4.png)

To check running docker containers run this command `sudo docker ps` .
your screen should look like the screen shot below
![maven package](/screenshots/sp5.png)

6. Open Container spark-worker-1 Bash: From any terminal run command `sudo docker exec -ti spark-worker-1 bash` .
your screen should look like the screen shot below
![maven package](/screenshots/sp6.png)

7. Deploy Driver App: From that terminal run this command `./bin/spark-submit --class com.dsi.spark.SortingTask /usr/spark-2.2.1/jars/sorting-1.0-SNAPSHOT.jar /usr/spark-2.2.1/test/resources/random-numbers.txt` .
your screen should look like the screen shot below
![maven package](/screenshots/sp7.png)

Here we have sorted 100,000 numbers of random integer values ranging from 13 to 76,531 and saved the sorted numbers to a directory named [some-random-numbers]-sorted-output in dist directory.

8. Test Sorting Result: From the same terminal run command `ls` .
you'll see a directory named [some-random-numbers]-sorted-output. cd to this directory ( like `cd 1518166289584-sorted-output` ).
Into that directory you'll see part-00000 text file.
your screen should look like the screen shot below
![maven package](/screenshots/sp8.png)

Now run this command `cat part-00000` .
your screen should look like the screen shot below
![maven package](/screenshots/sp9.png)

Congratulations!!! you have successfully deployed a spark driver application. (Y) :)

### License

[MIT licensed](./LICENSE)
