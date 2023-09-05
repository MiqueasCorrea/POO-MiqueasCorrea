package P13;
import P4.Cola;

import java.time.*;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tarea {
    private String descripcion;
    private EnumPrioridad prioridad;
    private Boolean estado; //true completa, false incompleta
    private LocalDate fechaLimite;
    private LocalDate fecha_recordatorio;
    private LocalDate fecha_finalizacion = null;

    private Boolean vencida;
    private Colaborador colaborador = null;


    public Tarea(){
        this(null);
    }

    public Tarea(String descripcion){
        this(descripcion, null);
    }

    public Tarea(String descripcion, EnumPrioridad prioridad){
        this(descripcion, prioridad, false);
    }

    public Tarea(String descripcion, EnumPrioridad prioridad, Boolean estado){
        this(descripcion, prioridad, estado, false);
    }

    public Tarea(String descripcion, EnumPrioridad prioridad, Boolean estado, Boolean vencida) {
        this(descripcion, prioridad, estado, vencida, null);
    }

    public Tarea(String descripcion, EnumPrioridad prioridad, Boolean estado, Boolean vencida, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.vencida = vencida;
        this.fechaLimite = fechaLimite;
    }

    //GETTERS

    public String getDescripcion() {
        return descripcion;
    }

    public EnumPrioridad getPrioridad() {
        return prioridad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Boolean getVencida() {

        return vencida;
    }

    public LocalDate getFechaLimite(){
        return fechaLimite;
    }

    public LocalDate getFecha_recordatorio(){
        return fecha_recordatorio;
    }

    public Colaborador getColaborador(){
        return this.colaborador;
    }

    public LocalDate getFecha_finalizacion(){
        return fecha_finalizacion;
    }

    //SETTERS
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(int prioridad) {
        switch (prioridad){
            case 0:
                this.prioridad = EnumPrioridad.ALTA;
                break;
            case 1:
                this.prioridad = EnumPrioridad.MEDIA;
                break;
            case 2:
                this.prioridad = EnumPrioridad.BAJA;
                break;
            default:
                System.out.println("Prioridad invalida.");
                break;
        }
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setVencida(Boolean vencida) {
        this.vencida = vencida;
    }

    public void setFechaLimite(LocalDate fechaLimite){
        this.fechaLimite = fechaLimite;
    }

    public void setFecha_recordatorio(LocalDate fecha_recordatorio){
        this.fecha_recordatorio = fecha_recordatorio;
    }

    public void setColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
    }

    public void setFecha_finalizacion(LocalDate fecha_finalizacion){
        this.fecha_finalizacion = fecha_finalizacion;
    }


    //METhODS
    public void nuevaTarea(List<Tarea> tareas){
        Scanner escaner = new Scanner(System.in);
        Tarea nuevaTarea = new Tarea();
        try{
            System.out.print("\t\t\u001B[33m-\u001B[0mIngrese nombre del colaborador: ");
            String nombreColaborador = escaner.nextLine();

            System.out.print("\t\t\u001B[33m-\u001B[0mIngrese descripcion: ");
            String descripcion = escaner.nextLine();


            System.out.print("\t\t\u001B[33m-\u001B[0mIngrese prioridad [1,2,3] , 1.ALTA, 2. MEDIA, 3.BAJA: ");
            int prioridad = -1;

            try {
                String validacionPrioridad = escaner.nextLine();
                prioridad = Integer.parseInt(validacionPrioridad);
                if(prioridad < 1 || prioridad > 3){
                    throw new IllegalArgumentException("\t\tLa prioridad debe estar en el rango de 1 a 3 y ser entero.\n");
                }
            } catch (Exception e){
                System.err.println("\t\tError: " + e + "\n");
                return;
            }

            System.out.print("\t\t\u001B[33m-\u001B[0mIngrese fecha limite (yyyy-mm-dd): ");
            String fecha = escaner.nextLine();

            LocalDate fechaLimite = LocalDate.parse(fecha);

            System.out.print("\t\t\u001B[33m-\u001B[0mIngrese fecha recordatorio (yyyy-mm-dd): ");
            String fecha_recordatorio = escaner.nextLine();

            LocalDate fechaRecordatorio = LocalDate.parse(fecha_recordatorio);

            Colaborador colaborador = new Colaborador(nombreColaborador);
            nuevaTarea.setColaborador(colaborador);
            nuevaTarea.setFecha_recordatorio(fechaRecordatorio);
            nuevaTarea.setDescripcion(descripcion);

            //PUNTO 10
            if (LocalDate.now().isAfter(nuevaTarea.getFecha_recordatorio()) || LocalDate.now().isEqual(nuevaTarea.getFecha_recordatorio())) {
                nuevaTarea.setPrioridad(0); // Subir la prioridad a ALTA
            } else{
                nuevaTarea.setPrioridad(prioridad-1);
            }

            nuevaTarea.setFechaLimite(fechaLimite);
            nuevaTarea.setEstado(false);
            if(LocalDate.now().isAfter(nuevaTarea.getFechaLimite())){
                nuevaTarea.setVencida(true);
            } else{
                nuevaTarea.setVencida(false);
            }
            tareas.add(nuevaTarea);

        } catch (Exception e){
            System.err.println("Se ha producido un error al ingresar la tarea, verifique formato.\n Codigo de error: " + e.getMessage());
        }
    }

    public static void mostrarTareas(List<Tarea> tareas){
        if(tareas.size() == 0){
            System.out.println("\t\tNo hay tareas.");
            return;
        }
        List<Tarea> tareasOrdenadas = ordenarTareasPorPrioridadyFechaDeVencimiento(tareas);
        for(int i = 0; i < tareasOrdenadas.size(); i++){
            Tarea tareaAux = tareasOrdenadas.get(i);
            if(!tareaAux.getVencida()){
                System.out.println("\n\t\t\u001B[33mTAREA " + (i + 1)  + "\u001B[0m");
                System.out.println("\t\t\u001B[33mDescripcion\u001B[0m: " + tareaAux.getDescripcion());
                System.out.println("\t\t\u001B[33mPrioridad\u001B[0m: " + tareaAux.getPrioridad());
                System.out.println("\t\t\u001B[33mEstado\u001B[0m: " + (tareaAux.getEstado() ? "\u001B[32mCompleta\u001B[0m" : "\u001B[31mIncompleta\u001B[0m"));
                System.out.println("\t\t\u001B[33mFecha Limite\u001B[0m: " + tareaAux.getFechaLimite());
                System.out.print("\t\t\u001B[33mFecha Recordatorio:\u001B[0m: " + tareaAux.getFecha_recordatorio());
                if(tareaAux.getFecha_recordatorio().isAfter(LocalDate.now()) || tareaAux.getFecha_recordatorio().isEqual(LocalDate.now())){
                    System.out.print(", por vencer...\n");
                }
                System.out.println("\n\t\t\u001B[33mVencida\u001B[0m: " + (tareaAux.getVencida() ? "Si\n" : "No\n"));
            }
        }
    }

    public static void modificarTareas(List<Tarea> tareas){
        Scanner escaner = new Scanner(System.in);
        Tarea tareaAux;
        int respuesta;

        mostrarTareas(tareas);
        System.out.print("\t\t\u001B[33m-\u001B[0mDigite el numero de la tarea a modificar: ");
        respuesta = escaner.nextInt();
        respuesta -= 1;

        if(!(respuesta >= -1 || respuesta <= tareas.size())){
            System.out.println("\t\t\u001B[33m-\u001B[0mTarea invalida!");
        }
        else{
            tareaAux = tareas.get(respuesta);
            System.out.print("\n\t\t\u001B[33mMODIFICACIONES\u001B[0m\n" +
                    "\t\t\u001B[33m1.\u001B[0m Modificar descripcion\n" +
                    "\t\t\u001B[33m2.\u001B[0m Modificar prioridad\n" +
                    "\t\t\u001B[33m3.\u001B[0m Modificar estado\n" +
                    "\t\tSeleccione una opcion: ");
            respuesta = escaner.nextInt();
            switch (respuesta){
                case 1:
                    modificarDescripcion(tareaAux);
                    break;
                case 2:
                    modificarPrioridad(tareaAux);
                    break;
                case 3:
                    modificarEstado(tareaAux);
                    break;
                default:
                    System.out.println("\t\tDato invalido, verifique las opciones");
            }
        }
    }

    public static void modificarDescripcion(Tarea tareas){
        Scanner escaner = new Scanner(System.in);
        System.out.print("\t\t\u001B[33m-\u001B[0mDigite la nueva descripcion: ");
        String desc = escaner.nextLine();
        tareas.setDescripcion(desc);
        System.out.println("\t\t\u001B[33mDescripcion actualizada!\u001B[0m");
    }

    public static void modificarPrioridad(Tarea tareas){
        Scanner escaner = new Scanner(System.in);
        System.out.print("\t\t\u001B[33m-\u001B[0mIngrese la nueva prioridad [1,2,3]\u001B[0m , 1.ALTA, 2. MEDIA, 3.BAJA:");
        int priori = escaner.nextInt();
        tareas.setPrioridad(priori-1);
        System.out.println("\t\t\u001B[33mPrioridad actualizada!\u001B");
    }

    public static void modificarEstado(Tarea tarea){
        Scanner escaner = new Scanner(System.in);
        System.out.print("\t\t\u001B[33m-\u001B[0mDigite el nuevo estado\u001B[0m, 1. \u001B[32mCompleta\u001B[0m, 2. \u001B[31mIncompleta\u001B[0m: ");
        int estado = escaner.nextInt();
        if(estado == 1){
            tarea.setEstado(true);
            tarea.setFecha_finalizacion(LocalDate.now());
            System.out.println("\t\t\u001B[33mEstado actualizado!\u001B[0m");
        } else if(estado == 2){
            tarea.setEstado(false);
            System.out.println("\t\t\u001B[33mEstado actualizado!\u001B[0m");
        } else{
            System.out.println("\t\tEstado incorrecto, verifique los requisitos.");
        }
    }

    //Lo dejo comentado porque con el mostrarTareas ya se verifica el estado de las tareas
//    public static void verificarEstadoTareas(List<Tarea> tareas){
//        // Verifica el estado de las tareas
//        Scanner escaner = new Scanner(System.in);
//        Tarea tareaAux;
//        int respuesta;
//
//        mostrarTareas(tareas);
//        System.out.print("\t\t\u001B[33m-\u001B[0mDigite el numero de la tarea a verificar el estado\u001B[0m: ");
//        respuesta = escaner.nextInt() -1;
//
//        if(!(respuesta >= -1 || respuesta <= tareas.size())){
//            System.out.println("\t\t\u001B[33m-\u001B[0mTarea invalida!");
//        }else{
//            tareaAux = tareas.get(respuesta);
//            System.out.println("\t\t\u001B[33mEstado\u001B[0m: " + (tareaAux.getEstado() ? "\u001B[32mCompleta\u001B[0m\n" : "\u001B[31mIncompleta\u001B[0m\n"));
//        }
//    }

    public static List<Tarea> ordenarTareasPorPrioridadyFechaDeVencimiento(List<Tarea> tareas) {
        // Define un comparador personalizado para ordenar primero por prioridad
        Comparator<Tarea> comparadorPrioridad = new Comparator<Tarea>() {
            @Override
            public int compare(Tarea tarea1, Tarea tarea2) {
                return tarea1.getPrioridad().compareTo(tarea2.getPrioridad());
            }
        };

        // Ordena la lista de tareas por prioridad
        Collections.sort(tareas, comparadorPrioridad);

        // Luego, ordena las tareas con la misma prioridad por fecha de vencimiento
        Collections.sort(tareas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea tarea1, Tarea tarea2) {
                int prioridadComparison = tarea1.getPrioridad().compareTo(tarea2.getPrioridad());
                if (prioridadComparison != 0) {
                    return prioridadComparison;
                }
                return tarea1.getFechaLimite().compareTo(tarea2.getFechaLimite());
            }
        });

        return tareas;
    }

    public static void mostrarTareasColaboradores(List<Tarea> tareas){
        if(tareas.size() == 0){
            System.out.println("\t\tNo hay tareas.");
            return;
        }
        System.out.println("\t\tListado de tareas realizadas por colaboradores");
        for(int i = 0; i < tareas.size(); i++){
            Tarea aux = tareas.get(i);
            if(aux.getEstado()){
                System.out.println("\t\t\u001B[33mColaborador: \u001B[0m" + aux.getColaborador().getNombre());
                System.out.println("\t\t\u001B[33mDescripcion: \u001B[0m" + aux.getDescripcion());
                System.out.println("\t\t\u001B[33mFecha finalizacion: \u001B[0m" + aux.getFecha_finalizacion());
            }
        }
    }

}
