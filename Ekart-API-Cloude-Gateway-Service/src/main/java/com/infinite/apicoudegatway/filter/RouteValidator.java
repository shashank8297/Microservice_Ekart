package com.infinite.apicoudegatway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
import java.util.function.Predicate;

@Component
//@CrossOrigin("http://localhost:3000")
public class RouteValidator {

	// public static final List<String> openApiEndpoints = List.of("/auth/register",
	// "/auth/token", "/eureka");

	public static final List<String> openApiEndpoints = Arrays.asList(
			"/auth/register",
			"/auth/token",
			"/admin/register",
			"/admin/token",
			"/eureka");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));
}
