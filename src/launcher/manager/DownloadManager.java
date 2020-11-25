package launcher.manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.CRC32;

import launcher.Config;
import launcher.panels.PanelMain;
import thread.ThreadPool;

/**
 * @author fissban
 */
public class DownloadManager
{
	private static final String CRC_FILE = "CRC32.txt";

	private static final String URL_CLIENTE = "cliente/";

	private static final Map<String, String> filesCrc = new HashMap<>();
	private static final List<String> filesDowloads = new ArrayList<>();

	public DownloadManager()
	{
		//
	}

	/**
	 * Requiere q se ejecute en un thread nuevo
	 */
	public static void startDowload()
	{
		filesDowloads.clear();
		filesCrc.clear();
		ThreadPool.getInstance().execute(() ->
		{
			getFilesToDowload();
			generateFilesToDowload();
			downloadAllFiles();
		});
	}

	private static void getFilesToDowload()
	{
		PanelMain.setProgressText("Preparing to check update!");
		try
		{
			URLConnection con = new URL(Config.FILES_URL + CRC_FILE).openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
			con.setConnectTimeout(5000);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
			{

				String inputLine;
				while ((inputLine = in.readLine()) != null)
				{
					String[] parse = inputLine.split(" - ");

					String file = parse[0];
					String crc = parse[1];
					filesCrc.put(file, crc);
				}
			}
		}
		catch (Exception e)
		{
			PanelMain.setProgressText("Fail download, please restart program! ERROR CODE:1");
		}
	}

	private static void generateFilesToDowload()
	{
		String executePath = System.getProperty("user.dir");

		try
		{
			for (Entry<String, String> f : filesCrc.entrySet())
			{
				String fileName = f.getKey();
				String crc = f.getValue();

				PanelMain.setProgressText("Checkin files: " + fileName);

				File file = new File(executePath + "/" + fileName);

				if (file.exists())
				{
					String actualCrc = getCRC32(file);

					if (!actualCrc.equals(crc))
					{
						filesDowloads.add(fileName);
					}
				}
				else
				{
					filesDowloads.add(fileName);
				}
			}
		}
		catch (Exception e)
		{
			PanelMain.setProgressText("Fail download, please restart program! ERROR CODE:2");
		}
	}

	private static void downloadAllFiles()
	{
		String executePath = System.getProperty("user.dir");

		try
		{
			for (String fileName : filesDowloads)
			{
				PanelMain.setProgressText("Download file: " + fileName);
				PanelMain.setProgressBar(0);
				URL url = new URL(Config.FILES_URL + URL_CLIENTE + fileName);
				HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
				long completeFileSize = httpConnection.getContentLength();

				try (BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream()); BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(executePath + "/" + fileName), 1024))
				{
					byte[] data = new byte[1024];
					long downloadedFileSize = 0;
					int x = 0;
					while ((x = in.read(data, 0, 1024)) >= 0)
					{
						downloadedFileSize += x;

						// calculate progress
						final int currentProgress = (int) ((((double) downloadedFileSize) / ((double) completeFileSize)) * 100d);

						// update progress bar
						PanelMain.setProgressBar(currentProgress);

						bout.write(data, 0, x);
					}
				}
			}

			PanelMain.setProgressBar(100);
			PanelMain.setProgressText("All files update!");
			PanelMain.enableStart();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			PanelMain.setProgressText("Fail download, please restart program! ERROR CODE:3");
		}
	}

	private static String getCRC32(File file)
	{
		CRC32 crc = new CRC32();

		int cnt;

		try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file)))
		{
			while ((cnt = inputStream.read()) != -1)
			{
				crc.update(cnt);
			}
		}
		catch (Exception e)
		{
			PanelMain.setProgressText("Fail download, please restart program! ERROR CODE:4");
			return "null";
		}

		return Long.toHexString(crc.getValue());
	}
}
