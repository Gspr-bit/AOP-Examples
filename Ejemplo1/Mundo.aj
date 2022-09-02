public aspect Mundo {
    pointcut saludo(): execution(* Hola.saludar(..));

    after() returning() : saludo() {
        System.out.println("Mundo");
    }
}
