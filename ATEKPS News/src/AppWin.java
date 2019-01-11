import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


@SuppressWarnings({"serial", "unchecked", "rawtypes"})
public class AppWin extends JFrame {
	
	JPanel panel1 = new JPanel();
	JList lists = new JList();
	
	
	public AppWin() {
		super();
		this.setTitle("News portal for Desktop ver1.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(700, 500));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		

		JScrollPane scroll = new JScrollPane();		
		DefaultListModel dm = new DefaultListModel();
		
		MainNews.articles.forEach(dm::addElement);
		
		lists.setModel(dm);
		lists.setCellRenderer(new Render());
		lists.addListSelectionListener(e->{
			if (!e.getValueIsAdjusting()) { // »гнорируем событие mouseDown
	            // ѕолучаем выбранное значение
	            String val = ((Articles)lists.getSelectedValue()).getUrl();
	            // полученное значение в текстовое поле
	            MoreClass more = new MoreClass(val);
	            more.setVisible(true);
	        }
		});
		
		scroll.createVerticalScrollBar();
		scroll.setViewportView(lists);
		
		panel1 = (JPanel) this.getContentPane();
		panel1.setBackground(Color.CYAN);
		panel1.add(scroll);
		
	}

}
