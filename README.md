echo "# Modelcar" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/MonicaPS06/Modelcar.git
git push -u origin main
# Car Inventory Management System

## Matriculation Number:
- 7221964

## Description:
This project is a car inventory management system written in Java. It allows users to store an array of car objects and filter them based on criteria such as car brand, model, year of manufacture, and price. The filtered car lists are saved to files.

### Features:
- Save cars of a given brand to a file.
- Save cars of a specific model that have been in use for more than `n` years.
- Save cars of a specific year with a price higher than a given threshold.
