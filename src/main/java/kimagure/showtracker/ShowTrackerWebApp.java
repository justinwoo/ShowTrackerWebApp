package kimagure.showtracker;

import kimagure.showtracker.embermodels.EmberShows;
import kimagure.showtracker.models.Show;
import kimagure.showtracker.service.ShowService;
import spark.*;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kimagure.showtracker.transformer.JsonTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 12:08 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerWebApp {
    private static Logger logger;
    private static ShowService showService;

    public static void main(String[] args) {
        logger = LoggerFactory.getLogger(ShowTrackerWebApp.class);
        showService = new ShowService();

        staticFileLocation("/public");

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World";
            }
        });

        get(new JsonTransformer("/shows") {
            @Override
            public Object handle(Request request, Response response) {
                EmberShows emberShows = new EmberShows();
//                Show show = new Show();
//                show.setId(1);
//                show.setEpisode(1);
//                show.setTitle("我妻と幸せの日々");
//                List<Show> listShows = new ArrayList<>();
//                listShows.add(show);
                List<Show> listShows = showService.getAllShows();
                emberShows.setShows(listShows);
                return emberShows;
            }
        });
    }
}
