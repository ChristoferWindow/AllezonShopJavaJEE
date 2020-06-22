package pl.jazapp.app;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.UUID;

@WebServlet("average")

public class AverageServlet extends HttpServlet {
    @Inject
    private UserContext userContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");

        var writer = resp.getWriter();

        if(req.getParameterMap().size() != 0){
            var numbers = req.getParameter("numbers");

            double wynik = 0;
            var i = 0;

            var numbersSplit = numbers.split(",");

            for(; i < numbersSplit.length; i++){
                wynik += Double.parseDouble(numbersSplit[i]);
            }

            wynik = wynik/i;

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);
            var halfUp = df.format(wynik);
            BigDecimal result = new BigDecimal(halfUp).stripTrailingZeros();



            writer.println("Average equals: " + result );
        } else {
            writer.println("Please put parameters.");
        }

        if(userContext.getUserId() == null){
            userContext.logIn(new Random().nextLong());
        }

    }
}
