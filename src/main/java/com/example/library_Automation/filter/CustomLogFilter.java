package com.example.library_Automation.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
@Component
public class CustomLogFilter extends OncePerRequestFilter {
    public static final String USER_HEAD = "libraryUser";
    private static final List<String> shouldFilterPaths = Collections.singletonList("/**");

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
            ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);

            final String libraryUser = httpServletRequest.getHeader(USER_HEAD);
            if (!StringUtils.isEmpty(libraryUser)){
                UserThreadLocal.setUserData(libraryUser);
            }
            filterChain.doFilter(requestWrapper,responseWrapper);
            responseWrapper.copyBodyToResponse();

        }catch (Exception e){
            log.error("Error in custom filter");
        }finally {
            UserThreadLocal.cleanUp();
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
       String path = request.getServletPath() == null ? "": request.getServletPath();
       Predicate<String> shouldFilter = pathString -> shouldFilterPaths.stream().anyMatch(filterPath -> antPathMatcher.match(filterPath,pathString));

        return shouldFilter.negate().test(path);
    }
}
