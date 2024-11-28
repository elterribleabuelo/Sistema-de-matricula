# Sistema de matricula
Este repositorio contiene el código fuente de los servicios REST para el CRUD de estudiante y curso , así como el registro de matrícula de una academia.

Los endpoints desarrollados son:

**Estudiantes:**

CRUD y listado de estudiantes en forma descendente usando la edad.

- /estudiantes (GET,POST)
- /estudiantes/{id} (GET,PUT,DELETE)
- /estudiantes/ordenadoPorEdad (GET)

**Cursos**

CRUD

- /cursos(GET,POST)
- /cursos/{id} (GET,PUT,DELETE)

**Matricula**

Creacion/lectura de matriculas y relación de cursos matriculados y sus estudiantes correspondientes.

- /matricula (GET,POST)
- /matricula/estudiantesPorCurso (GET)