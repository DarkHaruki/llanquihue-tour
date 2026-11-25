# LlanquihueTourApp

David Soto · Desarrollo Orientado a Objetos I · Duoc UC Online

## Semana 6 · Servicios turísticos

La actividad usa herencia simple para compartir el nombre y la duración de los servicios turísticos. Cada subclase agrega un atributo propio y sobrescribe `toString()` para mostrar sus datos completos.

| Paquete | Clase | Responsabilidad |
| --- | --- | --- |
| `model` | `ServicioTuristico` | Guarda el nombre y la duración en horas. |
| `model` | `RutaGastronomica` | Agrega el número de paradas. |
| `model` | `PaseoLacustre` | Agrega el tipo de embarcación. |
| `model` | `ExcursionCultural` | Agrega el lugar histórico. |
| `data` | `GestorServicios` | Crea dos ejemplos de cada subclase. |
| `ui` | `Main` | Muestra los seis ejemplos en consola. |

### Ejecutar Main

En IntelliJ IDEA, abre `LlanquihueTourApp` con un JDK 17 o superior y ejecuta `src/ui/Main.java`. Si el IDE no reconoce los paquetes, marca `src` como **Sources Root**.

También se puede ejecutar desde la carpeta `LlanquihueTourApp` en PowerShell:

```powershell
$fuentes = Get-ChildItem -Path src -Recurse -Filter *.java
javac --release 17 -encoding UTF-8 -d out $fuentes.FullName
java -cp out ui.Main
```

## Actividades anteriores

El registro de personas de Llanquihue Tour carga guías, operadores locales y proveedores de transporte desde un CSV. La consola permite listar los registros, buscar por una parte del nombre y filtrar por categoría. El proyecto también incluye el catálogo de tours de la Semana 4.

## Paquetes y clases

| Paquete | Clases |
| --- | --- |
| `model` | `Persona` contiene su propia `Direccion`. `Empleado` extiende `Persona` y agrega la categoría. `Tour` representa un servicio del catálogo. |
| `data` | `LectorPersonas` lee el CSV en UTF-8. `GestorDatos` lee el archivo de tours. |
| `service` | `RegistroPersonas` almacena los objetos en un `ArrayList`, controla correos duplicados y realiza las consultas. |
| `util` | `Validacion` comprueba campos obligatorios, correo y teléfono. |
| `ui` | `RegistroMain` abre el registro de personas. `CatalogoMain` ejecuta el catálogo de tours de la Semana 4. |

## Ejecutar en IntelliJ IDEA

1. Abre la carpeta `LlanquihueTourApp` y selecciona un JDK 17 o superior.
2. Si `src` aparece como carpeta normal, márcala como **Sources Root**.
3. Abre `src/ui/RegistroMain.java` y ejecuta el método `main`. Usa `LlanquihueTourApp` como directorio de trabajo para que el programa encuentre el CSV.

El archivo de ejemplo carga seis personas con datos ficticios. En la opción **2**, escribe `munoz` para encontrar a Daniela Muñoz. En la opción **3**, escribe `guia turistico` para ver los dos guías. Las consultas aceptan mayúsculas y texto sin tildes.

## Ejecutar el JAR

Desde `LlanquihueTourApp`, con Java 17 o superior:

```sh
java -jar dist/LlanquihueTourApp.jar
java -jar dist/LlanquihueTourApp.jar resources/personas.csv
```

Para reconstruir el JAR en PowerShell desde la carpeta del proyecto:

```powershell
$fuentes = Get-ChildItem -Path src -Recurse -Filter *.java
javac --release 17 -encoding UTF-8 -d out $fuentes.FullName
jar --create --file dist/LlanquihueTourApp.jar --main-class ui.RegistroMain -C out .
```

## Archivo de datos

`resources/personas.csv` usa el encabezado `nombre;correo;telefono;calle;numero;comuna;categoria`. Cada fila contiene siete campos separados por punto y coma. El lector indica el número de línea de los registros inválidos o con correo repetido y continúa con las filas siguientes. Si falta el archivo o el encabezado es incorrecto, la aplicación informa el error y termina.
