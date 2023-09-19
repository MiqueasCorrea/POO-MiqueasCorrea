package P1;

public enum TipoSuscripcion {
    BASICA,
    INTERMEDIA,
    DESTACADA;

    public static void getActividades(){
        System.out.print("\nActividades de la suscripcion Basica: \n" +
                "1. Jugar al fuchivol.\n" +
                "2. Jugar al tenis.\n");
        System.out.print("\nActividades de la suscripcion Intermedia: \n" +
                "1. Jugar al fuchivol.\n" +
                "2. Jugar al tenis.\n" +
                "3. Jugar al padel.\n" +
                "4. Gimnasio\n");
        System.out.print("\nActividades de la suscripcion Destacada: \n" +
                "1. Jugar al fuchivol.\n" +
                "2. Jugar al tenis.\n" +
                "3. Jugar al padel.\n" +
                "4. Gimnasio.\n" +
                "5. Computadoras para jugar al League of Legends.\n" +
                "6. Entrenamiento a cualquier hora.\n" +
                "7. Banieras 24/7.\n\n");
    }
}
