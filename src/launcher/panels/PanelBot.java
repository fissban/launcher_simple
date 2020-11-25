package launcher.panels;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import launcher.Config;
import launcher.util.Img;
import launcher.util.Util;

/**
 * @author fissban
 */
public class PanelBot extends JPanel
{
	public PanelBot()
	{
		setLayout(null);
		setBounds(5, 508, 791, 108);
		setOpaque(false);

		// setColor1(new Color(29, 33, 41, 110));
		// setColor2(new Color(29, 33, 41, 110));

		JLabel hopzone = new JLabel();
		addEventCursor(hopzone);
		hopzone.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Util.openURL(Config.HOPZONE);
			}
		});
		hopzone.setHorizontalAlignment(SwingConstants.CENTER);
		hopzone.setOpaque(false);
		hopzone.setIcon(Img.create("vote/hopzone.png"));
		hopzone.setBounds(10, 0, 300, 110);

		add(hopzone);

		JLabel topzone = new JLabel();
		addEventCursor(topzone);
		topzone.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Util.openURL(Config.TOPZONE);
			}

		});
		topzone.setHorizontalAlignment(SwingConstants.CENTER);
		topzone.setIcon(Img.create("vote/topzone.png"));
		topzone.setBounds(471, 0, 300, 110);
		add(topzone);
		init();
	}

	private void init()
	{

	}

	/**
	 * Al pasar el mouse por un "label" pondra la mano del cursor y lo deja por
	 * default al salir.
	 * 
	 * @param label
	 */
	private void addEventCursor(JLabel label)
	{
		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
}
