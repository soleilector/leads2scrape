// NOTE!
// Implement JavaFX for more accessible user interface
// 34 Layout
// Add more lead sources!!!
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Drive {
	private static JFrame mainMenuFrame = new JFrame() {{
		setSize(new Dimension(500,500));
		setTitle("Main Menu | Leads2Scrape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}};
	
	private static JLabel headerLabel = new JLabel("",JLabel.CENTER) {{
		setPreferredSize(new Dimension(500,240));
		setBackground(Color.BLACK);
		setForeground(Color.white);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setText("<html><p style='padding:25%;font-size:28px;margin-right:auto;margin-left:auto;'>Leads2Scrape</p><br><br>"
				+ "<p>Find credible and authentic businesses for your B2B service near you!</p></html>");
	}};
	
	private static JPanel headerPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,250));
		setBackground(Color.BLACK);
		//setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(headerLabel);
	}};
	
	private static JLabel keywordLabel = new JLabel("") {{
		setPreferredSize(new Dimension(150,25));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setForeground(Color.WHITE);
		setText("<html><p style='padding-left:50px;'>Keywords: </p></html>");
	}};
	
	private static JTextField keywordField = new JTextField() {{
		setPreferredSize(new Dimension(300,25));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		
	}};
	
	private static JPanel keywordPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,30));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(keywordLabel);
		add(keywordField);
	}};
	
	private static JLabel cityLabel = new JLabel("") {{
		setPreferredSize(new Dimension(150,25));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setForeground(Color.WHITE);
		setText("<html><p style='padding-left:50px;'>City: </p></html>");
	}};
	
	private static JTextField cityField = new JTextField() {{
		setPreferredSize(new Dimension(300,25));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		
	}};
	
	private static JPanel cityPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,30));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(cityLabel);
		add(cityField);
	}};
	
	private static JLabel stateLabel = new JLabel("") {{
		setPreferredSize(new Dimension(150,25));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setForeground(Color.WHITE);
		setText("<html><p style='padding-left:50px;'>State Code: </p></html>");
	}};
	
	private static JTextField stateField = new JTextField() {{
		setPreferredSize(new Dimension(50,25));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		
	}};
	
	private static JPanel statePanel = new JPanel() {{
		setPreferredSize(new Dimension(500,30));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(stateLabel);
		add(stateField);
	}};
	
	private static JLabel pathLabel = new JLabel("") {{
		setPreferredSize(new Dimension(150,25));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setForeground(Color.WHITE);
		setText("<html><p style='padding-left:50px;'>Path: </p></html>");
	}};
	
	private static JTextField pathField = new JTextField() {{
		setPreferredSize(new Dimension(300,25));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		
	}};
	
	private static JPanel pathPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,30));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(pathLabel);
		add(pathField);
	}};
	
	private static JPanel entryPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,150));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(keywordPanel);
		add(cityPanel);
		add(statePanel);
		add(pathPanel);
	}};
	
	private static JButton exportBTN = new JButton() {{
		setBackground(Color.yellow);
		setForeground(Color.BLACK);
		setText("<html><p style='font-size:24px;'>EXPORT</p></html>");
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setPreferredSize(new Dimension(400,50));
	}};
	
	private static JPanel exportPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,100));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		add(exportBTN,BorderLayout.CENTER);
	}};
	
	static JPanel mainPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		add(headerPanel);
		add(entryPanel);
		add(exportPanel);
	}};
	
	private static boolean canClickBTN = true;
	private static ActionListener pressBTN = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			exportBTN.setText("<html><p style='font-size:18px;'>LOADING</p></html>");
			Object thing = e.getSource();
			System.out.println("Button clicked...");
			if (!canClickBTN) { return; }
			canClickBTN = false;
			if (thing == exportBTN) {
				System.out.println("Export btn clicked...");
				if (keywordField.getText() == null || keywordField.getText().equals("")) {
					exportBTN.setText("<html><p style='font-size:18px;'>ENTER KEYWORDS</p></html>");
					canClickBTN = true;
					return;
				} else if (pathField.getText() == null || pathField.getText().equals("")) {
					exportBTN.setText("<html><p style='font-size:18px;'>ENTER EXPORT PATH</p></html>");
					canClickBTN = true;
					return;
				}
				
				System.out.println("Processing...");
				String linkA = "https://www.yellowpages.com/search?search_terms=%s";
				String linkB = "&geo_location_terms=%s, %s";
				String link = String.format(linkA, keywordField.getText())+String.format(linkB, cityField.getText(), stateField.getText());
				
				String paginationStr = "&page=%d";
				//int scrapeLimit = 5;
				Document doc; 
				int total = 0;
				
				// fetching the target website 
				//doc = Jsoup.connect(link).get();
				HashMap<String,String>[][] searchResults = getResults(link,3,paginationStr);

				WriteToCSV thisCSV = new WriteToCSV() {{
					nameData(keywordField.getText());
				}};
				for (int page=1;page<searchResults.length;++page) {
					HashMap<String,String>[] thisPage = searchResults[page];
					if (thisPage != null) {
						for (int bizId = 1;bizId<thisPage.length;++bizId) {
							HashMap<String,String> bizInfo = thisPage[bizId];
							
							if (bizInfo!=null) {
								thisCSV.addRecord(total, bizInfo);
								System.out.printf("%d) %s\n\tPhone: %s\n\tWebsite: %s %s\n\tAddress: %s\n",
										bizId,
										bizInfo.get("name"),
										bizInfo.get("phone"),
										bizInfo.get("websiteDown"),
										bizInfo.get("website"),
										bizInfo.get("streetAddress")+" "+bizInfo.get("locality"));
								total ++;
							}
						}
					}
					thisCSV.publishData(pathField.getText());
				}
				
				exportBTN.setText("<html><p style='font-size:24px;'>EXPORT</p></html>");
				
			}
			canClickBTN = true;
		}
	};
	
	public static void main(String[] args) {
		exportBTN.addActionListener(pressBTN);
		mainMenuFrame.add(mainPanel);
		mainMenuFrame.setVisible(true);
		
		Scanner input = new Scanner(System.in);
		System.out.print("YELLOW PAGES SCRAPER\nKeywords: ");
		String keywords = input.nextLine(); //"Detroit";
		//keywords = keywords.replaceAll(" ","+");
		
		System.out.print("City: ");
		String city = input.nextLine(); //"Detroit";
		
		System.out.print("State Code: ");
		String stateCode = input.nextLine(); //"MI";
		
		System.out.println("Do Pagination (y/n)");
		boolean doPagination = (input.nextLine().equals("y") ? true : false);
		
		String linkA = "https://www.yellowpages.com/search?search_terms=%s";
		String linkB = "&geo_location_terms=%s, %s";
		String link = String.format(linkA, keywords)+String.format(linkB, city, stateCode);
		
		String paginationStr = "&page=%d";
		//int scrapeLimit = 5;
		Document doc; 
		int total = 0;
		
		// fetching the target website 
		//doc = Jsoup.connect(link).get();
		HashMap<String,String>[][] searchResults;
		
		if (doPagination) { // if we are doing pagination
			System.out.print("Pagination; Scrape Pages Limit:");
			int scrapeLimit = Integer.parseInt(input.nextLine());
			
			System.out.println("Loading...");
			searchResults = getResults(link,scrapeLimit,paginationStr);			
		} else { searchResults = getResults(link); }

		WriteToCSV thisCSV = new WriteToCSV() {{
			nameData("keywords");
		}};
		for (int page=1;page<searchResults.length;++page) {
			HashMap<String,String>[] thisPage = searchResults[page];
			if (thisPage != null) {
				for (int bizId = 1;bizId<thisPage.length;++bizId) {
					HashMap<String,String> bizInfo = thisPage[bizId];
					
					if (bizInfo!=null) {
						thisCSV.addRecord(total, bizInfo);
						System.out.printf("%d) %s\n\tPhone: %s\n\tWebsite: %s %s\n\tAddress: %s\n",
								bizId,
								bizInfo.get("name"),
								bizInfo.get("phone"),
								bizInfo.get("websiteDown"),
								bizInfo.get("website"),
								bizInfo.get("streetAddress")+" "+bizInfo.get("locality"));
						total ++;
					}
				}
			}
			thisCSV.publishData("");
		}
	}
	
	public static Document attemptPageAccess(String url) { // attempt to access a url
		try {
			Document doc = Jsoup 
					.connect(url) 
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36") 
					.header("Accept-Language", "*")
					.timeout(30*1000)
					.get();
			return doc;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static HashMap<String,String>[][] getResults(String link) { // overloaded get results (just link)
		return getResults(link,0,null);
	}
	
	public static HashMap<String,String>[][] getResults(String link,int paginationLimit, String paginationStr) { // get results pagination
		final int prodLimit = 1000;
		HashMap<String,String>[][] finalResults = new HashMap[paginationLimit+2][prodLimit];
		
		if (paginationLimit>0) {
			for (int x=1;x<paginationLimit;++x) { // for each page
				String page = String.format(paginationStr, x);
				String url = link+page;
				HashMap<String,String>[] pageResults = scrapePage(url);
				
				if (pageResults!=null) {
					finalResults[x] = pageResults;
				} else {
					finalResults[x] = null;
				}
			}
			return finalResults;
		} else {
			String url = link;
			HashMap<String,String>[] pageResults = scrapePage(url);
			
			if (pageResults!=null) {
				System.out.println("\t\tadding page results");
				finalResults[1] = pageResults;
			} else {
				System.out.println("\t\tpage results null...");
				finalResults[1] = null;
			}
			
			return finalResults;
		}
	}
	
	public static HashMap<String,String>[] scrapePage(String url) { // scrape a page for its leads
		int prodLimit = 100;
		HashMap<String,String>[] pageResults = new HashMap[prodLimit];
		Document doc = attemptPageAccess(url);
		System.out.println(url);
		
		if (doc!=null) { // page exists and successfully accessed
			Elements targetElements = doc.select("div.result"); // elements we are going to target for scraping
			
			// initializing the list of Java object to store 
			// the scraped data 
			HashMap<String,PageElement> pageElements = new HashMap<>(); // for storing our elements
			
			// iterating over the list of HTML products 
			System.out.print(String.format("Found %d elements....\n",targetElements.size()));
			int thisct = 1;
			
			for (Element thisBiz : targetElements) { // for each element we found
				Element infoElement = thisBiz.selectFirst("div.srp-listing").selectFirst("div.v-card").selectFirst("div.info");
				
				Element secondaryInfoElement = infoElement.selectFirst("div.info-secondary");
				Element phoneElement = secondaryInfoElement.selectFirst("div.phone");
				Element addressElement = secondaryInfoElement.selectFirst("div.adr");
				Element localityElement = (addressElement!=null) ? addressElement.selectFirst("div.locality") : null;
				Element streetAddrElement = (addressElement!=null) ? addressElement.selectFirst("div.street-address") : null; 
				
				Element mainInfoElement = infoElement.selectFirst("div.info-primary");
				Element bizNameElement = mainInfoElement.selectFirst("h2.n").selectFirst("a.business-name");
				
				Element linksElement = mainInfoElement.selectFirst("div.links");
				Element websiteElement = linksElement.selectFirst("a.track-visit-website");
				Element directionsElement = linksElement.selectFirst("a.track-map-it");
				Element menuElement = linksElement.selectFirst("menu");
				Element moreInfoElement = linksElement.selectFirst("a.track-more-info");
				
				boolean hasWebsite = (websiteElement!=null);
				boolean hasDirections = (directionsElement!=null);
				boolean hasMenu = (menuElement!=null);
				boolean hasMoreInfoElement = (moreInfoElement!=null);
				
				if (hasDirections || hasWebsite || hasMenu) { // Only want legitimate businesses
					pageResults[thisct] = new HashMap<String,String>();
					pageResults[thisct].put("name", bizNameElement.text());
					pageResults[thisct].put("phone", phoneElement.text());
					pageResults[thisct].put("website", (hasWebsite ? websiteElement.attr("href") : "none"));
					pageResults[thisct].put("websiteDown", ((pageResults[thisct].get("website").equals("none") ? "" : ((attemptPageAccess(websiteElement.attr("href"))!=null) ? "[Up] " : " [Down] "))));
					
					if (addressElement!=null) {
						pageResults[thisct].put("locality",(localityElement!=null ? localityElement.text() : " "));
						pageResults[thisct].put("streetAddress", (streetAddrElement!=null ? streetAddrElement.text() : ""));
					}
					
				System.out.println("\tcreating new biz record");
					
					++thisct;
				}
			}
			return pageResults; // return the results of this page
		}
		return null;
	}

}
