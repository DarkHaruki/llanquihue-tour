![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# Llanquihue Tour - Experiencia 1, Semana 3

Desarrollo Orientado a Objetos I (PRY2202) · Forma B

## 👤 Autor del proyecto

- **Nombre completo:** David Soto
- **Carrera:** Analista Programador
- **Sede:** Online

## 📘 Descripción general del sistema

Este proyecto corresponde a la actividad de la Semana 3 de Desarrollo Orientado a Objetos I. Es un prototipo en Java para representar a las personas relacionadas con la agencia Llanquihue Tour y organizar sus datos de contacto y dirección.

El programa crea un cliente y dos empleados, muestra sus datos en consola y permite comprobar la actualización del teléfono de un cliente. Se utilizan encapsulamiento, composición y herencia para organizar y reutilizar las clases.

## 🧱 Estructura general del proyecto

```text
LlanquihueTour/
├── src/
│   ├── app/
│   │   └── Main.java
│   └── model/
│       ├── Direccion.java
│       ├── Persona.java
│       └── Empleado.java
├── LlanquihueTour.iml
├── .gitignore
└── README.md
```

- **app:** contiene `Main`, donde se crean los objetos y se ejecuta el programa.
- **model:** contiene `Persona`, con los datos personales; `Direccion`, con calle, número y comuna; y `Empleado`, que hereda de `Persona` y agrega el cargo.

`Persona` contiene un objeto `Direccion` como atributo. Las clases del modelo tienen atributos privados, constructores, getters, setters y el método `toString()` para mostrar sus datos.

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clonar el repositorio con `git clone https://github.com/DarkHaruki/llanquihue-tour.git`, o descargar el ZIP desde GitHub y descomprimirlo.
2. Abrir la carpeta `LlanquihueTour` desde **File > Open** en IntelliJ IDEA.
3. Seleccionar un JDK instalado (Java 8 o superior) en **File > Project Structure > Project SDK**.
4. Si es necesario, hacer clic derecho en `src` y seleccionar **Mark Directory as > Sources Root**.
5. Abrir `src/app/Main.java` y ejecutar `Main.main()` con el botón verde junto al método.
6. Revisar en consola los datos del cliente, los dos empleados y el teléfono actualizado.

También se puede compilar y ejecutar desde una terminal dentro de la carpeta `LlanquihueTour`:

```text
javac -encoding UTF-8 -d out src/model/Direccion.java src/model/Persona.java src/model/Empleado.java src/app/Main.java
java -cp out app.Main
```

No requiere bibliotecas externas ni archivos de datos. Los datos de ejemplo son ficticios y los cambios se mantienen solo durante la ejecución.

**Repositorio GitHub:** [DarkHaruki/llanquihue-tour](https://github.com/DarkHaruki/llanquihue-tour)

**Fecha de entrega:** 09/11/2026.

---
Duoc UC | Escuela de Informática y Telecomunicaciones | Experiencia 1, Semana 3

