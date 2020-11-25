package launcher.panels;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import launcher.Config;
import launcher.look.FButton;
import launcher.look.FProgressBar;
import launcher.look.FScrollbarUI;
import launcher.util.Util;

/**
 * @author fissban
 */
public class PanelMain extends JPanel
{
	private static final long serialVersionUID = 1L;

	private static FProgressBar progressBar = new FProgressBar();
	private static JLabel progressText = new JLabel("Init update!");
	private static FButton start = new FButton("START");

	JEditorPane webPanel = new JEditorPane();

	public PanelMain()
	{
		setLayout(null);
		setBounds(5, 78, 791, 428);
		setOpaque(false);

		// setColor1(new Color(29, 33, 41, 110));
		// setColor2(new Color(29, 33, 41, 110));
		init();
	}

	private void init()
	{
		progressBar.setProgressColor(new Color(51, 102, 204).darker());
		progressBar.setValue(50);
		progressBar.setBounds(10, 368, 625, 31);
		add(progressBar);

		start.setForeground(Color.WHITE);
		start.setBounds(660, 368, 111, 31);

		start.setColor1(new Color(24, 48, 82));
		start.setColor2(new Color(24, 48, 82).darker());
		start.setColorContorno(new Color(206, 186, 93));

		start.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (start.isEnable())
				{
					try
					{
						Desktop desktop = Desktop.getDesktop();

						File file = new File("./system/l2.exe");
						if (file.exists())
						{
							desktop.open(file);
						}
						else
						{
							System.out.println("no se encontro L2.exe");
						}
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});

		add(start);

		progressText.setForeground(Color.LIGHT_GRAY);
		progressText.setBounds(10, 398, 761, 18);
		add(progressText);
		webPanel.setBorder(null);

		webPanel.setEditable(false);
		webPanel.setOpaque(false);
		try
		{
			// load html
			webPanel.setContentType("text/html");
			webPanel.setPage(new URL(Config.DIRECTION_WEB + "noticias_update.html"));
			webPanel.addHyperlinkListener(listener);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		JScrollPane web = new JScrollPane(webPanel);
		web.getViewport().setOpaque(false);
		web.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		web.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0x1d2129)));
		web.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		web.getVerticalScrollBar().setUI(new FScrollbarUI());
		web.setBounds(342, 10, 429, 353);
		add(web);

		JEditorPane panelImagen = new JEditorPane();
		panelImagen.setBackground(new Color(0x1d2129));
		panelImagen.setContentType("text/html");
		try
		{
			panelImagen.setPage(new URL(Config.DIRECTION_WEB + "imagen_update.html"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		panelImagen.setBounds(10, 10, 333, 353);
		add(panelImagen);

		// JProgressBar progressBar_1 = new JProgressBar();
		// progressBar_1.setForeground(new Color(115, 142, 191));
		// progressBar_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(206,
		// 186, 93), new Color(206, 186, 93).darker()));
		// progressBar_1.setIndeterminate(true);
		// progressBar_1.setBounds(102, 412, 511, 14);
		// add(progressBar_1);
	}

	HyperlinkListener listener = event ->
	{
		if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
		{
			Util.openURL(event.getURL().toString());
		}
	};

	public static void setProgressBar(int value)
	{
		SwingUtilities.invokeLater(() -> progressBar.setValue(value));
	}

	public static void setProgressText(String text)
	{
		// progressText.setText(text);
		SwingUtilities.invokeLater(() -> progressText.setText(text));
	}

	public static void enableStart()
	{
		start.setEnable(true);
	}
}
