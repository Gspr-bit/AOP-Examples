public aspect Logger {
    /* login() */
    pointcut loginLogger() : execution(* User.login(..));

    // Si la función se ejecuta correctamente
    after() returning() : loginLogger() {
        System.out.println("Logger: Alguien ha iniciado sesión");
    }

    // Si la función retorna un error
    after() throwing() : loginLogger() {
        System.out.println("Logger: Hubo un intento fallido de inicio de sesión");        
    }


    /* logout() */
    pointcut logoutLogger() : execution(* User.logout(..));

    before() : logoutLogger() {
        System.out.println("Logger: Alguien está a punto de cerrar sesión");
    }


    /* Uso de comodínes */
    pointcut logLogger() : execution(* User.log*(..));

    after() : logLogger() {
        System.out.println("Logger: Es posible que haya cambios en los usuarios");        
    }


    /* Nuevo usuario */
    pointcut newUser() : initialization(* User);

    after() : newUser() {
        System.out.println("Logger: Se ha creado un nuevo usuario");   
    }
}
