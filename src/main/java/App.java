import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;

/**
 * Created by staff on 7/10/17.
 */
public class App {
    public static void main(String[] args) {

        get("/", (req, res) -> {
            //just for testing - make two new objects so we have something to retrieve
            Rectangle rectangle = new Rectangle(3,2);
            Rectangle squareRectangle = new Rectangle(12, 12);

            Map<String, ArrayList<Rectangle>> model = new HashMap<>();
            ArrayList myRectangleArrayList = Rectangle.getAll();
            model.put("myRectangles", myRectangleArrayList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
