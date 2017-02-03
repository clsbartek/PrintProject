import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

public class ApplicationPrintable implements Printable
{

	private String idEkli;
	private String name;
	private Date date;
	private static String adresLine1 = "Sp�dzielnia Mieszkaniowa";
	private static String adresLine2 = "�Osiedle M�odych� w Poznaniu";
	private static String adresLine3 = "Os. Piastowskie 16";
	private static String adresLine4 = "61-148 Pozna�";
	private static String title = "O�WIADCZENIE";
	private static String statementLine1 = "O�wiadczam, �e otrzyma�em informacj� zawieraj�c� identyfikator";
	private static String statementLine2 = "klienta dla us�ugi smom24.pl oraz has�o pierwszego logowania.";
	private static String idEkliLine = "Identyfikator klienta:";
	private static String nameLine = "Imi� i Nazwisko klienta:";
	private static String infoLine1 = "Us�uga dost�pna na stronie www.smom24.pl";
	private static String infoLine2 = "Sp�dzielnia informuj�, �e w przypadku utraty lub zbycia prawa do lokalu";
	private static String infoLine3 = "us�uga smom24.pl zostanie klientowi wy��czona.";
	
	private static String page2info = "Za��cznik nr 8  do Polityki bezpiecze�stwa ochrony danych osobowych w SM �Osiedle ";
	private static String page2info2 = "M�odych� w Poznaniu z dnia 9.07.2015r.";
	
	private static String page2Date = "Pozna�, dnia ...........................................";
	private static String page2Names = "/imiona/";
	private static String page2Surname = "/nazwisko/";
	private static String page2adres = "/adres lokalu w SM �Osiedle M�odych� w Poznaniu /";
	private static String page2Title = "Sp�dzielnia Mieszkaniowa �Osiedle M�odych� w Poznaniu";
	private static String page2Lines []= {
			"W zwi�zku z tym, �e przys�uguje mi prawo do lokalu w zasobach Sp�dzielni Mieszka-",
			"niowej �Osiedle M�odych� w Poznaniu o�wiadczam, �e: ",
			"1. Wyra�am zgod� na przetwarzanie moich danych osobowych (imi�/ona i nazwisko, data i",
			"miejsce urodzenia, stan cywilny, obywatelstwo, numer telefonu, PESEL, email, adres lok-",
			"alu w podmiocie, adres zamieszkania, adres do korespondencji, nr rachunku bankowego da- ",
			"ne os�b zamieszkuj�cych w lokalu) przez Sp�dzielni� Mieszkaniow� �Osiedle M�odych w  ",
			"Poznaniu na potrzeby wykonywania zada� statutowych i ustawowych. *",
			"2. Wyra�am zgod� na umieszczenie mojego imienia i nazwiska oraz adresu lokalu w zasob-",
			"ach ww. Sp�dzielni na urz�dzeniu domofonowym. *",
			"3. Wyra�am zgod� na umieszczenie mojego imienia i nazwiska oraz adresu lokalu w zasob-",
			"ach ww. Sp�dzielni na li�cie os�b maj�cych tytu� prawny do lokalu, kt�ra b�dzie umie-",
			"szczona w gablocie budynku.*",
			"4. Wyra�am zgod� na przechowywanie przez Sp�dzielni� orygina��w i kopii dokument�w",
			"(w szczeg�lno�ci akt�w notarialnych, orzecze� s�dowych, dokument�w z danymi osobowy-",
			"mi wra�liwymi) dotycz�cych mojej osoby i zwi�zanych z moim lokalem b�d�cym w zasob-",
			"ach Sp�dzielni.*"
	};
	private static String page2StarInfo="* niepotrzebne skre�li�";
	private static String page2Sign = "/czytelny podpis/";
	private static String page2FooterLines [] = {
			"Zgodnie z art. 24 ust. 1 ustawy o ochronie danych osobowych z dnia 29 sierpnia 1997 r. (tekst jed-",
			"nolity: Dz. U. z 2014 r., poz. 1182 z p�n. zm.) informujemy, �e administratorem danych osobowych",
			"jest Sp�dzielnia Mieszkaniowa �Osiedle M�odych� w Poznaniu, adres siedziby: Pozna� (61-148),",
			"Os. Piastowskie 16. Dane osobowe s� przetwarzane wy��cznie dla cel�w okre�lonych w art. 1 ustawy o ",
			"sp�dzielniach mieszkaniowych, Statucie Sp�dzielni oraz w art. 1, 27, 29 ustawy o w�asno�ci lokali, ",
			"a osobie posiadaj�cej tytu� prawny do lokalu przys�uguje prawo dost�pu do tre�ci jej danych osobowych",
			"oraz ich poprawiania. Ka�da osoba, kt�rej przys�uguje prawo do lokalu w zasobach Sp�dzielni ma",
			"obowi�zek podania danych osobowych niezb�dnych do zarz�dzania nieruchomo�ciami.",
	};
	
