package com.leojava.springboot.webflux.app;

import com.leojava.springboot.webflux.app.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterFunctionConfig {


    @Bean
    public RouterFunction<ServerResponse> routes(ProductoHandler handler){
        return route(GET("/api/v2/productos").or(GET("/api/v3/productos")), handler::listar)
                .andRoute(GET("/api/v2/productos/{id}"),handler::ver)
                .andRoute(POST("/api/v2/productos"), handler::crear)
                .andRoute(PUT("/api/v2/productos/{id}"), handler::editar)
                .andRoute(DELETE("/api/v2/productos/{id}"), handler::eliminar)
                .andRoute(POST("/api/v2/productos/upload/{id}"), handler::upload)
                .andRoute(POST("/api/v2/productos/crear"), handler::crearConFoto);
    }
}
