package launcher.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author fissban
 */
public class Img
{
	public static ImageIcon create(String image)
	{
		try
		{
			return new ImageIcon(Img.class.getResource("/launcher/img/" + image));
		}
		catch (Exception e)
		{
			return new ImageIcon(Img.class.getResource("/gui/look/img/NOIMAGE.png"));
		}
	}

	public static ImageIcon create(String image, int width, int height)
	{
		return new ImageIcon(create(image).getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
	}

	public static ImageIcon create(Image image, int width, int height)
	{
		return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
	}
}
