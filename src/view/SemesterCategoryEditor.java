package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import model.SemesterCategory;

public class SemesterCategoryEditor extends AbstractCellEditor implements TableCellEditor{
	
	private JComboBox combo;
	
	public SemesterCategoryEditor() {
		combo = new JComboBox(SemesterCategory.values());
	}

	public Object getCellEditorValue() {		
		return combo.getSelectedItem();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, 
			boolean isSelected, int row, int column) {
		
		combo.setSelectedItem(value);		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		return combo;
	}

	public boolean isCellEditable(EventObject e) {		
		return true;
	}
}