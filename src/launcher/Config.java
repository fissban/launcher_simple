package launcher;

/**
 * @author fissban
 */
public class Config
{
	/**
	 * true -> permite la descarga de los archivos del launcher se puede desactivar
	 * para pruebas en donde solo se quiere ver la estetica por ejemplo.
	 */
	public static final Boolean ACTIVATE_DOWNLOAD = true;

	/**
	 * Aqui se define la direccion de los htmls que forman el panel principal.
	 */
	public static final String DIRECTION_WEB = "http://fissban.l2devsadmins.net/updater/";

	/**
	 * Aqui se define la direccion de los files propios que con este launcher se
	 * pretenden actualizar en los files del cliente.
	 */
	public static final String FILES_URL = "http://fissban.l2devsadmins.net/updater/files/";

	/**
	 * Direccion de los tops para los votos.
	 */
	public static final String HOPZONE = "https://vgw.hopzone.net/site/vote/103898/1";
	public static final String TOPZONE = "https://l2topzone.com/vote/id/16590";
}
