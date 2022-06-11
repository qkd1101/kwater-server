package com.kwater.cicd;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class RestApiTask {

    @Scheduled(cron="* 0/60 * * * ?")
    public void test() {
        StringBuffer result = new StringBuffer();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        LocalTime now = LocalTime.now();

        //date
        String vdate = SDF.format(calendar.getTime());
        calendar.add(Calendar.DATE,-1);
        String tdate = SDF.format(calendar.getTime());
        calendar.add(Calendar.DATE,-364);
        String ldate = SDF.format(calendar.getTime());
        int vtime = now.getHour();

        try {
            String apiUrl = "http://apis.data.go.kr/B500001/dam/multiFunctionBarrierManagementpresentconditon/presentconditonlist?" +
                    "serviceKey=OTKwGzCz4ibTyutGgOl2ghUVuYQO13U47PEGTfIU6AUsbMT7cne5T9OxHOAyX%2BgS7og7ARlD8fsnT2umW1%2FWlA%3D%3D" + "" +
                    "&pageNo=1" +
                    "&numOfRows=10" +
                    "&tdate=" + tdate +
                    "&ldate=" + ldate +
                    "&vdate=" + vdate +
                    "&vtime=" + vtime +
                    "&_type=json";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            result.append("<xmp>");

            while((returnLine = bufferedReader.readLine()) != null) {
                System.out.println(returnLine);
            }

            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
