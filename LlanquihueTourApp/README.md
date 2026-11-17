# LlanquihueTourApp

David Soto — Desarrollo Orientado a Objetos I, Semana 4.

Aplicación de consola en Java para consultar un catálogo de tours de Llanquihue. Lee el archivo `resources/tours.txt`, crea objetos `Tour` y los almacena en un `ArrayList`.

## Archivos

| Archivo | Función |
| --- | --- |
| `src/model/Tour.java` | Define nombre, tipo y precio, con constructor, getters, setters y `toString()`. |
| `src/data/GestorDatos.java` | Lee el archivo en UTF-8, separa los campos por punto y coma y crea la colección. |
| `src/ui/Main.java` | Muestra todos los tours, filtra por tipo gastronómico y busca por nombre. |
| `resources/tours.txt` | Contiene seis tours de ejemplo con el formato `nombre;tipo;precio`. |

Los precios están expresados en pesos chilenos. Los nombres pueden contener espacios; no hay espacios alrededor de los separadores.

## Ejecución

Se requiere JDK 8 o superior.

### IntelliJ IDEA

1. Abrir la carpeta `LlanquihueTourApp`, ubicada dentro del repositorio.
2. Seleccionar el JDK en **File > Project Structure > Project SDK**.
3. Marcar `src` como **Sources Root** desde el menú contextual.
4. Ejecutar el método `main` de `src/ui/Main.java`.

El directorio de trabajo de la configuración de ejecución debe ser `LlanquihueTourApp`, donde se encuentra la carpeta `resources`.

### Terminal

Desde la carpeta `LlanquihueTourApp`:

```sh
javac -encoding UTF-8 -d out src/model/Tour.java src/data/GestorDatos.java src/ui/Main.java
java -cp out ui.Main
```

También se puede indicar la ruta de otro archivo con el mismo formato:

```sh
java -cp out ui.Main resources/tours.txt
```

## Datos de ejemplo

El archivo incluye seis tours. Dos son gastronómicos: `Ruta del Kuchen` y `Sabores del Sur`. La búsqueda definida en `Main` usa el nombre `Ruta del Kuchen`, cuyo precio es $25.000.

Si el archivo no existe, un registro no tiene los tres campos o el precio no es un entero no negativo, el programa muestra un mensaje de error y termina.
