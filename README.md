# Sistema de matricula
Este repositorio contiene el código fuente de los servicios REST para el CRUD de estudiante y curso , así como el registro de matrícula de una academia.

Los endpoints desarrollados son:

**Estudiantes:**

CRUD y listado de estudiantes en forma descendente usando la edad.

- /estudiantes (GET,POST)
- /estudiantes/{id} (GET,PUT,DELETE)

### `Body request POST/PUT` flag

```Body request POST/PUT
{
    "nombres":"Antonio",
    "apellidos":"Salazar",
    "dni":"45634021",
    "edad":26
}
```
- /estudiantes/ordenadoPorEdad (GET)

**Cursos**

CRUD

- /cursos(GET,POST)
- /cursos/{id} (GET,PUT,DELETE)

### `Body request POST/PUT` flag

```Body request POST/PUT
{
    "nombre":".NET 8 Full Stack",
    "siglas":"NETFS",
    "estado":true
}
```

**Matricula**

Creacion/lectura de matriculas y relación de cursos matriculados y sus estudiantes correspondientes.

- /matricula (GET,POST)

### `Body request POST` flag

```Body request POST
{
    "estudiante":{"idEstudiante":1},
    "fechaMatricula":"2024-11-22T20:15:20",
    "estado":true,
    "detalleMatricula":[
        {"curso":{"idCurso":1},"aula":"A101"},
        {"curso":{"idCurso":2},"aula":"A102"},
        {"curso":{"idCurso":4},"aula":"A104"}
    ]
}
```
- /matricula/estudiantesPorCurso (GET)