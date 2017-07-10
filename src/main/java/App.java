import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by staff on 7/10/17.
 */
public class App {
    public static void main(String[] args) {

        get("/", (req, res) -> {
            Map<String, ArrayList<Rectangle>> model = new HashMap<>();
            ArrayList myRectangleArrayList = Rectangle.getAll();
            model.put("myRectangles", myRectangleArrayList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/rectangles/new", (req, res) -> {
            Map<String, ArrayList<Rectangle>> model = new HashMap<>();
            int height = Integer.parseInt(req.queryParams("height"));
            int width = Integer.parseInt(req.queryParams("width"));
            Rectangle myRectangle = new Rectangle(height, width); //as we know this will automatically add itself to a list of all rectangles.
            res.redirect("/"); //send user to root route. Cool eh!
            return null; //gotta send back something otherwise we get an error.
        });
    }
}
