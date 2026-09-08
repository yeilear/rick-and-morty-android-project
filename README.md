# Rick and Morty Android Project

En este proyecto se muestra una lista de personajes consumiendo la API de Rick and Morty utilizando tecnologías modernas de desarrollo Android.

## Decisiones Técnicas Tomadas
-   **Arquitectura Multi-módulo**: Se dividió el proyecto en `:app`, `:core` y `:home` para mejorar la mantenibilidad y los tiempos de compilación.
-   **Clean Architecture + MVVM**: Se utilizaron UseCases para desacoplar la lógica de negocio y ViewModels para gestionar el estado de la UI de forma reactiva con `StateFlow`.
-   **Jetpack Compose**: Implementación de UI declarativa, facilitando la creación de componentes reutilizables y el manejo de temas (Dark/Light mode).
-   **Dagger Hilt**: Para la inyección de dependencias, facilitando el desacoplamiento y el testeo unitario.
-   **Coil**: Para la carga eficiente de imágenes, aprovechando su integración nativa con Compose y su manejo automático de caché.
-   **Retrofit**: Para el consumo de la API REST.
-   **Base y Network**: Uso de clases para mapear objetos, respuestas de servicios y manejo de hilos.
-   **Test**: Uso de patrón AAA y mockk para creación de pruebas unitarias.

## Manejo de Estado
Se implementó una Sealed Class `HomeUiState` para manejar explícitamente los estados de Loading, Success y Error.

## Carga de Imágenes
-   Se utiliza `AsyncImage` de Coil.
-   Se configuraron placeholders y estados de error para evitar espacios vacíos en la UI.
-   La carga está optimizada para evitar recargas innecesarias durante el scroll mediante el uso de caché interno de la librería.

## Qué quedó fuera por falta de tiempo
-   **Paginación**: La API soporta paginación, lo cual sería ideal implementar.
-   **Mejor diseño**: Implementar un diseño más amigable para el usuario.
-   **Map to view**: Mapear el resultado de lista de personajes a un modelo de vista.

## Posibles Mejoras
-   **Room**: Implementar Room para persistencia de datos (modo offline).
-   **Tests**: Aagregar tests de UI/Integración.
-   **Detalle del Personaje**: Una pantalla de detalle para ver más información de cada personaje.
-   **Búsqueda y Filtros**: Implementar filtros por estado (Alive, Dead, etc.) o búsqueda por nombre.
-   **Variantes de entorno**: Implementar variantes de desarrollo.
-   **Seguridad**: Detección de emulación y dispositivos root con cifrado de data a información sensible.

## Uso de IA
Se utilizó asistencia de IA para:
-   Generación de archivo Readme y validación de mejores versiones de librerías para el proyecto.

## Repositorio
- https://github.com/yeilear/rick-and-morty-android-project