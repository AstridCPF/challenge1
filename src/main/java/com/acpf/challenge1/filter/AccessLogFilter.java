package com.acpf.challenge1.filter;

import com.acpf.challenge1.dto.TransactionDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
/**
 * ACPF - Challenge1 Application
 * AccessLogFilter
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Component
@WebFilter(urlPatterns = "/*")
@Order(-999)
public class AccessLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Logger log = LoggerFactory.getLogger(AccessLogFilter.class);

        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(req, resp);

        byte[] requestBody = req.getContentAsByteArray();
        byte[] responseBody = resp.getContentAsByteArray();

        String requestBodyString = new String(requestBody, StandardCharsets.UTF_8);
        String responseBodyString = new String(responseBody, StandardCharsets.UTF_8);

        if(requestBodyString.contains("DEPOSIT") && responseBodyString.contains("SUCCESSFUL")){
            ObjectMapper mapper = new ObjectMapper();
            TransactionDetailsDto trxDto = mapper.readValue(requestBodyString, TransactionDetailsDto.class);
            if(trxDto.getAmount()>10000) {
                log.info("High amount deposit --- >= 10000");
                log.info(requestBodyString);
            }
            else
                log.info("Low amount deposit");

        }
        resp.copyBodyToResponse();
    }
}
