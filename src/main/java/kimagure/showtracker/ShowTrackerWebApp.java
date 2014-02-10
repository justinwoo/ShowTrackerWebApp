package kimagure.showtracker;

import com.google.gson.Gson;
import kimagure.showtracker.embermodels.EmberShow;
import kimagure.showtracker.embermodels.EmberShows;
import kimagure.showtracker.models.Show;
import kimagure.showtracker.service.ShowService;
import kimagure.showtracker.transformer.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

import static spark.Spark.*;

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
    private static Gson gson;

    public static void main(String[] args) {
        logger = LoggerFactory.getLogger(ShowTrackerWebApp.class);
        showService = new ShowService();
        gson = new Gson();

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
                List<Show> listShows= showService.getAllShows();
                emberShows.setShows(listShows);
                return emberShows;
            }
        });

        put(new JsonTransformer("/shows/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params("id"));
                String body = request.body();
                EmberShow emberShow = gson.fromJson(body, EmberShow.class);
                Show show = emberShow.getShow();
                show.setId(id);
                showService.updateShow(show);
                return show;
            }
        });

        post(new JsonTransformer("/shows") {
            @Override
            public Object handle(Request request, Response response) {
                String body = request.body();
                EmberShow emberShow = gson.fromJson(body, EmberShow.class);
                Show show = emberShow.getShow();
                showService.insertShow(show);
                return emberShow;
            }
        });

        delete(new Route("/shows/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params("id"));
                showService.deleteShow(id);
                return "";
            }
        });
    }
}
