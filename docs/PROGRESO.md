# Progreso — Kata Ciclo de Vida

## Estado actual
- Sprint actual: S0 (Entorno)
- Último ticket completado: S0-T1 (JDK 21)
- Siguiente ticket: S0-T2 editor (VS Code + packs Java/Spring)
- Riesgos / bloqueos: Java no instalado; horas disponibles por día aún sin confirmar
- Días para la entrega (mar 17, 12:00): 4 (hoy vie 13 nov)

## Horas disponibles
- Vie 13 (noche): descansar (solo diagnóstico y, opcional, S0-T1)
- Sáb 14: 5 h | Dom 15: 5 h | Lun 16 (festivo): 5 h | Mar 17: 4 h (entrega antes de 10:00)
- Total aprox.: 19 h. Cupo Pro: 17% semanal usado al arrancar; hay 1 restablecimiento completo gratis (vence 10 dic).

## Diagnóstico inicial (vie 13 nov)
- Ambientes en Angular: los asocia a ramas (main/develop) y a `.env`; el servidor de su empresa despliega según la rama. No ha tocado la config de ambientes.
- `ng build`: mezcla build con pipeline (test, npm install, Jenkins). Ha usado `ng build` en Cloudflare sin ver el detalle.
- Docker: instalado, uso casi nulo; vio un caso con WordPress infectado. Confunde imagen con contenedor.

## Entorno detectado (vie 13 nov)
- Git 2.55 instalado
- Docker 29.5 instalado
- Java: NO instalado
- Maven: no se instala, usamos el wrapper (`mvnw`)

## Tickets
- [x] S0-T1 Instalar JDK 21 LTS y configurar JAVA_HOME (Temurin 21.0.13, JAVA_HOME OK, 14 nov 00:14). java vs javac explicado y entendido (javac compila .java a .class, java ejecuta el .class)
- [ ] S0-T2 Editor: VS Code + Extension Pack for Java + Spring Boot Extension Pack
- [ ] S0-T3 Postman listo (o curl)
- [ ] S0-T4 Repo personal en GitHub (`jhonmario7`) + `git init` + `.gitignore`
- [ ] S0-T5 Verificar entorno: `java -version`, `git --version`, `docker --version`

## Decisiones técnicas (y por qué)
- (se llenan desde S2)

## Glosario (ES / EN)
- JDK / Java Development Kit: kit para compilar y ejecutar Java (como Node + tsc juntos).
- LTS / Long Term Support: versión con soporte extendido.
- JAVA_HOME: variable de entorno que apunta al JDK; Maven la usa para saber qué Java correr.

## Diario de aprendizaje
### Sesión 1 — 2026-11-13
- Aprendí: (al cierre)
- Me costó: (al cierre)
- Lo resolví así: (al cierre)
- Pregunta que aún tengo: (al cierre)
