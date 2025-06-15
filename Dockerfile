FROM amazoncorretto:17.0.8

RUN ln -sf /usr/share/zoneinfo/Asia/Taipei /etc/localtime && \
    echo 'Asia/Taipei' > /etc/timezone

COPY target/*.jar /asset.jar
COPY src/main/resources/logback-spring.xml /logback-spring.xml

EXPOSE 8080

CMD ["java","-Dname=asset[asset]","-Dfile.encoding=UTF-8","-Dlogging.config=logback-spring.xml","-jar","asset.jar"]
