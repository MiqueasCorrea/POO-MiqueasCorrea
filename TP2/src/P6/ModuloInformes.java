package P6;

import P6.Empleado;
import P6.Expendedor;
import P6.TipoExpendedor;
import P6.Venta;

import java.util.*;

public class ModuloInformes {
    public static void InformeVentasXCombustible(List<Venta> ventas){
        if (ventas.isEmpty()){
            System.out.println("No hay ventas.");
            return;
        }

        int cantidadLitrosNafta = 0;
        int cantidadLitrosKerosene = 0;
        int cantidadLitrosGasoil = 0;

        float montoVentaNafta = 0;
        float montoVentaKerosene = 0;
        float montoVentaGasoil = 0;

        for (Venta venta : ventas){
           if (venta.getTipo_expendedor().getTipo_de_expendedor() == TipoExpendedor.NAFTA){
               montoVentaNafta += venta.getImporte();
               cantidadLitrosNafta += venta.getCantidadLitros();
           }
           else if (venta.getTipo_expendedor().getTipo_de_expendedor() == TipoExpendedor.KEROSENE){
                montoVentaKerosene += venta.getImporte();
                cantidadLitrosKerosene += venta.getCantidadLitros();
           }
           else if (venta.getTipo_expendedor().getTipo_de_expendedor() == TipoExpendedor.GASOIL){
                montoVentaGasoil += venta.getImporte();
                cantidadLitrosGasoil += venta.getCantidadLitros();
           }
        }

        System.out.print("La proporcion de ventas efectuadas por cada tipo de combustible es: \n");
        System.out.println("NAFTA");
        System.out.println("Cantidad de litros vendidos: " + cantidadLitrosNafta);
        System.out.println("Cantidad de monto recaudado: " + montoVentaNafta);

        System.out.println("\nKEROSENE");
        System.out.println("Cantidad de litros vendidos: " + cantidadLitrosKerosene);
        System.out.println("Cantidad de monto recaudado: " + montoVentaKerosene);

        System.out.println("\nGASOIL");
        System.out.println("Cantidad de litros vendidos: " + cantidadLitrosGasoil);
        System.out.println("Cantidad de monto recaudado: " + montoVentaGasoil);
    }

    public static void ordenarExpendedoresPorVentas(List<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas.");
            return;
        }

        // Crear un mapa para almacenar el monto total de ventas por ID de expendedores
        Map<String, Float> montoPorExpendedor = new HashMap<>();

        // Calcular el monto total de ventas para cada expendedor
        for (Venta venta : ventas) {
            Expendedor expendedor = venta.getTipo_expendedor();
            String idExpendedor = expendedor.getId();
            float importe = venta.getImporte();

            // Si el ID del expendedor ya está en el mapa, suma el importe de la venta
            if (montoPorExpendedor.containsKey(idExpendedor)) {
                float montoActual = montoPorExpendedor.get(idExpendedor);
                montoPorExpendedor.put(idExpendedor, montoActual + importe);
            } else {
                montoPorExpendedor.put(idExpendedor, importe);
            }
        }

