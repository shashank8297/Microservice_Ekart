package com.infinite.apicoudegatway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;
import com.infinite.apicoudegatway.util.JwtUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.config> {

	@Autowired
	private RouteValidator routeValidator;
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	@Autowired
	private JwtUtil jwtUtil;
	

	public AuthenticationFilter() {
		super(config.class);
	}

	public static class config {

	}

	@Override
	public GatewayFilter apply(config config) {
		// TODO Auto-generated method stub
		return ((exchange, chain) -> {

			if (routeValidator.isSecured.test(exchange.getRequest())) {
				// header contain token or not

				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				
				if(authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				
				try {
					//REST call to AUTH service
					//restTemplate.getForObject("http://localhost:9010/auth/validate/"+authHeader, String.class);
					//restTemplate.getForObject("http://localhost:9010//validate/"+authHeader, String.class);
					jwtUtil.validateToken(authHeader);
					
				}
				catch (Exception e) {
					// TODO: handle exception
					
					System.out.println("Invalid access....!");
					throw new RuntimeException("Unauthorized access to the application");
				}
			}

			return chain.filter(exchange);
		});
	}
}
