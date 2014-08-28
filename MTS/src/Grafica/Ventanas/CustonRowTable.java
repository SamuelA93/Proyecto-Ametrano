package Grafica.Ventanas;


import java.awt.Component;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Grafica.Controladores.pruebaFechas;
public class CustonRowTable extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
       Component d  = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       pruebaFechas fech = new pruebaFechas();
       
    	//JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(table.getModel().getValueAt(row, 0) instanceof String){
        	if(fech.reciente(fech.dateJAVA(table.getModel().getValueAt(row, 0).toString()), fech.dateJAVA("28/08/2014"))<0){
        		//System.out.println(table.getModel().getValueAt(row, 0));
        		d.setBackground(Color.ORANGE);
        	}else{
        		d.setBackground(Color.white);
        	}
        	
        }else{
        	d.setBackground(Color.white);
        	
        }
        
        return d;
    }
}