import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *
 * @author Brian Vanegas
 * 
 */
public class GUI implements ActionListener {

    static final String FILE = "llenar-jtable-desde-archivo-txt/Productos.txt";
    JFrame frame = new JFrame();
    JButton fillButton = new JButton("Llenar datos");
    private FileHelper file = new FileHelper();

    // Column Names
    String[] columnNames = { "Producto", "Cantidad", "Precio" };
    DefaultTableModel modelTableProduct = new DefaultTableModel(columnNames, 0);

    GUI() {
        frame.setLayout(new BorderLayout());

        JTable tableProducts = new JTable();
        tableProducts.setModel(modelTableProduct);

        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        bottombtnPnl.add(new JButton("Cancel"));
        bottombtnPnl.add(fillButton);
        fillButton.addActionListener(this);

        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);

        tableProducts.getTableHeader().setReorderingAllowed(false);

        frame.add(tableProducts.getTableHeader(), BorderLayout.NORTH);
        frame.add(tableProducts, BorderLayout.CENTER);
        frame.add(btnPnl, BorderLayout.SOUTH);

        frame.setTitle("JTable desde un ArrayList populado por un archivo plano");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setVisible(true);
    }

    /**
     * Evento de boton para llenar los datos
     * @author Brian Vanegas
     * 
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        ArrayList lines = file.FileHelper(FILE);
        for (Object line : lines) {
            String[] productLine = String.valueOf(line).split("\\|");
            Object rowData[] = { productLine[0], productLine[1], productLine[2] };
            modelTableProduct.addRow(rowData);
        }
    }
}
