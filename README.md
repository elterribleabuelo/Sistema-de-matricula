# Sistema de matricula
Este repositorio contiene el código fuente de los servicios REST para el CRUD de estudiante y curso , así como el registro de matrícula de una academia.

Los endpoints desarrollados son:
**Estudiantes**
- /estudiantes (GET,POST)
- /estudiantes/{id} (GET,PUT,DELETE)
- /estudiantes/orderbyedad (GET)

**Cursos**
- /cursos(GET,POST)
- /cursos/{id} (GET,PUT,DELETE)

**Matricula**
- /matricula (GET,POST)
- /matricula/studentsByCourse(GET)