# Progreso — Kata Ciclo de Vida

## Estado actual
- Sprint actual: S0 a S5 completos (lunes 16 nov, noche). Entregable mínimo funcionando y en GitHub
- Último ticket completado: README + clon limpio verificado
- Siguiente ticket: S11 guion de demo (7 min); plus opcionales: S6 tests, S7 Docker
- Verificado: clon limpio desde GitHub, `mvnw clean package` OK, dev (8080) y prod (9090) a la vez, POST 201, duplicado 409, GET 200
- Riesgos / bloqueos: saturación al cierre del sáb 14 (4 h de estudio, muchos conceptos nuevos). Dom 15: empezar con repaso corto (Map clave/valor, Optional, RuntimeException vs Exception) y avanzar a S2-T1 sin prisa. Cuidar horas para S4 y S5
- Días para la entrega (mar 17, 12:00): 3 (hoy sáb 14 nov)

## Horas disponibles
- Sáb 14: 5 h | Dom 15: 5 h | Lun 16 (festivo): 5 h | Mar 17: 4 h (entrega antes de 10:00)
- Total aprox.: 19 h. Cupo Pro: 17% semanal usado al arrancar; hay 1 restablecimiento completo gratis (vence 10 dic).

## Diagnóstico inicial (vie 13 nov)
- Ambientes en Angular: los asocia a ramas (main/develop) y a `.env`; el servidor de su empresa despliega según la rama. No ha tocado la config de ambientes.
- `ng build`: mezcla build con pipeline (test, npm install, Jenkins). Ha usado `ng build` en Cloudflare sin ver el detalle.
- Docker: instalado, uso casi nulo; vio un caso con WordPress infectado. Confunde imagen con contenedor.

## Entorno (verificado sáb 14 nov)
- Java: Temurin 21.0.13 LTS, JAVA_HOME OK
- Git 2.55.0, Docker 29.5.2
- Maven: no se instala, usamos el wrapper (`mvnw`)
- Editor: Cursor + Red Hat Language Support for Java, Debugger for Java, Spring Boot Tools
- Ojo: Cursor ejecuta con el JRE 25 de la extensión de Red Hat, no con el JDK 21. Maven usará JAVA_HOME (21)
- Postman: listo (ya lo usa en su trabajo)
- Repo: https://github.com/jhonmario7/prueba-reto-junior-fullstack (rama main enlazada a origin/main)
- `.gitignore`: target/, .idea/, .vscode/, *.log, .env, *.pdf, CLAUDE.md (docs/ SÍ se versiona)

## Tickets
- [x] S0-T1 JDK 21 LTS + JAVA_HOME. java vs javac entendido a medias: javac = tsc (compila .java a .class); java = Node (ejecuta el bytecode en la JVM)
- [x] S0-T2 Editor listo (Cursor + 3 extensiones de Java/Spring); Hola.java corre
- [x] S0-T3 Postman listo
- [x] S0-T4 Repo GitHub + git init + .gitignore + primer push (commit 9280cc2)
- [x] S0-T5 Verificado: java, git y docker responden bien
- [x] S1-T1 Tipos y variables (Java es tipado y estricto; `7 / 2` = 3 por división entera; sin `undefined`, variables locales deben inicializarse)
- [x] S1-T2 Clases y `record` (inmutable, sin setters, constructor con todos los campos, `toString` automático)
- [x] S1-T3 Colecciones: `List<Customer>`, `Map<String, Customer>` (clave = email, valor = Customer), `get` devuelve null si no existe
- [x] S1-T4 `Optional` (`ofNullable`, `isPresent`, `map`, `orElse`)
- [x] S1-T5 Excepciones: `CustomerNotFoundException extends RuntimeException`, `orElseThrow`, lectura de stack trace
- [x] S2 API base: Spring Initializr (Boot 4.1.2, Java 21, Maven, Jar), capas controller/service/repository/model, repositorio en memoria con ConcurrentHashMap, POST 201 y GET
- [x] S3 Calidad: @Valid con NotBlank/Email/Min/Max, @RestControllerAdvice (400 con errores por campo, 409 por email duplicado con putIfAbsent)
- [x] S4 Ambientes: application.properties + -dev/-prod, StartupLogger (ApplicationReadyEvent), GET /api/info, precedencia (argumento > archivo)
- [x] S5 Build y run: finalName=app, un solo app.jar con --spring.profiles.active, dev y prod simultáneos, README
- [ ] S6 Tests (opcional)
- [ ] S7 Docker (opcional)
- [ ] S11 Guion de demo

