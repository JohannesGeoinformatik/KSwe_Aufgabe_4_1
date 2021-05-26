package de.hsbo.kswe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(value="/weather", name="WeatherServlet")
public class WeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        Weather wetterdaten = new Weather(city);
        
        ObjectMapper mapper = new ObjectMapper();
        
        String jsonString = mapper.writeValueAsString(wetterdaten);     
      
    	resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().print(jsonString);
    }

}
