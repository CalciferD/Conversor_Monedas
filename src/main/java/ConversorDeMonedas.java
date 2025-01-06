import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorDeMonedas {

    // Tu clave de API obtenida al registrarte en ExchangeRate-API
    private static final String API_KEY = "4757252dbadc6343fce4ba63";  // Reemplaza con tu clave de API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú interactivo
            System.out.println("---- Conversor de Monedas ----");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Dólar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Dólar a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dólar");
            System.out.println("7. Salir");
            System.out.print("Elige una opción (1-7): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "ARS", scanner);
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", scanner);
                    break;
                case 3:
                    convertirMoneda("USD", "BRL", scanner);
                    break;
                case 4:
                    convertirMoneda("BRL", "USD", scanner);
                    break;
                case 5:
                    convertirMoneda("USD", "COP", scanner);
                    break;
                case 6:
                    convertirMoneda("COP", "USD", scanner);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    // Método para realizar la conversión de una moneda a otra
    private static void convertirMoneda(String monedaOrigen, String monedaDestino, Scanner scanner) {
        // Pedir la cantidad a convertir
        System.out.print("Ingresa la cantidad en " + monedaOrigen + ": ");
        double cantidad = scanner.nextDouble();

        // Obtener la tasa de cambio usando la API
        double tasaDeCambio = obtenerTasaDeCambio(monedaOrigen, monedaDestino);

        if (tasaDeCambio == 0.0) {
            System.out.println("No se pudo obtener la tasa de cambio.");
            return;
        }

        // Realizar la conversión
        double resultado = cantidad * tasaDeCambio;
        System.out.printf("%.2f %s son %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
    }

    // Método para obtener la tasa de cambio de la API
    private static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        double tasaDeCambio = 0.0;

        try {
            // Crear la URL para la solicitud a la API
            String urlStr = BASE_URL + API_KEY + "/latest/" + monedaOrigen;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtener la respuesta de la API
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Parsear la respuesta JSON
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Verificar si la respuesta contiene el campo "conversion_rates"
            if (jsonResponse.has("conversion_rates")) {
                JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");

                // Verificar si la moneda de destino está en las tasas de conversión
                if (conversionRates.has(monedaDestino)) {
                    tasaDeCambio = conversionRates.getDouble(monedaDestino);
                } else {
                    System.out.println("Moneda de destino no encontrada en la respuesta.");
                }
            } else {
                System.out.println("No se encontraron las tasas de conversión.");
            }

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }

        return tasaDeCambio;
    }
}
