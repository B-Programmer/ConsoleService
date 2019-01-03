package com.bprogrammer.example.Console.webservices;


import com.bprogrammer.example.Console.repository.ServiceStatusRepo;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Created by B. Programmer on 28/12/2018.
 */
@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/integrify-console-service/*");
    }

    @Bean(name = "integrifyDocWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema integrifyDocSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("IntegrifyDocWsdlPort");
        wsdl11Definition.setLocationUri("/integrify-console-service");
        wsdl11Definition.setTargetNamespace("http://console.bprogrammer.com/doc/integrify-console-service");
        wsdl11Definition.setSchema(integrifyDocSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema integrifyDocSchema() {
        return new SimpleXsdSchema(new ClassPathResource("integrifyDocWsdl.xsd"));
    }

    @Bean(name = "consoleDocWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema consoleDocSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("consoleDocWsdlPort");
        wsdl11Definition.setLocationUri("/integrify-console-service");
        wsdl11Definition.setTargetNamespace("http://console.bprogrammer.com/doc/integrify-console-service");
        wsdl11Definition.setSchema(consoleDocSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema consoleDocSchema() {
        return new SimpleXsdSchema(new ClassPathResource("consoleDocWsdl.xsd"));
    }

    @Bean
    public ServiceStatusRepo serviceStatusRepo() {
        return new ServiceStatusRepo();
    }

}
