package pl.jazapp.app;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("average")
public class AppServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var writer = resp.getWriter();

        if (!(req.getParameterMap().containsKey("numbers"))) {
            resp.setStatus(200);
            resp.setContentType("text/plain");
            writer.println("Please put parameters");
            return;
        }

        String[] requestNumbers = req.getParameterValues("numbers");

        if (!(requestNumbers.length < 1) && requestNumbers[0].length() > 0) {
            String numbers = requestNumbers[0];
            List<Integer> numbersList = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Float averageNumber = calculateAverage(numbersList);

            DecimalFormat df = new DecimalFormat("0.##");
            df.setRoundingMode(RoundingMode.HALF_UP);
            resp.setStatus(200);
            resp.setContentType("text/plain");
            writer.println(df.format(averageNumber));

            return;
        }

        resp.setStatus(200);
        resp.setContentType("text/plain");
        writer.println("Please put parameters");
    }

    private Float calculateAverage(List<Integer> numbers) {
        Float average = (float) 0;
        for (Integer number : numbers) {
            average += number;
        }
        average /= numbers.size();

        return average;
    }
}
