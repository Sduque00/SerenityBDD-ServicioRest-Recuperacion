# language: es

Característica: Servicio API
  Yo, como QA
  Necesito consultar el servicio de servicios
  Para validar su respuesta

  @LibroExistente
  Escenario: Consulta libro existente
    Cuando se consulta un libro con el id 589
    Entonces debería tener una respuesta con código 200
    Y el título del libro es 'Diseño Ágil con TDD' y el autor del libro debe ser 'Carlos Blé Jurados y autores'

  @LibroInexistente
  Escenario: Consultar libro inexistente
    Cuando se consulta un libro con el id 200
    Entonces debería tener una respuesta con código 200
    Y la respuesta deberia ser vacia

