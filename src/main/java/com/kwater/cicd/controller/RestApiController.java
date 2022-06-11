package com.kwater.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class RestApiController {

    @GetMapping("/apiRequest")
    public String callApiWithXml() {
        StringBuffer result = new StringBuffer();
        try {
            String apiUrl = "http://apis.data.go.kr/B500001/dam/multiFunctionBarrierManagementpresentconditon/presentconditonlist?" +
                    "serviceKey=OTKwGzCz4ibTyutGgOl2ghUVuYQO13U47PEGTfIU6AUsbMT7cne5T9OxHOAyX%2BgS7og7ARlD8fsnT2umW1%2FWlA%3D%3D" + "" +
                    "&pageNo=1" +
                    "&numOfRows=10" +
                    "&tdate=2018-08-19" +
                    "&ldate=2017-08-20" +
                    "&vdate=2018-08-20" +
                    "&vtime=07" + "" +
                    "&_type=json";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            result.append("<xmp>");

            while((returnLine = bufferedReader.readLine()) != null) {
//                System.out.println(returnLine);
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "</xmp>";
    }
}