## Decisiones técnicas (y por qué)
- Insight central: build once, deploy many. El mismo app.jar cambia según el perfil que se le pasa al ARRANCAR, no al compilar (a diferencia de fileReplacements en Angular).
- Precedencia: argumentos de línea de comandos > variables de entorno > application-{perfil}.properties > application.properties.
- Repositorio con ConcurrentHashMap y putIfAbsent: seguro entre hilos y atómico para detectar duplicados. Trade-off: datos volátiles y no sirve con varias instancias.
- Validación en el controlador (@Valid), reglas de negocio (duplicado) en el repositorio, errores centralizados en un @RestControllerAdvice.
- Caso conocido sin resolver: JSON sin `edad` da 400 genérico (falla al leer el cuerpo, antes de @Valid).
- CLAUDE.md fuera del repo (`.gitignore`): contiene datos personales y el repo puede ser público.
- PDFs (CV y enunciado) fuera del repo por la misma razón.

## Glosario (ES / EN)
- JDK / Java Development Kit: kit para compilar y ejecutar Java (como Node + tsc juntos).
- JRE / Java Runtime Environment: solo lo necesario para ejecutar Java.
- JVM / Java Virtual Machine: máquina virtual que ejecuta el bytecode (como Node ejecuta JS).
- Bytecode: el `.class` que genera javac; no es código máquina, lo interpreta la JVM.
- LTS / Long Term Support: versión con soporte extendido.
- JAVA_HOME: variable de entorno que apunta al JDK; Maven la usa para saber qué Java correr.
- PATH: variable de entorno con la lista de carpetas donde el sistema busca ejecutables (`java`, `git`).
- Environment variable / variable de entorno: valor del sistema operativo que cualquier programa puede leer.
- Refactor / refactorización: cambiar el código sin cambiar su comportamiento (ej. renombrar una clase en todos lados).
- Untracked / sin rastrear: archivo que Git todavía no conoce.
- Staged / en preparación: archivo que ya hiciste `git add` y entrará en el próximo commit.
- `git rm --cached`: dejar de rastrear un archivo sin borrarlo del disco.
- Primitive / primitivo: tipo simple (`int`, `boolean`), guarda el valor directo, sin métodos ni null.
- Record / record: clase de datos inmutable; genera constructor, lectores, toString, equals y hashCode.
- Getter / Setter: método para leer / cambiar un campo; un record no tiene setters.
- Generics / genéricos: el `<Customer>` de `List<Customer>`; le dice al compilador qué tipo guarda.
- Integer division / división entera: `int / int` descarta decimales.
- Optional / Optional: envoltorio que dice "puede no haber valor"; evita el NullPointerException.
- Checked vs unchecked: excepciones que el compilador obliga a manejar (`Exception`) o no (`RuntimeException`).
- Stack trace / traza de pila: lista de dónde falló; leer la primera línea (qué) y la primera con tu paquete (dónde).
- Thread-safe / seguro para hilos: estructura que aguanta varios hilos a la vez; `ArrayList` y `HashMap` no lo son.

## Diario de aprendizaje
### Sesión 1 — 2026-11-13
- Aprendí: javac vs java; JDK y JAVA_HOME.
- Me costó: ubicar qué es una "variable de entorno" y para qué sirve JAVA_HOME.
- Lo resolví así: repaso guiado en la sesión 2.
- Pregunta que aún tengo: (ninguna registrada)

### Sesión 2 — 2026-11-14
- Aprendí: el nombre del archivo debe coincidir con la clase pública (`Hola.java`); clases en PascalCase y paquetes en minúscula; `.gitignore` solo afecta archivos aún no rastreados (para soltar uno ya subido: `git rm -r --cached`); `git add .` agrega todo, mejor revisar con `git diff --staged`.
- Me costó: recordar qué hace JAVA_HOME y qué es una variable de entorno; confundí los comandos de Maven con los de javac.
- Lo resolví así: correcciones guiadas; el comando que recrea `target/` y las dependencias es `.\mvnw.cmd clean package`.
- Pregunta que aún tengo: (resuelta) Java sí es tipado, más estricto que TS.

### Sesión 2 (cont.) — S1 Java exprés, 2026-11-14
- Aprendí: tipos, record, List/Map, Optional y excepciones propias; que las instrucciones solo van dentro de métodos; que `get` de un Map devuelve null en silencio y por eso existe Optional; leer un stack trace.
- Me costó: confundir clave y valor del Map; poner código suelto dentro de la clase sin método; el package al mover archivos.
- Lo resolví así: separé la práctica en `sandbox/` (ignorada en git) con un archivo por tema.
- Pendiente de repaso: por qué la excepción extiende RuntimeException (probar `extends Exception` y ver el error del compilador).
- Pregunta que aún tengo: ninguna registrada.
