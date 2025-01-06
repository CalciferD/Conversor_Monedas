# Conversor de Monedas

Este es un proyecto de **Conversor de Monedas** que convierte entre varias monedas utilizando tasas de cambio en tiempo real a través de una API.

### Características
- Convierte de Dólar a Peso Argentino.
- Convierte de Peso Argentino a Dólar.
- Convierte de Dólar a Real Brasileño.
- Convierte de Real Brasileño a Dólar.
- Convierte de Dólar a Peso Colombiano.
- Convierte de Peso Colombiano a Dólar.

### Requisitos

Antes de comenzar, asegúrate de tener instalados los siguientes programas y herramientas:

- **Java 17 o superior** (El proyecto fue desarrollado utilizando Java 17).
- **IDE**: IntelliJ IDEA o cualquier editor de tu preferencia para Java.
- **Dependencias**:
    - org.json para trabajar con JSON.
    - [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio.

### Instalación

1. **Clona el repositorio** a tu máquina local:

    ```bash
    git clone https://github.com/tu_usuario/ConversorDeMonedas.git
    ```

2. **Importa el proyecto en tu IDE**:
    - Si usas IntelliJ IDEA, selecciona la opción "Import Project from Existing Sources" y selecciona la carpeta del proyecto.
    - Si es un proyecto Maven, IntelliJ debería reconocerlo automáticamente.

3. **Instala las dependencias**:
    - Asegúrate de que Maven descargue todas las dependencias al abrir el proyecto.

4. **Configura tu API Key**:
    - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tu clave de API.
    - Asegúrate de configurar la clave de API en el código.

### Uso

Para ejecutar el proyecto:

1. **Compila y ejecuta el proyecto**:
    - Si todo está configurado correctamente, puedes correr el proyecto desde tu IDE (por ejemplo, IntelliJ IDEA) o usando la terminal con el siguiente comando Maven:

    ```bash
    mvn clean install
    mvn exec:java
    ```

2. **Interactúa con el menú**:
    - El programa te mostrará un menú con las siguientes opciones:
        1. Dólar a Peso Argentino
        2. Peso Argentino a Dólar
        3. Dólar a Real Brasileño
        4. Real Brasileño a Dólar
        5. Dólar a Peso Colombiano
        6. Peso Colombiano a Dólar
        7. Salir
    - Elige la opción que desees y el programa realizará la conversión utilizando las tasas de cambio actuales.

### Ejemplo de uso
Cuando el usuario ejecuta el programa, verá un menú de opciones para elegir la conversión de moneda. Aquí tienes un ejemplo de cómo podría verse la interacción en la terminal:

Bienvenido al conversor de monedas! Por favor, elija una opción:

Dólar a Peso Argentino
Peso Argentino a Dólar
Dólar a Real Brasileño
Real Brasileño a Dólar
Dólar a Peso Colombiano
Peso Colombiano a Dólar
Salir