	public ApplicationPrintable(String idEkli, String name, Date date)
	{
		this.idEkli = idEkli;
		this.name = name;
		this.date = date;
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pf, int page) throws PrinterException 
	{
	    if (page > 1) 
	    {
	         return NO_SUCH_PAGE;
	    }
	    if(page == 0)
	    	printPage1(graphics);
	    else if(page == 1)
	    	printPage2(graphics);
		return PAGE_EXISTS;
	}
	
	protected void printPage1(Graphics graphics)
	{
		Date date = new Date();
	    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	    Graphics2D g2d = (Graphics2D)graphics;
	    g2d.setFont(new Font("Serif", Font.BOLD, 12));
	    g2d.drawString("Pozna�, " + format.format(date), 410, 80);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString(adresLine1, 336, 126);
	    g2d.drawString(adresLine2, 315, 142);
	    g2d.drawString(adresLine3, 384, 158);
	    g2d.drawString(adresLine4, 407, 174);
	    g2d.setFont(new Font("Serif", Font.BOLD, 16));
	    g2d.drawString(title, 230, 230);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString(statementLine1, 110, 280);
	    g2d.drawString(statementLine2, 80, 300);
	    g2d.drawString(idEkliLine, 130, 330);
	    g2d.setFont(new Font("Serif", Font.BOLD, 14));
	    g2d.drawString(idEkli, 270, 330);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString(nameLine, 130, 360);
	    g2d.setFont(new Font("Serif", Font.BOLD, 14));
	    g2d.drawString(name, 270, 360);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString(infoLine1, 130, 390);
	    g2d.drawString(infoLine2, 80, 450);
	    g2d.drawString(infoLine3, 80, 470);
	    g2d.setFont(new Font("Serif", Font.BOLD, 14));
	    g2d.drawString(format.format(date), 133, 615);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString("_____________________", 90, 620);
	    g2d.drawString("_____________________", 360, 620);
	    g2d.drawString("Data", 150, 640);
	    g2d.drawString("Podpis", 420, 640);
	}
	
	protected void printPage2(Graphics graphics)
	{
	    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	    Graphics2D g2d = (Graphics2D)graphics;
	    g2d.setFont(new Font("Serif", Font.BOLD, 11));
	    g2d.drawString(page2info, 80, 80);
	    g2d.drawString(page2info2, 80, 90);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 12));
	    g2d.drawString(page2Date, 300, 115);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 11));
	    g2d.drawString("........................................................", 80, 130);
	    g2d.drawString(page2Names, 80, 140);
	    g2d.drawString("........................................................", 80, 160);
	    g2d.drawString(page2Surname, 80, 170);
	    g2d.setFont(new Font("Serif", Font.BOLD, 11));
	    g2d.drawString("........................................................", 80, 190);
	    g2d.drawString(page2adres, 80, 200);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 14));
	    g2d.drawString(page2Title, 130, 230);
	    g2d.setFont(new Font("Serif", Font.PLAIN, 12));
	    int currentLine = 255;
	    for(String line : page2Lines)
	    {
	    	g2d.drawString(line, 80,currentLine);
	    	currentLine += 20;
	    }
	    
	    g2d.setFont(new Font("Serif", Font.PLAIN, 13));
	    g2d.drawString("..........................................................", 320,currentLine + 20);
	    g2d.drawString(page2StarInfo, 80,currentLine + 40);
	    g2d.drawString(page2Sign, 370,currentLine + 40);
	    currentLine += 100;
	    g2d.setFont(new Font("Serif", Font.PLAIN, 11));
	    for(String line : page2FooterLines)
	    {
	    	g2d.drawString(line, 80,currentLine);
	    	currentLine += 12;
	    }
	}

}
