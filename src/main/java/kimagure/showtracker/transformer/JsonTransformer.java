package kimagure.showtracker.transformer;

import com.google.gson.Gson;
import spark.ResponseTransformerRoute;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 1:12 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public abstract class JsonTransformer extends ResponseTransformerRoute {

    private Gson gson = new Gson();

    protected JsonTransformer(String path) {
        super(path, "application/json");
    }

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
