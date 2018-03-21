package com.dsi.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.hadoop.mapred.FileAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.*;
import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * SortingTask class, we will call this class with the test SortingTest.
 */
public class SortingTask {

  /**
   * We use a logger to print the output. Sl4j is a common library which works with log4j, the
   * logging system used by Apache Spark.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(SortingTask.class);

  /**
   * This is the entry point when the task is called from command line with spark-submit.sh.
   * See {@see http://spark.apache.org/docs/latest/submitting-applications.html}
   */
  public static void main(String[] args) {
    System.out.println("Received argument: " + args[0]);
    checkArgument(args.length > 0, "Please provide the path of input file as first parameter.");
    new SortingTask().run(args[0]);
  }

  /**
   * The task body
   */
  public void run(String inputFilePath) {
    /*
     * This is the address of the Spark cluster. We will call the task from SortingTest and we
     * use a local standalone cluster. [*] means use all the cores available.
     * See {@see http://spark.apache.org/docs/latest/submitting-applications.html#master-urls}.
     */
    String master = "local[4]";

    /*
     * Initialises a Spark context.
     */
    SparkConf conf = new SparkConf()
        .setAppName(SortingTask.class.getName())
        .setMaster(master);
    JavaSparkContext context = new JavaSparkContext(conf);

    /*
     * Performs a number sorting sequence of tasks and save the output to an external file.
     */
    JavaRDD<String> distData;
    JavaRDD<Integer> sortedData;
    JavaRDD<Integer> formattedData;

    String outputDirName;
    long nowInMillis;

    distData = context.textFile(inputFilePath);
    formattedData = distData
                      .flatMap(text -> Arrays.asList(text.split(",")).iterator())
                      .map(str -> Integer.parseInt(str.trim()));
    distData = null;

    sortedData = formattedData.sortBy(num -> num, true, 0);
    formattedData = null;

    nowInMillis = Calendar.getInstance().getTimeInMillis();
    outputDirName = nowInMillis + "-sorted-output";
    sortedData.saveAsTextFile(outputDirName);
    sortedData.foreach(num -> System.out.println(num));

    System.out.println("Sorted result has been saved as a text file in a directory named " + outputDirName + " in your project root directory.");

    //LOGGER.info(String.format("Sorting took [%d] milliseconds to complete.", sortingTimeInMillis));
  }
}
