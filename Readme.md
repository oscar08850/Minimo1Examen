# AUTHOR *Oscar Vilamitjana* for the course *DSA* 
### *Minimum 1 exam implementation*

Los alumnos de 3A y en particular aquellos que están matriculados de DSA están muy
concienciados con la situación actual provocada por la pandemia del covid-19 y, han decidido
aportar su grano de arena, desarrollando una aplicación que permita hacer farmacovigilancia
sobre las vacunas aplicadas a las personas.
Después una lluvia de ideas, se ha propuesto implementar esta aplicación
SE PIDE:
PARTE I: 5 puntos
1.- Especificación de un componente (Covid19Manager.java,<<interfaz>>) que tiene las
siguientes operaciones:
● Aplicar una vacuna sobre una persona. Se indica un identificador de usuario, un
identificador de una vacuna (pfizer, moderna, ...) y una fecha.
● Listar las vacunaciones ordenadas por vacunas y dentro de las vacunas por
orden de vacunación.
● Listado de marcas de vacunas ordenado descendentemente por el número de
vacunas aplicadas.
● Añadir un seguimiento sobre un usuario que se haya vacunado, indicando la
fecha del seguimiento y una descripción del estado de esa persona.
● Listado de seguimientos realizados a una persona.
2.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz
definido previamente (Covid19ManagerImpl.java, clase Java).
2.1 Elección de las estructuras de dato:
● El contenedor de usuarios debe implementarse como un diccionario
(<clave, valor>).
● El contenedor de vacunaciones debe implementarse utilizando una lista.
● El contenedor de las marcas de vacunas (pfizer, moderna, ...) debe
implementarse utilizando un Array de Java.
● El contenedor de los seguimientos de un usuario debe implementarse
utilizando una lista
2.3 La fachada deberá implementarse como un Singleton.
2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J
que muestre el valor de los parámetros al inicio de los métodos y al final.
También debe contemplarse trazas de otros niveles (ERROR o FATAL)
3.- Implementación de un test (JUNIT) sobre el componente (Covid19Manager) con los
siguientes puntos:
- método setUp que inicializa la estructura de datos y crea un juego de pruebas
  inicial.
- método tearDown que libera los recursos. Tened en cuenta que al tratarse de
  un singleton, debéis ofrecer una operación para inicializar/limpiar las estructuras de
  datos
- método de test para aplicar una vacuna sobre un usuario.
- método de test para añadir un seguimiento sobre un usuario.
  PARTE II: 5 puntos
  1.- Definir (servicio, operaciones, rutas, métodos HTTP, peticiones, respuestas, códigos
  de respuesta) e implementar un servicio REST que permita realizar las operaciones
  especificadas en la primera parte del ejercicio. Se recomienda que todas las
  operaciones deben retornar “objetos de transferencia” y evitar ciclos/relaciones. Si
  estos objetos de transferencia son complejos se complica la
  serialización/deserialización
  NOTA: El servicio debe utilizar el componente construido en el punto anterior
  (Covid19Manager)
  NOTA:
- No se permite el uso de System.out.println
- La gestión de dependencias (librerías) debe realizarse ÚNICAMENTE con Maven:
  junit, log4j, etc
- La entrega debe realizarse sobre un repositorio de GITHUB. En dicho repositorio debe
  existir un fichero readme.md que describa el proyecto. NO SE DEBE REALIZAR
  NINGÚN PUSH hasta finalizar el ejercicio para evitar compartir el código entre
  compañeros. Si se comprueba un porcentaje de similitudes del código
  alto se presentará el caso al jefe de estudios con la propuesta de
  suspenso global de la asignatura. Adicionalmente debéis realizar una
  grabación en vídeo de vuestra pantalla. En concreto debéis mostrar el
  FUNCIONAMIENTO del ejercicio desarrollado (consola del IDE y swagger) y
  enseñar/explicar con vuestra propia voz el código de vuestra aplicación
  La entrega consistirá en un fichero de texto con el enlace de Github y un enlace al
  video (drive o youtube)