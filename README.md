# simple_launcher

Launcher para actualizar sus clientes de Lineage 2

<img src="https://repository-images.githubusercontent.com/315950883/e64ec600-2f0b-11eb-9351-a972fdd42dbd"/>

# ¿Como se usa?
- carpeta <b>'/Launcher_c4_style/updater'</b> dentro de nuestro webhost con sus archivos...solo la carpeta <b>updater</b>.
- Instalar en la carpeta <b>'updater/files/cliente'</b> los archivos que quieren que sus usuarios tengan sincronizados con el servidor.
- Ejecutar el archivo <b>'updater/files/GenerateCRC32.jar'</b> (no tiene interface) y se generara el archivo CRC32.txt.
- Listo ya pueden destribuir el Launcher a gusto.

# Temas a tener en cuenta.
- Dentro del proyecto en <b>'Launcher_c4_style\src\launcher\Config.java'</b> tienen algunas configuraciones generales en donde deberan definir varios parametros q se detallan alli mismo.
- Al momento de compilar se generara un launcher.jar, esto puede suponer un problema alnmenos que quieran enseñarles a sus usuarios a instalar java8 una buena alternativa es pasarlo a .exe 
con el programa Launch4j que pueden descargarlo desde <a src="http://launch4j.sourceforge.net/">link</a>.

