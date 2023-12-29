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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Drive {
	private static JFrame mainMenuFrame = new JFrame() {{
		setSize(new Dimension(500,500));
		setTitle("Main Menu | Leads2Scrape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}};
	
	// 	SPLASH
	
	//-- splash panel
				 
		private static ImageIcon loading = new ImageIcon("src/loader.gif");
		
		private static JLabel splashLoadingLabel = new JLabel("", loading, JLabel.CENTER) {{
			setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
			setPreferredSize(new Dimension(500,500));
			setBackground(Color.white);
		}};
		
		public static JPanel splashPanel = new JPanel() {{
			setPreferredSize(new Dimension(500,500));
			setBackground(Color.white);
			setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
			add(splashLoadingLabel);
			setVisible(false);
		}};
		
		
	// MAIN PANEL
	
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
	
	//File file = new File(home+"/Downloads/" + fileName + ".txt"); 
	private static JTextField pathField = new JTextField() {{
		setPreferredSize(new Dimension(300,25));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setText(System.getProperty("user.home")+"\\Downloads\\");
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
	
	// results Panel
	
	static JButton resultsExportDataBTN = new JButton() {{
		setPreferredSize(new Dimension(100,30));
		setText("Export");
		setBackground(Color.green);
		setBorder(null);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setFocusPainted(false);
		setBounds(0, 0, 100, 30);
	}};
	
	static JLabel resultsTitleLbl = new JLabel("Results",JLabel.CENTER) {{ // the title label of the results panel
		setPreferredSize(new Dimension(300,100)); // preferred size of the results title label
		setFont(new Font("Lucida Console",Font.BOLD,18)); // set font sisze of the window
		setLayout(new FlowLayout(FlowLayout.CENTER,50,0)); // set the layout of the results title label
		setBackground(Color.black);
	}};
	
	static JButton backToMainBTN = new JButton() {{
		setPreferredSize(new Dimension(100,30));
		setText("Refine Filter");
		setBackground(Color.white);
		setBorder(null);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setFocusPainted(false);
	}};
	
	static JPanel resultsToolbarPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,100));
		setBackground(Color.CYAN);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(backToMainBTN);
		add(resultsTitleLbl);
		add(resultsExportDataBTN);
	}};
	
	static JButton resultsNextPage = new JButton() {{
		setPreferredSize(new Dimension(50,50));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.black);
		setText("N");
	}};
	
	static JButton resultsPreviousPage = new JButton() {{
		setPreferredSize(new Dimension(50,50));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.black);
		setText("P");
	}};
	
	static JButton resultsInfo = new JButton() {{
		setPreferredSize(new Dimension(50,50));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.black);
		setForeground(Color.white);
		setText("I");
	}};
	
	static JPanel resultsViewToolbar = new JPanel() {{
		setPreferredSize(new Dimension(50,400));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.red);
		add(resultsPreviousPage);
		add(resultsNextPage);
		add(resultsInfo);
	}};
	
	static JLabel bizInfoLabel = new JLabel() {{
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.white);
		setPreferredSize(new Dimension(450,100));
	}};
	
	static JPanel bizInfoPanel = new JPanel() {{
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.magenta);
		setPreferredSize(new Dimension(450,400));
		add(bizInfoLabel);
		setVisible(false);
	}};
	
	static JPanel resultsListPanel = new JPanel() {{
		setPreferredSize(new Dimension(450,400));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.green);
	}};
	
	static JPanel resultsViewPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,400));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.white);
		add(resultsViewToolbar);
		add(resultsListPanel);
		add(bizInfoPanel);
	}};
	
	static JPanel resultsPanel = new JPanel() {{
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.black);
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(resultsToolbarPanel);
		//add(resultsDisplayAmountPanel);
		add(resultsViewPanel);
	}};
	
	static JPanel exportButton = new JPanel() {{
		
	}};
	
	static JPanel appView = new JPanel() {{
		setPreferredSize(new Dimension(500,500));
		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		add(mainPanel);
		add(resultsPanel);
		add(splashPanel);
		setVisible(true);
	}};
	
	private static HashMap<String,String>[][] searchResults = null;
	private static ArrayList<HashMap<String,String>>[] paginatedResults = null;
	private static int currentResultsPage = 0;
	
	private static HashMap<String, String> lastBizInformation;
	private static boolean canClickBTN = true;
	
	//private static 
	
	private static ActionListener pressBTN = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object thing = e.getSource();
			System.out.println("Button clicked...");
			if (!canClickBTN) { return; }
			canClickBTN = false;
			
			
			if (thing == exportBTN) {
				System.out.println("Export btn clicked...");
				
				resultsPanel.setVisible(false);
				mainPanel.setVisible(false);
				splashPanel.setVisible(true);
				
				if (keywordField.getText() == null || keywordField.getText().equals("")) {
					exportBTN.setText("<html><p style='font-size:18px;'>ENTER KEYWORDS</p></html>");
					canClickBTN = true;
					return;
				} else if (pathField.getText() == null || pathField.getText().equals("")) {
					exportBTN.setText("<html><p style='font-size:18px;'>ENTER EXPORT PATH</p></html>");
					canClickBTN = true;
					return;
				}
				
				exportBTN.setText("<html><p style='font-size:18px;'>LOADING</p></html>");
				
				searchResults = null;
				paginatedResults = null;
				currentResultsPage = 0;
				
				String linkA = "https://www.yellowpages.com/search?search_terms=%s";
				String linkB = "&geo_location_terms=%s,%s";
				String link = String.format(linkA,
							keywordField.getText()) + String.format(linkB, cityField.getText(), stateField.getText()
						);
				
				String paginationStr = "&page=%d";
				int pagesToScrape = 1;
				
				System.out.println("Testing...");
				
				searchResults = getResults(link,pagesToScrape,paginationStr);
				
				/*
				ArrayList<HashMap<String,String>> allResults = getResultsCombined(searchResults);
				paginatedResults = paginateRecords(allResults, 5);
				
				//currentResultsPage = ;
				paintResults(paginatedResults,currentResultsPage);
				
				*/
				
				splashPanel.setVisible(false);
				mainPanel.setVisible(false);
				resultsPanel.setVisible(true);
				
				/*
				System.out.println("Processing...");
				String linkA = "https://www.yellowpages.com/search?search_terms=%s";
				String linkB = "&geo_location_terms=%s, %s";
				String link = String.format(linkA, keywordField.getText())+String.format(linkB, cityField.getText(), stateField.getText());
				
				String paginationStr = "&page=%d";
				//int scrapeLimit = 5;
				//Document doc; 
				
				// fetching the target website 
				//doc = Jsoup.connect(link).get();
				HashMap<String,String>[][] searchResults = getResults(link,3,paginationStr);

				writeResults(keywordField.getText(),searchResults);
				
				exportBTN.setText("<html><p style='font-size:24px;'>EXPORT</p></html>");
				*/
				
				exportBTN.setText("<html><p style='font-size:18px;'>SEARCH</p></html>");
				
			} else if (thing == backToMainBTN) {
				searchResults = null;
				bizInfoPanel.setVisible(false);
				resultsPanel.setVisible(false);
				mainPanel.setVisible(true);
			} else if (thing == resultsExportDataBTN) {
				if (searchResults!=null) {
					writeResults(keywordField.getText(),searchResults);
					exportBTN.setText("<html><p style='font-size:24px;'>SEARCH</p></html>");
				}
			} else if (thing == resultsNextPage) {
				if (currentResultsPage < paginatedResults.length-1) {
					currentResultsPage++;
					System.out.println("Displaying results on page #"+currentResultsPage);
					paintResults(paginatedResults,currentResultsPage);
				}
				bizInfoPanel.setVisible(false);
				resultsListPanel.setVisible(true);
				
			} else if (thing == resultsPreviousPage) {
				if (currentResultsPage > 0) {
					currentResultsPage--;
					System.out.println("Displaying results on page #"+currentResultsPage);
					paintResults(paginatedResults,currentResultsPage);
				}
				bizInfoPanel.setVisible(false);
				resultsListPanel.setVisible(true);
			} else if (thing == resultsInfo) {
				if (bizInfoPanel.isVisible()) { // if the business information panel is visible
					resultsListPanel.setVisible(true); // show the results panel list
					bizInfoPanel.setVisible(false); // do not show the business information panel
					
				} else if (!bizInfoPanel.isVisible() && lastBizInformation != null) {
					// if the business information panel is not visible
					// and the there has been a last business information viewed
					resultsListPanel.setVisible(false); // do not show the results panel list
					bizInfoPanel.setVisible(true); // show the business information panel
				}
				
			}
			canClickBTN = true;
		}
	};
	
	private static ArrayList<HashMap<String,String>> getResultsCombined(HashMap<String,String>[][] searchResults) {
		ArrayList<HashMap<String,String>> resultsList = new ArrayList<HashMap<String,String>>();
		
		for (int page = 0;page<searchResults.length;++page) {
			HashMap<String,String>[] thisPage = searchResults[page];
			if (thisPage != null) {
				for (int bizId = 1;bizId<thisPage.length;++bizId) {
					HashMap<String,String> bizInfo = thisPage[bizId];
					
					//resultsListPanel.removeAll();
					
					if (bizInfo!=null) {
						resultsList.add(bizInfo);
					}
				}
			}
		}
		
		return resultsList;
	}
	
	private static ArrayList<HashMap<String,String>>[] paginateRecords(ArrayList<HashMap<String,String>> results, int resultsPerPage) {
		int pagesToGenerate = (int) Math.ceil((float) results.size() / (float) resultsPerPage);
		ArrayList<HashMap<String,String>>[] paginatedResults = new ArrayList[pagesToGenerate];
		
		System.out.printf(
				"Results Amount: %d\nPages Generated: %d\nResults Per Page: %d\n",
				results.size(),
				pagesToGenerate,
				resultsPerPage
				);
		
		int total = 0;
		for (int thisPage = 1; thisPage <= pagesToGenerate; thisPage++) {
			System.out.println("Page #"+thisPage+":");
			paginatedResults[thisPage-1] = new ArrayList<HashMap<String,String>>();
			
			for (int thisRecordId = 1; thisRecordId <= resultsPerPage; thisRecordId++) {
				System.out.println("\t thisRecordId: "+thisRecordId); 
				
				HashMap<String,String> bizInfo = results.get(total);
				
				if (bizInfo != null) {
					System.out.println("\t adding record #"+total+" to paginated results");
					paginatedResults[thisPage-1].add(bizInfo);

					total++;
					System.out.println("\t\trecord total now: "+total+"\n\tPage Size: "+paginatedResults[thisPage-1].size());
					if (total == results.size()) {
						break;
					}
					
				} else { System.out.println("\trecord not okay"); }
			}
		}
		
		for (int thisPageId = 0; thisPageId < pagesToGenerate; thisPageId++) {
			System.out.println("This page has "+paginatedResults[thisPageId].size()+" results.");
		}
		
		return paginatedResults;
	}
	
	private static boolean canOpenBizInfoPanel = true;
	
	//private static void paintResults(HashMap<String,String>[][] searchResults,int page) {
	private static void paintResults(ArrayList<HashMap<String,String>>[] paginatedResults, int page) {
		resultsListPanel.removeAll();
		//ArrayList<HashMap<String,String>> allResults = getResultsCombined(searchResults);
		//ArrayList<HashMap<String,String>>[] paginatedResults = paginateRecords(allResults, 3);
		
		ArrayList<HashMap<String,String>> thisPage = paginatedResults[page];
		for (int rId = 0; rId < thisPage.size(); rId++) {
			HashMap<String,String> bizInfo = thisPage.get(rId);
			
			//resultsListPanel.removeAll();
			
			if (bizInfo!=null) {
				System.out.println("Creating information for this business information...");
				JButton thisBizBTN = new JButton(bizInfo.get("name")) {{
					setPreferredSize(new Dimension(450,50));
					setFocusPainted(false);
					setBorder(null);
					setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
					setBackground(Color.white);
					setForeground(Color.black);
				}};
				//JLabel.CENTER
				/*
				private static ActionListener pressBTN = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
				*/
				thisBizBTN.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						Object source = e.getSource();
						
						if (source == thisBizBTN && canOpenBizInfoPanel == true) {
							canOpenBizInfoPanel = false;
							if (!bizInfoPanel.isVisible()) {
								lastBizInformation = bizInfo;
								
								String parseThis = String.format(
										"<html><body>"+
												"<p style='padding:10px;'>%s</p>"
												+ "<p>&nbsp;&nbsp;&nbsp;&nbsp;Phone: %s<br>"
												+ "&nbsp;&nbsp;&nbsp;&nbsp;Website: %s %s<br>"
												+ "&nbsp;&nbsp;&nbsp;&nbsp;Address: %s</p>"+
										"<html></body>",
										bizInfo.get("name"),
										bizInfo.get("phone"),
										bizInfo.get("website down"),
										bizInfo.get("website"),
										bizInfo.get("streetAddress")+" "+bizInfo.get("locality")
									);
								
								bizInfoLabel.setText(parseThis);
								resultsListPanel.setVisible(false);
								bizInfoPanel.setVisible(true);
							}
							canOpenBizInfoPanel = true;
						}
					}
				});
				
				JPanel thisRecord = new JPanel() {{
					setBackground(Color.white);
					setPreferredSize(new Dimension(450,50));
					setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
					add(thisBizBTN);
				}};
				
				resultsListPanel.add(thisRecord);
				/*
				thisCSV.addRecord(total, bizInfo);
				System.out.printf("%d) %s\n\tPhone: %s\n\tWebsite: %s %s\n\tAddress: %s\n",
						bizId,
						bizInfo.get("name"),
						bizInfo.get("phone"),
						bizInfo.get("websiteDown"),
						bizInfo.get("website"),
						bizInfo.get("streetAddress")+" "+bizInfo.get("locality"));
				total ++;
				*/
			}
			resultsListPanel.revalidate();
			resultsListPanel.repaint();
		}
		
		/*
		HashMap<String,String>[] thisPage = searchResults[page];
		if (thisPage != null) {
			for (int bizId = 1;bizId<thisPage.length;++bizId) {
				HashMap<String,String> bizInfo = thisPage[bizId];
				
				//resultsListPanel.removeAll();
				
				if (bizInfo!=null) {
					System.out.println("Creating information for this business information...");
					JLabel thisBizName = new JLabel(bizInfo.get("name"),JLabel.CENTER) {{
						setPreferredSize(new Dimension(450,25));
					}};
					JPanel thisRecord = new JPanel() {{
						setBackground(Color.white);
						setPreferredSize(new Dimension(450,50));
						setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
						add(thisBizName);
					}};
					resultsListPanel.add(thisRecord);
					/*
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
				resultsListPanel.revalidate();
				resultsListPanel.repaint();
			}
		}
		*/
	}
	
	private static void writeResults(String keywords, HashMap<String,String>[][] searchResults) {
		WriteToCSV thisCSV = new WriteToCSV() {{
			nameData("leads under '"+keywords+"'");
		}};
		
		int total = 0;
		
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
	}
	
	public static void main(String[] args) {
		exportBTN.addActionListener(pressBTN);
		backToMainBTN.addActionListener(pressBTN);
		resultsExportDataBTN.addActionListener(pressBTN);
		resultsNextPage.addActionListener(pressBTN);
		resultsPreviousPage.addActionListener(pressBTN);
		resultsInfo.addActionListener(pressBTN);
		
		mainMenuFrame.add(appView);
		mainMenuFrame.setVisible(true);
		
		Scanner input = new Scanner(System.in);
		System.out.print("YELLOW PAGES SCRAPER\nKeywords: ");
		String keywords = input.nextLine(); //"Detroit";
		//keywords = keywords.replaceAll(" ","+");
		
		System.out.print("City: ");
		String city = input.nextLine();
		
		System.out.print("State Code: ");
		String stateCode = input.nextLine();
		
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
		final int prodLimit = 30;
		HashMap<String,String>[][] finalResults = new HashMap[paginationLimit+2][prodLimit];
		
		if (paginationLimit>1) {
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
		
		System.out.println("Is doc null?");
		if (doc!=null) { // page exists and successfully accessed
			System.out.println("\tDoc is not null.");
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
					pageResults[thisct].put("website", (hasWebsite ? websiteElement.attr("href") : "none")); // defines website's URL or that it has no website
					//boolean isWebsiteUp = (attemptPageAccess(websiteElement.attr("href"))!=null);
					pageResults[thisct].put("websiteDown",
								(
									(
										pageResults[thisct].get("website").equals("none") ? "N/A" : (attemptPageAccess(websiteElement.attr("href"))!=null ? "[Up] " : " [Down] ")
									)
								)
							);
					
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
