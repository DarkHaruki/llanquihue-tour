package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

public class GestorServicios {
    public ServicioTuristico[] crearServiciosDePrueba() {
        return new ServicioTuristico[] {
            new RutaGastronomica("Ruta del Kuchen", 3, 4),
            new RutaGastronomica("Sabores de Puerto Varas", 2.5, 3),
            new PaseoLacustre("Navegación por el lago Llanquihue", 2, "Catamarán"),
            new PaseoLacustre("Paseo por la bahía de Frutillar", 1.5, "Lancha"),
            new ExcursionCultural("Historia de Frutillar", 2, "Museo Colonial Alemán"),
            new ExcursionCultural("Patrimonio de Puerto Varas", 1.5, "Iglesia del Sagrado Corazón de Jesús")
        };
    }
}
