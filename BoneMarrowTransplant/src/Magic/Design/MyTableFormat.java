/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Magic.Design;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author abhishekmathukiya
 */
public class MyTableFormat extends DefaultTableCellRenderer{
    public MyTableFormat() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable myTable, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(myTable, value, selected, focused, row, column);
        setBackground(new java.awt.Color(241, 250, 238)); 
        setForeground(new java.awt.Color(0,0,0));
        myTable.setFillsViewportHeight(true);
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        myTable.setShowGrid(true);
        TableCellRenderer rendererFromHeader = myTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}
