package launcher.look;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import launcher.util.Img;

/**
 * @author fissban
 */
public class FScrollbarUI extends BasicScrollBarUI
{
	private static final int SIZE_ARROW = 22;
	private ImageIcon downArrow, upArrow;

	public FScrollbarUI()
	{
		upArrow = Img.create("up.png");
		downArrow = Img.create("down.png");
	}

	@Override
	protected void configureScrollBarColors()
	{
		this.thumbColor = Color.BLACK;
	}

	@Override
	protected JButton createDecreaseButton(int orientation)
	{
		JButton decreaseButton = new JButton(getAppropriateIcon(orientation))
		{
			@Override
			public Dimension getPreferredSize()
			{
				return new Dimension(SIZE_ARROW, SIZE_ARROW);
			}
		};
		return decreaseButton;
	}

	@Override
	protected JButton createIncreaseButton(int orientation)
	{
		JButton increaseButton = new JButton(getAppropriateIcon(orientation))
		{
			@Override
			public Dimension getPreferredSize()
			{
				return new Dimension(SIZE_ARROW, SIZE_ARROW);
			}
		};
		return increaseButton;
	}

	private ImageIcon getAppropriateIcon(int orientation)
	{
		switch (orientation)
		{
		case SwingConstants.SOUTH:
			return downArrow;
		case SwingConstants.NORTH:
			return upArrow;

		}
		return downArrow;
	}
}
