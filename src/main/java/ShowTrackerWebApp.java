import spark.*;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 12:08 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerWebApp {
    static Logger logger;

    public static void main(String[] args) {
        logger = LoggerFactory.getLogger(ShowTrackerWebApp.class);

        staticFileLocation("/public");

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World";
            }
        });
    }
}
