package org.example.backend.RestClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping(value = "clockclient")
public class WorldCloclClientController {
    private static final String server_url = "http://worldclockapi.com/api/json/utc/now";

    @ResponseBody
    @GetMapping
    public static void getUTCTime() throws Exception {
        URL url = new URL(server_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.flush();
        out.close();
    }
}
