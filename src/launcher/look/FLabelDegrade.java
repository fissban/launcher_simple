package launcher.look;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;

/**
 * @author fissban
 */
public class FLabelDegrade extends JLabel
{

	// colors
	private Color color1 = new Color(112, 128, 144).darker();
	private Color color2 = new Color(112, 128, 144);
	private Color colorContorno = new Color(112, 128, 144).brighter();
	// radio
	private int radius = 8;
	// vars
	private boolean paintBackground = true;
	private boolean paintBorder = true;

	boolean check = false;

	public FLabelDegrade()
	{
		super();

		setLayout(null);
		setOpaque(false);
	}

	public FLabelDegrade(boolean paintBackground, boolean paintBorder)
	{
		super();

		setLayout(null);
		setOpaque(false);

		this.paintBackground = paintBackground;
		this.paintBorder = paintBorder;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Paint oldPaint = g2.getPaint();

		if (paintBackground)
		{
			g2.setStroke(new BasicStroke(1.2f));
			g2.clip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
			g2.setPaint(new GradientPaint(0.0f, 0.0f, getColor1().darker(), 0.0f, getHeight() / 6 * 8, getColor2()));
			g2.fillRect(0, 0, getWidth(), getHeight());
		}

		if (paintBorder)
		{
			g2.setStroke(new BasicStroke(1.5f));
			// paint border 1
			g2.setPaint(new GradientPaint(0.0f, 0.0f, colorContorno.darker().darker(), 0.0f, getHeight() / 2 - 1, colorContorno.darker()));
			g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
			// paint border 2
			g2.setPaint(new GradientPaint(0.0f, 0.0f, colorContorno.darker(), 0.0f, getHeight() / 2 - 1, colorContorno));
			g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, radius, radius);
		}

		g2.setPaint(oldPaint);
	}

	public Color getColor1()
	{
		return color1;
	}

	public void setColor1(Color value)
	{
		color1 = value;
	}

	public Color getColor2()
	{
		return color2;
	}

	public void setColor2(Color value)
	{
		color2 = value;
	}

	public Color getColorContorno()
	{
		return colorContorno;
	}

	public void setColorContorno(Color value)
	{
		colorContorno = value;
	}

	public void setRadius(int value)
	{
		radius = value;
	}

	public int getRadius()
	{
		return radius;
	}

}
