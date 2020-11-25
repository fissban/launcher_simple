package launcher.panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import launcher.Launcher;
import launcher.look.FButton;
import launcher.util.Img;

/**
 * @author fissban
 */
public class PanelTop extends JPanel
{

	public PanelTop()
	{
		super();
		setLayout(null);
		setBounds(5, 5, 800, 77);
		setOpaque(false);

		// setColor1(new Color(29, 33, 41, 110));
		// setColor2(new Color(29, 33, 41, 110));
		init();
	}

	private void init()
	{
		JLabel logo = new JLabel();
		logo.setHorizontalTextPosition(SwingConstants.CENTER);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(164, 27, 429, 41);
		logo.setIcon(Img.create("lineage-2-logo.png", logo.getWidth(), logo.getHeight()));
		add(logo);

		// boton de cerrado del programa
		FButton btnClose = new FButton("X");
		btnClose.setForeground(Color.WHITE);
		btnClose.setEnable(true);
		btnClose.addActionListener(e -> System.exit(0));
		btnClose.setBounds(760, 3, 23, 15);
		add(btnClose);

		// boton para minimizar el programa
		FButton btnMinimize = new FButton("-");
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setEnable(true);
		btnMinimize.addActionListener(e -> Launcher.minimize());
		btnMinimize.setBounds(734, 3, 23, 15);
		add(btnMinimize);

		JLabel left = new JLabel("");
		left.setBounds(0, 0, 23, 31);
		left.setIcon(Img.create("FrameBackLeft.png", left.getWidth(), left.getHeight()));
		add(left);

		JLabel center = new JLabel("");
		center.setBounds(21, 0, 757, 31);
		center.setIcon(Img.create("FrameBackMid.png", center.getWidth(), center.getHeight()));
		add(center);

		JLabel right = new JLabel("");
		right.setBounds(778, 0, 23, 31);
		right.setIcon(Img.create("FrameBackRight.png", right.getWidth(), right.getHeight()));
		add(right);
	}
}
