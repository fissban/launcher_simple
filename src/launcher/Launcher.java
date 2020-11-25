package launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import launcher.look.FLabelDegrade;
import launcher.manager.DownloadManager;
import launcher.panels.PanelBot;
import launcher.panels.PanelMain;
import launcher.panels.PanelTop;
import launcher.util.Img;
import thread.ThreadPool;

/**
 * @author fissban
 */
public class Launcher extends JFrame
{
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 620;

	private static JFrame frame;

	/**
	 * Create the application.
	 */
	public Launcher()
	{
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setTitle("L2 Fissban");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Img.create("launcher-icon.png").getImage());

		setUndecorated(true);

		// se duplica esta sentencia asi se visualiza en WindowsSwing
		setBounds(100, 100, WIDTH, HEIGHT);
		// center jframe in windows
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth() - WIDTH) / 2);
		int y = (int) ((d.getHeight() - HEIGHT) / 2);

		setBounds(x, y, WIDTH, HEIGHT);

		getContentPane().setLayout(null);

		PanelTop pt = new PanelTop();
		pt.setSize(801, 77);
		pt.setLocation(0, 0);
		getContentPane().add(pt);

		PanelMain pm = new PanelMain();
		pm.setLocation(0, 78);
		getContentPane().add(pm);

		PanelBot pb = new PanelBot();
		pb.setLocation(0, 508);
		getContentPane().add(pb);

		FLabelDegrade b = new FLabelDegrade(true, true);
		b.setColor1(new Color(16, 24, 31));
		b.setColor2(new Color(102, 153, 204));

		b.setColorContorno(new Color(206, 186, 93));
		b.setRadius(2);
		// b.setBackground(new Color(112, 128, 144));
		b.setBounds(0, 0, 800, 620);
		getContentPane().add(b);
	}

	/**
	 * Minimiza el programa
	 */
	public static void minimize()
	{
		frame.setState(Frame.ICONIFIED);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() ->
		{
			try
			{
				ThreadPool.getInstance();
				frame = new Launcher();
				if (Config.ACTIVATE_DOWNLOAD)
				{
					DownloadManager.startDowload();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}
}
