package launcher.holder;

/**
 * @author fissban
 */
public class FileFTPHolder
{
	String name;
	String crc;
	long size;

	public FileFTPHolder(String name, String crc, String size)
	{
		this.name = name;
		this.crc = crc;
		this.size = Long.valueOf(size);
	}

	public String getName()
	{
		return name;
	}

	public String getCrc()
	{
		return crc;
	}

	public long getSize()
	{
		return size;
	}
}
