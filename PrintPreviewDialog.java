import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JDialog;
import javax.swing.JPanel;


public class PrintPreviewDialog extends JDialog 
{

	public PrintPreviewDialog(Printable printable, PageFormat pageFormat)
	{
		double scaler = 1;
		setBounds(100, 100, (int)(pageFormat.getWidth() * scaler ), (int)(pageFormat.getHeight()* scaler));
		setContentPane(new PreviewPanel(printable,pageFormat));
	}
	
	private class PreviewPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		private Printable printable;
		private PageFormat pageFormat;
		
		public PreviewPanel(Printable printable, PageFormat pf) 
		{
			this.printable = printable;
			this.pageFormat = pf;
			double scaler = 1;
			setPreferredSize(new Dimension((int)(pf.getWidth() * scaler ), (int)(pf.getHeight()* scaler)));
			
		}
		
		public void paintComponent(Graphics g1) {
			Graphics2D g = (Graphics2D)g1;
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.black);
			try
			{
				printable.print(g, pageFormat, 0);
//				g.scale(scaler, scaler);
//				g.rotate(Math.PI);
//				g.translate(-pf.getWidth(), -pf.getHeight());
//				pg.getPrintable(pageIndex).print(g, pf, pageIndex);
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				g.setFont(new Font("Helvetica", Font.ITALIC, 30));
				g.drawString("Page index out of range", 10, 30);
			} catch (PrinterException e) {
				e.printStackTrace();
				g.setFont(new Font("Helvetica", Font.ITALIC, 30));
				g.drawString("Printer error", 10, 30);
			}
		}
	}
	
}
