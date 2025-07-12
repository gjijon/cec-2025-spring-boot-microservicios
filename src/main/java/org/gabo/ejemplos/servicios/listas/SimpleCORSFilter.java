package org.gabo.ejemplos.servicios.listas;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, 
                       ServletResponse res, 
                       FilterChain chain) throws IOException, ServletException {
    HttpServletRequest  request  = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    // permite cualquier origen
    response.setHeader("Access-Control-Allow-Origin",  "*");
    // métodos permitidos
    response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
    // cabeceras que aceptamos
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    // opcional: expone cabeceras al cliente
    response.setHeader("Access-Control-Expose-Headers", "Location");

    // Si es pre-flight, devolvemos 200 y no seguimos la cadena
    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
      return;
    }
    chain.doFilter(req, res);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}