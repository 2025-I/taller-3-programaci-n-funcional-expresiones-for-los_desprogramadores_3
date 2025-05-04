# 🚂 Taller 3 - Maniobras de Trenes (Programación Funcional)
## 📌 Reglas
* Solo modificar lo indicado por el docente.
* Agregar las pruebas unitarias solicitadas en los archivos de test.
* El informe en formato MD debe estar en la raíz del proyecto.
## 👨‍💼 Autores
* Santiago Hernandez Aguado - 2380367
* Felipe Ortiz Calan - 2380642
* Samuel Alberto Valdes Gomez - 2380346
## 📚 Curso
* **Materia:** Programación Funcional y Concurrente
* **Universidad del Valle**
* **Sede:** Tuluá
* **Profesor:** Carlos Delgado
## 🧠 Descripción General
Este proyecto implementa una simulación funcional del proceso de **maniobras de trenes**, donde una serie de movimientos transforma una configuración inicial de vagones en una configuración objetivo. Todo está desarrollado en **Scala**, siguiendo los principios del paradigma funcional.
## 🎯 Objetivos
* Representar movimientos como funciones puras e inmutables.
* Implementar la clase `Maniobra` para aplicar una lista de movimientos sobre una lista de vagones.
* Validar la lógica con pruebas unitarias usando **ScalaTest** y **JUnit**.
* Comprender la composición funcional y recursión.
## ⚙️ Tecnologías y Conceptos
* **Lenguaje:** Scala
* **Testing:** ScalaTest + JUnit
* **Paradigma funcional:** Inmutabilidad, funciones puras, recursión, estructuras algebraicas
* **Organización del código:** Basado en `src/main/scala/taller` y `src/test/scala/taller`
## 📁 Estructura del Proyecto
```bash
📁 app
├── 📁 docs
│   ├── 📁 img
│   │   ├── MovimientoImg.jpg
│   │   ├── DefinirManiobraImg.png
│   │   └── movimientos.jpg
│   ├── DefinirManiobra.md
│   │── Movimientos.md
│   └── Movimiento.md
├── 📁 src
│   ├── 📁 main
│   │   └── 📁 scala
│   │       └── 📁 taller
│   │           ├── Maniobra.scala
│   │           └── Movimiento.scala
│   └── 📁 test
│       └── 📁 scala
│           └── 📁 taller
│               ├── TestAplicarMovimiento.scala
│               ├── TestAplicarMovimientos.scala
│               └── TestManiobra.scala
├── build.gradle
├── README.md
└── settings.gradle
```
## 📌 Conclusiones
* ✅ El enfoque funcional permite modelar el problema de manera expresiva y segura.
* 🔀 Se utiliza recursión para aplicar cada movimiento secuencialmente.
* 🧪 Las pruebas aseguran la corrección de las transformaciones en diversas condiciones.
* 📷 La documentación gráfica apoya la comprensión del algoritmo.