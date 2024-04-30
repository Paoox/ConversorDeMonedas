import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
    public String conversor(int cantidad, String monedaBase, String monedaCambio) {
        //String monedaBase = "USD";
        //String monedaCambio = "MXN";
        String json;

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8cfd754603eb1b4e19a949fd/pair/"
                +monedaBase+"/"+monedaCambio+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
            // Supongamos que "json" es tu string JSON obtenido de la respuesta de la API
            // Parsear el JSON a un objeto JsonObject
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            // Obtener el valor de "conversion_result" del JsonObject
            JsonElement conversionResultElement = jsonObject.get("conversion_result");
            // Convertir el valor de "conversion_result" a un double
            double conversionResult = conversionResultElement.getAsDouble();
            //retornar el resultado
            return conversionResult + "";
        } catch (Exception e) {
            throw new RuntimeException("No se encontro ningun valor para realizar la conversión");
        }
    }
}
