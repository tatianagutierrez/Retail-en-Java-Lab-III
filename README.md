<!-- TÍTULO Y DESCRIPCIÓN -->
  <a name="ir-arriba"></a>
  # 💻 Retail en Java

  Trabajo Práctico Final para la materia **Laboratorio de Programación III** de la Tecnicatura Universitaria en Programación.
  
  El objetivo de este trabajo final es la implementación de un conjunto de API’s REST en la plataforma Java, utilizando el framework Spring Boot que vimos durante el cursado de la materia.

<!-- ÍNDICE -->
  <a name="indice"></a>
  ## 📌 Índice
  <ol>
    <li><a href="#ir-arriba">Título y descripción del proyecto</a></li>
    <li><a href="#tecnologias">Tecnologías utilizadas</a></li>
    <li><a href="#instalacion">Instalación</a></li>
    <li><a href="#funcionalidad">Funcionalidad de la App</a>
    <li><a href="#a-tener-en-cuenta">A tener en cuenta</a></li>
    <li><a href="#contacto">Contacto</a>
  </ol>

<!-- TECNOLOGÍAS UTILIZADAS -->
  <a name="tecnologias"></a>
  ## ✅ Tecnologías utilizadas
  <p align="center">
    <a href="https://www.java.com/" target="_blank">
      <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
    </a>
    <a href="https://spring.io/" target="_blank">
      <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
      <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white">
    </a>
    <a href="https://www.docker.com/" target="_blank">
      <img src="https://img.shields.io/badge/docker-blue?style=for-the-badge&logo=docker&logoColor=white">
    </a>
    <a href="https://github.com/" target="_blank">
      <img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white">
    </a>
  </p>
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>

<!-- INSTALACIÓN -->
  <a name="instalacion"></a>
  ## 🔧 Instalación
  Si deseas correr la aplicación en un entorno local debes tener en cuenta lo siguiente: 
  1. Clona el repositorio utilizando GIT o descargando el archivo ZIP:

      `git clone https://github.com/tatianagutierrez/Retail-en-Java-Lab-III.git`
     
  
  3. El proyecto viene configurado para ejecutarse en el entorno de desarrollo y utilizar los endpoint.
  
  4. Para probar los endpoint puedes dirigirte a la documentación una vez lo hayas ejecutado:
      
      `http://localhost:8080/doc/swagger-ui.html`
      
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>
  
<!-- FUNCIONALIDAD DE LA APP -->
  <a name="funcionalidad"></a>
  ## ⚙️ Funcionalidad de la App
  La aplicación es un CRUD de productos y categorías. Cuenta con los siguientes endpoints:
  <ul>
    <li>/categoria</li>
    <li>/categoria/{id}</li>
    <li>/categoria?oder_price= (asc o desc)</li>
    <li>/categoria?marca=</li>
    <li>/categoria?precio_min=&precio_max=</li>
    <li>/producto</li>
    <li>/producto/{id}</li>
    <li>/producto?tipo_producto=&marca=&cateogoria_id=</li>
  </ul>
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>

  <a name="a-tener-en-cuenta"></a>
  ### ⚠️ A tener en cuenta
  Para crear o modificar un producto es necesario contar con el identificador de la categoría a la que pertenece, si no existe deberás crear una.

  <a name="crear-persona"></a>
  `/categoria` al crear la categoría devolverá un id.   
  <p align="center">
    <img src="https://github.com/tatianagutierrez/Retail-en-Java-Lab-III/blob/main/README/crear_categoria.PNG" width="600px">
  </p>
  <p align="center">
    <img src="https://github.com/tatianagutierrez/Retail-en-Java-Lab-III/blob/main/README/crear%20_categoria_ok.PNG" width="600px">
  </p>


   `/producto` al crear un producto hay que incluir ese id en el _RequestBody_.   
  <p align="center">
    <img src="https://github.com/tatianagutierrez/Retail-en-Java-Lab-III/blob/main/README/crear_producto.PNG" width="700px">
  </p>
  <p align="center">
    <img src="https://github.com/tatianagutierrez/Retail-en-Java-Lab-III/blob/main/README/crear_producto_ok.PNG" width="700px">
  </p>
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>
  
<!-- CONTACTO -->
 <a name="contacto"></a>
  ## 📩 Contacto
  Tatiana Gutiérrez - www.linkedin.com/in/gutierrez-tatiana
  
  Link del proyecto: https://github.com/tatianagutierrez/Retail-en-Java-Lab-III
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>
