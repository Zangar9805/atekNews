import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings({ "rawtypes", "serial" })
public class Render extends DefaultListCellRenderer implements ListCellRenderer<Object> {

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		
		return new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				
				Graphics2D g2 = (Graphics2D) g;
				Articles arts = (Articles) value;
				Font font = new Font("Arial", Font.PLAIN, 14);
				
				if(isSelected) g2.setColor(isSelected ?  Color.RED : Color.BLACK);
				
				
				
				g2.setFont(font);
				g2.drawString(arts.getDate(), 10, 20);
				g2.drawString(arts.getTitle(), 10, 38);
				
				
			}


			@Override
			public Border getBorder() {
				// TODO Auto-generated method stub
				return border;
			}

		
			


			@Override
			public Dimension getPreferredSize() {
				// TODO Auto-generated method stub
				return new Dimension(200, 50);
			}
			
			
			
		};
	}

}
