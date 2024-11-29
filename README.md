# Sistema de matricula
Este repositorio contiene el código fuente de los servicios REST para el CRUD de estudiante y curso , así como el registro de matrícula de una academia.

Los endpoints desarrollados son:

**Estudiantes:**

CRUD y listado de estudiantes en forma descendente usando la edad.

- /estudiantes (GET,POST)
- /estudiantes/{id} (GET,PUT,DELETE)

### `Body request POST/PUT`

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

### `Body request POST/PUT`

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

### `Body request POST`

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

<h2 style="color:red;">Control de excepciones</h2>

- Registro de estudiante con DNI repetido

### `Response`

```Response
{
    "status": 400,
    "message": "bad-request",
    "data": [
        {
            "datetime": "2024-11-28T15:13:59.8746451",
            "message": "dni: El DNI ya está registrado",
            "path": "uri=/estudiantes"
        }
    ]
}
```

- Registro de curso con nombre repetido

### `Response`

```Response
{
    "status": 400,
    "message": "bad-request",
    "data": [
        {
            "datetime": "2024-11-28T15:15:24.679776",
            "message": "nombre: El nombre del Curso ya está registrado",
            "path": "uri=/cursos"
        }
    ]
}
```

- Actualizacion de estudiantes y cursos con ID no registrado

### `Response`

```Response
{
    "status": 404,
    "message": "not-found",
    "data": [
        {
            "datetime": "2024-11-28T17:47:17.781305",
            "message": "ID NOT FOUND 10000",
            "path": "uri=/estudiantes/10000"
        }
    ]
}
```



