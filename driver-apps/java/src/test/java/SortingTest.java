import org.junit.Test;
import com.dsi.spark.SortingTask;

import java.net.URISyntaxException;

public class SortingTest {
  @Test
  public void test() throws URISyntaxException {
    String inputFile = getClass().getResource("random-numbers.txt").toURI().toString();
    new SortingTask().run(inputFile);
  }
}
