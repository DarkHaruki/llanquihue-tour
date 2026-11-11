# Llanquihue Tour

Actividad de la Semana 4 de Desarrollo Orientado a Objetos I (PRY2202), Experiencia 2, Forma B.

**Autor:** David Soto · Analista Programador · Duoc UC Online.

Aplicación de consola Java que carga tours desde un archivo de texto, crea objetos `Tour` y los almacena en un `ArrayList`. Muestra el catálogo completo, filtra los tours gastronómicos y busca un tour por nombre.

**Actividad actual:** [Abrir LlanquihueTourApp de Semana 4](LlanquihueTourApp/).

## Estructura de carpetas

```text
LlanquihueTourApp/
├── src/
│   ├── model/Tour.java
│   ├── data/GestorDatos.java
│   └── ui/Main.java
├── resources/tours.txt
└── README.md
```

- `model`: clase Tour con nombre, tipo y precio en pesos chilenos; constructor, getters, setters y toString.
- `data`: lectura UTF-8 línea por línea, separación con split(";") y creación de la colección.
- `ui`: recorrido, filtro por tipo y búsqueda por nombre.
- `resources`: seis registros de ejemplo en formato `nombre;tipo;precio`, sin espacios alrededor de los separadores. Los espacios internos de los nombres se conservan.

Los precios y tours son datos de ejemplo para la actividad.

## Ejecutar en IntelliJ IDEA

1. Instalar o seleccionar un JDK 8 o superior.
2. Abrir con **File > Open** la carpeta `LlanquihueTourApp` (esta carpeta, dentro del repositorio).
3. Seleccionar el JDK en **File > Project Structure > Project SDK**.
4. Hacer clic derecho en `src` y elegir **Mark Directory as > Sources Root**.
5. Abrir `src/ui/Main.java` y ejecutar `Main.main()` con el botón verde.
6. Si es necesario, en **Run > Edit Configurations**, establecer **Working directory** en la carpeta `LlanquihueTourApp`, que contiene `resources`.

## Ejecutar desde terminal

Desde la carpeta `LlanquihueTourApp`:

```bash
javac -encoding UTF-8 -d out src/model/Tour.java src/data/GestorDatos.java src/ui/Main.java
java -cp out ui.Main
```

Para usar otro archivo, pasar su ruta como argumento:

```bash
java -cp out ui.Main resources/tours.txt
```

## Resultado esperado

Se muestran seis tours en el catálogo, dos tours gastronómicos y el resultado de buscar `Ruta del Kuchen` (precio $25000).

El lector cierra el archivo automáticamente. Si falta el archivo, una línea tiene un formato incorrecto o un precio no es un entero no negativo, el programa informa el error y finaliza.

## Repositorio

https://github.com/DarkHaruki/llanquihue-tour

La carpeta `LlanquihueTourApp` corresponde a Semana 4. El código anterior de Semana 3 se conserva en la raíz del repositorio.

## Actividad anterior de Semana 3

El directorio `src` de la raíz conserva las clases `app.Main`, `model.Persona`, `model.Direccion` y `model.Empleado`, que demuestran encapsulamiento, composición y herencia. La actividad actual se ejecuta de forma independiente desde `LlanquihueTourApp`.
