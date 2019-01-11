import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@SuppressWarnings({"serial"})
public class MoreClass extends JFrame {
	
	private String titleSite = "Atekps.kz News portal for Desktop"; 
	private String title = "This is Title!";
	private String text = "This is Main Text!";
	private JPanel panel = new JPanel();
	private JScrollPane sPane;
	//private JTextArea taMain;
	private JEditorPane jep = new JEditorPane();
	private JLabel lMain;
	
	//private String mainEls;
	
	public MoreClass(String url) {
		super();
		this.setTitle(titleSite);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(400, 150);
		this.setSize(new Dimension(600, 500));
		this.setResizable(false);
		
		panel = (JPanel) this.getContentPane();
		try {
			addData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addComps(panel);
	}

	private void addData(String url) throws IOException {
		
		Document doc = Jsoup.connect(url).get();
		Elements els = doc.getElementsByAttributeValue("class", "col-sm-9 main-cont");
				
		text = els.toString();
	}

	private void addComps(JPanel panel) {
		panel.setLayout(new GridBagLayout());
		//taMain = new JTextArea(600/19, 40);
		//taMain.setEditable(false);
		//taMain.setText(text);
		jep.setContentType("text/html");
		jep.setText(text);
		jep.setEditable(false);
		lMain = new JLabel(title);
		lMain.setHorizontalAlignment(JTextField.CENTER);
		lMain.setSize(panel.getSize().width, 100);
		lMain.revalidate();
		sPane = new JScrollPane(jep);
		
		//panel.add(lMain, new GridBagConstraints(0, 0, 1, 1, 0.5, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(10, 1, 10, 1), 0, 0));
		panel.add(sPane, new GridBagConstraints(0, 1, 1, 5, 0.5, 0.4, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
	}
}
