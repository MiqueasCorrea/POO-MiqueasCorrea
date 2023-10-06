package P6;

import Menu.Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Punto6 {
    public static void main(String[] args){
        List<Empleado> empleados = new ArrayList<>();
        List<Expendedor> expendedores = new ArrayList<>();
        List<Venta> ventas = new ArrayList<>();

        empleados.add(new Empleado("Lionel", "Messi", "25939535", "1124456533"));

        expendedores.add(new Expendedor("1", TipoExpendedor.GASOIL));
        expendedores.add(new Expendedor("2", TipoExpendedor.KEROSENE));
        expendedores.add(new Expendedor("3", TipoExpendedor.NAFTA));

        ventas.add(new Venta(LocalDate.now(), empleados.get(0), expendedores.get(0), 1000, 10, "UJ 350 D"));

        int respuesta;
        do {
            respuesta = Menu.mostrarMenu("\n\nEstacion de Servicio", List.of("Listado de proporcion de ventas de combustibles.", "Listado de surtidores (ordenado por monto).", "Listado de surtidores (ordenado por cantidad de litros).", "Listado de empleados (ordenados por monto de ventas).", "Mostrar top 10 clientes (segun monto total de compras)."));

            if (respuesta == 1){
                ModuloInformes.InformeVentasXCombustible(ventas);
            }
            else if (respuesta == 2){
                ModuloInformes.ordenarExpendedoresPorVentas(ventas);
            }
            else if (respuesta == 3){
                ModuloInformes.ordenarSurtidoresPorLitros(ventas);
            }
            else if (respuesta == 4){
                ModuloInformes.ordenarEmpleadosPorVentas(ventas);
            }
            else if (respuesta == 5){
                ModuloInformes.top10ClientesPorCompras(ventas);
            }
        } while(respuesta != 0);

    }
}
