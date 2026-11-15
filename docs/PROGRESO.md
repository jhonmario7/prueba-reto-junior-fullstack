# Progreso — Kata Ciclo de Vida

## Estado actual
- Sprint actual: S1 (Java exprés), inicio sáb 14 nov
- Último ticket completado: S0 completo (T1 a T5)
- Siguiente ticket: S1-T1 tipos y variables en Java
- Riesgos / bloqueos: ninguno. Cuidar que S0 no se coma horas de S4 y S5
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
- [ ] S1-T1 Tipos y variables en Java

## Decisiones técnicas (y por qué)
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
- Pregunta que aún tengo: (al cierre) ¿es Java tipado como TypeScript? (se aborda en S1-T1)
