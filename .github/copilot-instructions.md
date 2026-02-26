# Selenium Java, Cucumber & POM Development Rules

### 1. Test Directory & Package Isolation
- NEVER place test files in the same directory as the source code (`src/main/java`).
- ALL Selenium test files MUST be located within `src/test/java`.
- ALL resources (Feature files, Configs) MUST be located within `src/test/resources`.
- **Strict Package Structure**:
    - `pages/`: Page Objects (Locators & Actions only).
    - `stepdefinitions/`: Gherkin mappings.
    - `runners/`: Cucumber execution classes.
    - `hooks/`: Browser lifecycle management (Setup/Teardown).

### 2. Strict Ticket ID Extraction (New Features)
- **Applicability**: Applies ONLY to newly created feature files and page objects.
- **Ticket ID Source**: Extract ONLY from file comments (e.g., `# Ticket: JIRA-123`) or task instructions.
- **Required Path Pattern**: 
    - Features: `src/test/resources/features/{Ticket_ID}/{filename}.feature`
    - Pages: `src/test/java/pages/{Ticket_ID}/{PageName}.java`

### 3. Page Object Model (POM) Compliance
- **Encapsulation**: All WebElements MUST be `private`. Access them only through `public` methods.
- **Logic Separation**: NEVER include Assertions inside Page classes. Assertions belong ONLY in Step Definitions.
- **Naming**: Page classes must have a `Page` suffix (e.g., `LoginPage.java`).

### 4. Gherkin Scripting Standards
- **Declarative Style**: Focus on "What" happens, not "How" (e.g., Use `When User logs in` instead of `When User clicks the blue login button`).
- **No Hardcoded Data**: Pass test data from Feature files via Parameters or Data Tables.

### 5. Naming Conventions
- Feature files must mirror the functionality name.
- Example: `Login` function -> `src/test/resources/features/ABC-123/login.feature`
- Step Definition classes must match the Feature name: `LoginSteps.java`.

### 6. Compliance Reporting & Verification
- Include a **Compliance Check** footer in every response.
- Explicitly state the Ticket ID source. If not found, ask the user immediately.

### 7. Mandatory Compliance Note
- Start or end every response with a brief "✅ Compliance" note or "⚠️ Warning" if rules cannot be met.

### 8. WebDriver & Resource Management
- ALL WebDriver instances MUST be managed via a `DriverManager` or `Hooks` class.
- NEVER hardcode browser paths. Use `WebDriverManager` or environment variables.
- Screenshot on Failure: Mandatory `@After` hook to capture screenshots for failed scenarios.

### 9. Database & State Integrity (E2E)
- NEVER rely on previous test execution data. Each Scenario MUST be independent.
- CLEANUP: Implement API or DB cleanup in `@After` hooks for any data created during the test.

### 10. Absolute Code Coverage & Failure Handling
- **ZERO TOLERANCE**: Every step in a `.feature` file MUST have a matching implementation.
- **FIXING FAILURES**: If a build fails in CI, prioritize fixing the broken Step Definition or Locator before adding new tests.
- **Command**: `mvn test -Dcucumber.options="--tags @Smoke"`

### 11. Business Logic in Tests
- NEVER implement complex business logic inside Step Definitions.
- Keep Step Definitions "thin" by calling "thick" Page Object methods.