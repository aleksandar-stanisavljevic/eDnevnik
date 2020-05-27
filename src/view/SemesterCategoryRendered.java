package view;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import model.SemesterCategory;

public class SemesterCategoryRendered implements TableCellRenderer{
	
	private JComboBox combo;
	
	public SemesterCategoryRendered() {
		combo = new JComboBox(SemesterCategory.values());
	}

	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		combo.setSelectedItem(value);
		
		return combo;
	}

}
