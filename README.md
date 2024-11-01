## Localized Database JavaFX Application

### Overview
This JavaFX application allows users to enter employee details (first name, last name, and email) in English, Farsi, or Japanese. The UI adapts based on the selected language, and employee data is saved to a MySQL database in language-specific tables.

### Features
- **Language Selection**: Choose between English, Farsi, and Japanese to localize the UI.
- **Dynamic UI**: Labels and buttons update to the selected language.
- **Database Integration**: Employee data is stored in language-specific tables (`employee_en`, `employee_fa`, `employee_ja`).

### Table-Based Localization
This solution uses **Table-Based Localization**, where each language has its own table:
- `employee_en` for English
- `employee_fa` for Farsi
- `employee_ja` for Japanese

Each table stores employee details in that language.

### How to Run
1. Set up the MySQL database with the provided SQL script.
2. Update the `DatabaseHelper` class with your database credentials.
3. Run the `Launcher` class to start the application.
