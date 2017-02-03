import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class MainWindow extends JFrame 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(new ApplicationPrintable("10000001","Bartek Jarosinski",new Date()));
				job.setJobName("Wydruk danych autoryzacyjnych Smom24.pl dla " + "10000001");
				PrintRequestAttributeSet attr=new HashPrintRequestAttributeSet();
				attr.add(OrientationRequested.PORTRAIT);
				try
				{
					if(job.printDialog(attr))
					{
						job.print(attr);
					}
				}
				catch(PrinterException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(btnPrint);
		
		JButton btnNewButton = new JButton("Podgl¹d");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				PageFormat format = new PageFormat();
				format.setOrientation(PageFormat.PORTRAIT);
				PrintPreviewDialog previewDialog = new PrintPreviewDialog(new ApplicationPrintable("10000001","Bartek Jarosinski",new Date()),format);
				previewDialog.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton);
	}

}
