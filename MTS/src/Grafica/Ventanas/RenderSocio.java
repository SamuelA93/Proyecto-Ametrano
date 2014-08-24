package Grafica.Ventanas;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
 
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 *
 */
public class RenderSocio extends JLabel implements TableCellRenderer {
	public RenderSocio(){}
	
    public void RenderSocioSI() {
    		setFont(new Font("Consolas", Font.BOLD, 12));
            setOpaque(true);
            setHorizontalAlignment( SwingConstants.CENTER );
            setForeground(Color.WHITE);
            setBackground(Color.GREEN);
            //setBorder(BorderFactory.createEtchedBorder());
    }
    
   
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        
        //System.out.println(value.toString());
        if(value.toString().equals("si")){
        	System.out.println(value.toString());
        	RenderSocioSI();
        }
        return this;
    }
 
}