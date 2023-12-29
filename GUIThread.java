
public class GUIThread extends Thread {

	public void run(String link, int pagesToScrape, String paginationStr) {
		Drive.splashPanel.setVisible(true);
		Drive.resultsPanel.setVisible(false);
		Drive.mainPanel.setVisible(false);
	}
	
}
