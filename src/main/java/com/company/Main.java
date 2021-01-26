package com.company;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Hashtable;
import java.util.Set;

public class Main {


    private static String POST_API_URL = "https://data.42matters.com/api/v2.0/ios/apps/reviews.json?access_token=a2b4d14ca0d5440f110a4491a2c0d8dcf5a064fa&id=429047995&start_date=2019-01-01&end_date=2019-01-31&lang=en&limit=100&page=1";


    public static void main(String[] args) throws IOException, InterruptedException {

        Hashtable<String, Application> hashtable = new Hashtable<String, Application>();
        hashtable.put("Pinterest", new Application("Pinterest",1, 1, "429047995"));
        hashtable.put("Youtube", new Application("Youtube",2, 1,"544007664"));
        hashtable.put("Tiktok", new Application("Tiktok",3, 1, "835599320"));

        hashtable.put("Whatsapp", new Application("Whatsapp",1, 2, "310633997"));
        hashtable.put("Facebook", new Application("Facebook",2, 2, "284882215"));
        hashtable.put("Messenger", new Application("Messenger",3, 2, "454638411"));

        hashtable.put("Hulu", new Application("Hulu",1, 3, "376510438"));
        hashtable.put("Roblox", new Application("Roblox",2, 3, "431946152"));
        hashtable.put("Spotify", new Application("Spotify",3, 3,"324684580"));

        hashtable.put("Outlook", new Application("Outlook",1, 4, "951937596"));
        hashtable.put("Google Docs", new Application("Google Docs",2, 4, "842842640"));
        hashtable.put("Google Drive", new Application("Google Drive",3, 4, "507874739"));

        hashtable.put("Uber Eats", new Application("Uber Eats",1, 5, "1058959277"));
        hashtable.put("Wish", new Application("Wish",2, 5, "530621395"));
        hashtable.put("Google Maps", new Application("Google Maps",3, 5, "585027354"));

        Set<String> keys = hashtable.keySet();
        String[] years = new String[2];

        years[0] = "2019";
        years[1] = "2020";

        String[] months = new String[12];

        months[0] = "01";
        months[1] = "02";
        months[2] = "03";
        months[3] = "04";
        months[4] = "05";
        months[5] = "06";
        months[6] = "07";
        months[7] = "08";
        months[8] = "09";
        months[9] = "10";
        months[10] = "11";
        months[11] = "12";

        for(String key : keys){

            for(String year : years){

                for(int i = 0; i < 12; i++){


                    for(int page = 1; page < 2; page++){


                        if(i == 11){
                            POST_API_URL =  "https://data.42matters.com/api/v2.0/ios/apps/reviews.json?access_token=d8713941107686b4bd76c33469db92126c44d469&"+
                                    "id=" + hashtable.get(key).getAppUUID()+ "&"+
                                    "start_date="+ year+ "-" + months[i] + "-01&end_date=" + year +"-" + months[i] + "-31&lang=en&limit=100&page="+ page;
                        }else{
                            POST_API_URL =  "https://data.42matters.com/api/v2.0/ios/apps/reviews.json?access_token=d8713941107686b4bd76c33469db92126c44d469&"+
                                    "id=" + hashtable.get(key).getAppUUID()+ "&"+
                                    "start_date="+ year+ "-" + months[i] + "-00&end_date=" + year +"-" + months[i] + "-27&lang=en&limit=100&page="+ page;
                        }

                        System.out.println(POST_API_URL);

                        HttpClient httpClient = HttpClient.newHttpClient();
                        HttpRequest httpRequest = HttpRequest.newBuilder()
                                .GET()
                                .header("accept", "application/json")
                                .uri(URI.create(POST_API_URL))
                                .build();

                        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                        System.out.println(response.body());

                        ObjectMapper objectMapper = new ObjectMapper();
                        DTO newDto = objectMapper.readValue(response.body(), new TypeReference<DTO>() {
                        });

                       try {
                           Connection connection = null;
                           PreparedStatement stmt = null;
                           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5435/postgres", "postgres", "postgres");
                           int  counter = 0;
                          for(Reviews reviews : newDto.getReviews()) {
                              stmt = connection.prepareStatement("INSERT INTO reviews (category_id, app_id, author_id, title, rating, content, date) VALUES" +
                                       " (?, ?, ? ,?, ?, ?, ?)");
                              stmt.setInt(1, hashtable.get(key).getAppId());
                               stmt.setInt(2, hashtable.get(key).getCategoryId());
                               stmt.setString(3, reviews.getAuthor_id());
                               stmt.setString(4, reviews.getTitle());
                               stmt.setInt(5,Integer.parseInt(reviews.getRating()));
                               stmt.setString(6, reviews.getContent());
                               stmt.setString(7, reviews.getDate());
                               stmt.execute();
                               counter++;
                               stmt.close();
                              //     Thread.sleep(200);
                          }
                           System.out.println(counter);
                           connection.close();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                }
            }
        }
    }
}
