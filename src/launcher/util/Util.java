package launcher.util;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;

/**
 * @author fissban
 */
public class Util
{
	public static Color hex2Rgb(String colorStr)
	{
		return new Color(Integer.valueOf(colorStr.substring(1, 3), 16), Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(colorStr.substring(5, 7), 16));
	}

	public static void openURL(String url)
	{
		try
		{
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
			{
				Desktop.getDesktop().browse(new URI(url));
			}
		}
		catch (Exception ioe)
		{
			System.err.println("Error loading url from link: " + ioe);
		}
	}
}
