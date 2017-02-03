import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

public class PasswordPrintable implements Printable
{

	private String password;
	private String login;
	private static String title = "Pocz�tkowe dane autoryzacyjne do Smom24.pl -";
	private static String title2 = "serwisu online Sp�dzielni Mieszkaniowej Osiedle M�odych";
	private static String info = "Has�o pierwszego logowania nale�y zmieni� podczas pierwszego logowania.";
	private static String info2 = "Login nale�y zapami�ta� b�d� zachowa�. B�dzie u�ywany podczas autoryzacji w serwisie."; 
	
	public PasswordPrintable(String login, String password)
	{
		this.password = password;
		this.login = login;
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pf, int page) throws PrinterException 
	{
	    if (page > 0) 
	    {
	         return NO_SUCH_PAGE;
	    }
	    Date date = new Date();
	    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	    Graphics2D g2d = (Graphics2D)graphics;
	    ImageIcon smom = new ImageIcon(getClass().getClassLoader().getResource("smom.png"));
	    g2d.drawImage(smom.getImage(),30,30,null); 
	    g2d.setFont(new Font("Serif", Font.BOLD, 18));
	    g2d.drawString("Pozna�, " + format.format(date), 600, 40);
	    g2d.drawString(title, 50, 160);
	    g2d.drawString(title2, 50, 180);
	    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawRect(55, 205, 690, 80);
        Stroke dashed2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed2);
        g2d.drawRect(55, 205, 690, 80);
        g2d.drawRect(20, 20, 742, 550);
        g2d.setColor(Color.GRAY);
        g2d.fillRect(56, 206, 688,78);
        g2d.setColor(Color.BLACK);
	    g2d.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 24));
	    g2d.drawString("LOGIN: " + login, 60, 232);
	    g2d.drawString("HAS�O: " + password, 60, 270);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 18));
	    g2d.drawString(info, 60, 350);
	    g2d.drawString(info2, 60, 370);
	    g2d.drawString("-------------------------------------------", 360 , 480);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString("(Podpis i piecz�� jednostki organizacyjnej)", 372 , 490);
		return PAGE_EXISTS;
	}

}