        // Crear una lista de expendedores ordenados por monto de ventas (de mayor a menor)
        List<Map.Entry<String, Float>> listaOrdenada = new ArrayList<>(montoPorExpendedor.entrySet());

        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> e1, Map.Entry<String, Float> e2) {
                return Float.compare(e2.getValue(), e1.getValue());
            }
        });

        // Imprimir los IDs de expendedores en orden descendente de ventas
        System.out.println("ID de expendedores ordenados por monto total de ventas (de mayor a menor):");
        for (Map.Entry<String, Float> entrada : listaOrdenada) {
            System.out.println("ID del expendedor: " + entrada.getKey() + ", Monto total de ventas: " + entrada.getValue());
        }
    }

    public static void ordenarSurtidoresPorLitros(List<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas.");
            return;
        }

        // Crear un mapa para almacenar la cantidad total de litros expendidos por ID de surtidor
        Map<String, Integer> litrosPorSurtidor = new HashMap<>();

        // Calcular la cantidad total de litros expendidos para cada surtidor
        for (Venta venta : ventas) {
            String idSurtidor = venta.getTipo_expendedor().getId();
            int cantidadLitros = venta.getCantidadLitros();

            // Si el ID del surtidor ya está en el mapa, suma la cantidad de litros expendidos
            if (litrosPorSurtidor.containsKey(idSurtidor)) {
                int litrosActuales = litrosPorSurtidor.get(idSurtidor);
                litrosPorSurtidor.put(idSurtidor, litrosActuales + cantidadLitros);
            } else {
                litrosPorSurtidor.put(idSurtidor, cantidadLitros);
            }
        }

        // Crear una lista de surtidores ordenados por cantidad de litros expendidos (de mayor a menor)
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(litrosPorSurtidor.entrySet());

        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return Integer.compare(e2.getValue(), e1.getValue());
            }
        });

        // Imprimir los IDs de surtidores en orden descendente de cantidad de litros expendidos
        System.out.println("ID de surtidores ordenados por cantidad de litros expendidos (de mayor a menor):");
        for (Map.Entry<String, Integer> entrada : listaOrdenada) {
            System.out.println("ID del surtidor: " + entrada.getKey() + ", Cantidad de litros expendidos: " + entrada.getValue());
        }
    }

    public static void ordenarEmpleadosPorVentas(List<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas.");
            return;
        }

        // Crear un mapa para almacenar el monto total de ventas por empleado
        Map<Empleado, Float> ventasPorEmpleado = new HashMap<>();

        // Calcular el monto total de ventas para cada empleado
        for (Venta venta : ventas) {
            Empleado empleado = venta.getEmpleado();
            float importe = venta.getImporte();

            // Si el empleado ya está en el mapa, suma el importe de la venta
            if (ventasPorEmpleado.containsKey(empleado)) {
                float montoActual = ventasPorEmpleado.get(empleado);
                ventasPorEmpleado.put(empleado, montoActual + importe);
            } else {
                ventasPorEmpleado.put(empleado, importe);
            }
        }

        // Crear una lista de empleados ordenados por monto total de ventas (de mayor a menor)
        List<Map.Entry<Empleado, Float>> listaOrdenada = new ArrayList<>(ventasPorEmpleado.entrySet());

        Collections.sort(listaOrdenada, new Comparator<Map.Entry<Empleado, Float>>() {
            @Override
            public int compare(Map.Entry<Empleado, Float> e1, Map.Entry<Empleado, Float> e2) {
                return Float.compare(e2.getValue(), e1.getValue());
            }
        });

        // Imprimir los empleados en orden descendente de monto total de ventas
        System.out.println("Empleados ordenados por monto total de ventas (de mayor a menor):");
        for (Map.Entry<Empleado, Float> entrada : listaOrdenada) {
            Empleado empleado = entrada.getKey();
            System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellido());
            System.out.println("DNI: " + empleado.getDNI());
            System.out.println("Monto total de ventas: " + entrada.getValue());
        }
    }

    public static void top10ClientesPorCompras(List<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas.");
            return;
        }

        // Crear un mapa para almacenar el monto total de compras por cliente (basado en patente)
        Map<String, Float> comprasPorCliente = new HashMap<>();

        // Calcular el monto total de compras para cada cliente
        for (Venta venta : ventas) {
            String patenteCliente = venta.getPatente();
            float importe = venta.getImporte();

            // Si la patente del cliente ya está en el mapa, suma el importe de la compra
            if (comprasPorCliente.containsKey(patenteCliente)) {
                float montoActual = comprasPorCliente.get(patenteCliente);
                comprasPorCliente.put(patenteCliente, montoActual + importe);
            } else {
                comprasPorCliente.put(patenteCliente, importe);
            }
        }

        // Crear una lista de clientes ordenados por monto total de compras (de mayor a menor)
        List<Map.Entry<String, Float>> listaOrdenada = new ArrayList<>(comprasPorCliente.entrySet());

        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> e1, Map.Entry<String, Float> e2) {
                return Float.compare(e2.getValue(), e1.getValue());
            }
        });

        // Mostrar el top 10 de clientes por monto total de compras
        int contador = 0;
        System.out.println("Top 10 de clientes por monto total de compras:");
        for (Map.Entry<String, Float> entrada : listaOrdenada) {
            if (contador < 10) {
                String patenteCliente = entrada.getKey();
                float montoCompras = entrada.getValue();
                System.out.println("Patente del cliente: " + patenteCliente + ", Monto total de compras: " + montoCompras);
                contador++;
            } else {
                break; // Salir del bucle después de mostrar los 10 primeros clientes
            }
        }
    }
}
