package Grafica.Ventanas;


import java.awt.Component;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class CustomCellTabla extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
       // Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    	JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof String){
        	if(column == 0){
	        	if (value.equals("30/08/2014")  ) {
	        		cell.setBackground(Color.GREEN);
	        		
				}
        	}else{
        		 cell.setBackground(Color.white);
        	}
        }
        
        return cell;
    }
}