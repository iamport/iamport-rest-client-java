# Repository Guidelines

## Project Structure & Module Organization
- Core source lives in `src/main/java/com/siot/IamportRestClient`.
- API payload models are grouped by role: `request/` for request DTOs, `response/` for response DTOs, `serializer/` for custom Gson serializers.
- Provider-specific models live under `request/naver`, `response/naver`, `request/payco`, and `response/payco`.
- Tests are under `src/test/java/com/siot/IamportRestClient` (currently centered on `IamportRestTest.java`).
- Build outputs appear in `target/`; copied JAR artifacts are placed in `build/` via Maven resources plugin.

## Build, Test, and Development Commands
- `mvn clean package`: compiles and packages the JAR (and assembly JAR).
- `mvn test -DskipTests=false`: runs JUnit tests (POM default sets `skipTests=true`, so override explicitly).
- `mvn clean verify -DskipTests=false`: full verification lifecycle with tests enabled.
- `mvn -q -DskipTests=false test`: quick local check with reduced log noise.

## Coding Style & Naming Conventions
- Use Java 8-compatible code (`maven-compiler-plugin` targets `source/target 1.8`).
- Follow existing style: tabs for indentation, braces on same line, and concise method-level comments only when needed.
- Class names use `PascalCase` (for example, `IamportClient`, `NaverCancelData`).
- Request/response DTO names should end with `Data`, `Entry`, `List`, or domain nouns to match current patterns.
- Keep package naming consistent under `com.siot.IamportRestClient` and existing subpackages.

## Testing Guidelines
- Framework: JUnit 4 (`junit:junit:4.12`).
- Place tests in mirrored package paths under `src/test/java`.
- Name test classes with `*Test` suffix and keep test methods descriptive (for example, `cancelPayment_whenInvalidImpUid_throwsException`).
- Prefer focused unit tests for serializers, request mapping, and exception handling paths.

## Commit & Pull Request Guidelines
- Recent history uses short, typed subjects such as `feat: ...`, `fix: ...`, `docs: ...`.
- Use imperative, scoped commit messages, for example: `feat: add naver cancel reason mapping`.
- PRs should include a clear summary of API/model changes, a linked issue (if available), test evidence (`mvn test -DskipTests=false` output or rationale when skipped), and compatibility notes for public DTO/client method changes.

## Security & Configuration Tips
- Never commit API keys or secrets used by `IamportClient`.
- Use environment variables or local-only Maven profiles for credentials and signing (`gpg`, `ossrh`) settings.
