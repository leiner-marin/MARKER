# UC-19 Generate Administrative Report

**Primary actor:** Administrator / Supervisor

**Goal:** Generate an administrative report.

**Preconditions**
- The requested report type is supported.
- The actor is authorized.

**Main flow**
1. The actor requests a report.
2. The application validates the report type.
3. The report port is invoked.
4. The report data is returned.
