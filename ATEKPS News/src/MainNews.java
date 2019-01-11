import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainNews {
		
		public static List<Articles> articles = new ArrayList<>();
		
		public static void main(String... strings) throws IOException {
			
			
			Document doc = Jsoup.connect("http://atekps.kz/news/").get();
			Elements elements = doc.getElementsByAttributeValue("class", "news-f-app2");
			
			elements.forEach(e->{
				Element aEl = e.child(0);
				String aHref = aEl.attr("href");
				String aText = aEl.text();
				String aDate = e.child(1).text();
				
				articles.add(new Articles(aText, aDate, "http://atekps.kz/"+aHref));
			});
			
			//articles.forEach(System.out::println);
			
			AppWin app = new AppWin();
			app.setVisible(true);
			
			//MoreClass more = new MoreClass("http://atekps.kz/news/sybailas-zhemkorlykka-karsimiz-2018.html");
			//more.setVisible(true);
		}
}
