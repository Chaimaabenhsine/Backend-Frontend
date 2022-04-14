package projet.micro.auth.security.filters;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {
	
	private final JWTTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException 
	{
		httpServletResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
		httpServletResponse.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
		httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, PATCH, DELETE");
		httpServletResponse.addHeader("Access-Control-Allow-Credentials","true");

		if (httpServletRequest.getServletPath().equals("/api/auth/login") || httpServletRequest.getServletPath().equals("/api/auth/refreshToken") ) 
		{
			System.out.print("the refresh token is here");
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			
		}else {
		System.out.print("I enterred the if in do Filter---------------------");
		System.out.println(httpServletRequest.getHeader("authorization"));
		String jwt = jwtTokenUtil.resolveToken(httpServletRequest);
		if (Util.isNotBlank(jwt) && jwtTokenUtil.validateToken(jwt,httpServletResponse)) {
			SecurityContextHolder.getContext().setAuthentication(jwtTokenUtil.getAuthentication(jwt));
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
		}
	}
	
}
