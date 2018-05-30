import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

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
            Map<String, Object> model = new HashMap<>();
            int height = Integer.parseInt(req.queryParams("height"));
            int width = Integer.parseInt(req.queryParams("width"));
            Rectangle newRectangle = new Rectangle(height, width);
            model.put("newRectangle", newRectangle);

            if (newRectangle.getShape()) {
                Cube newCube = new Cube(newRectangle);
                model.put("newCube", newCube);
            }

            return new ModelAndView(model, "rectangle-details.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
