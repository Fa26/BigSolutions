# Food ciencias

Repositorio que guardara todo documento o codigo que se deba de hacer, correspondiente al equipo "BigSolutions" de la materia "Ingenieria de Software".

## Uso

1. Descargar el proyecto
2. Crear una base de datos con mysql llamada FoodCiencias: `create database FoodCiencias;`
3. Cargar el esquema dentro de la carpeta SQL a la base: `mysql -u root -p FoodCiencias < creaEsquema.sql`
4. En caso de ser necesario, debe modificarse la contraseña de "root" en las clases "ConexionDB.java" y "PuestoTest.java" a la que se tenga establecida en la máquina local. En caso de que esta sea "password" no hay que realizar ninguna acción. 
5. Si se quiere correr los casos de prueba, deberá realizarse lo mismo de los pasos 2 y 3 pero con la base `FoodCienciasTest`.
6. De igual forma, hay que cambiar el "path" del archivo `dataset.xml` en la clase `PuestoTest.java` al path completo a dicho archivo en la computadora en la que se correrá el proyecto. Aun no se divisa una forma automática de lograrlo. 

## Contribuciones del equipo

1. Crear su rama: `git checkout -b mi-rama`
2. Cargar cambios: `git fetch`
3. Traer cambios de la rama principal: `git pull origin master`
3. Commit a sus cambios: `git commit -am 'Algun mensaje'`
4. Push a la rama: `git push origin mi-rama`
5. Responsable técnico: Hacer merge

## Créditos

* Responsable del equipo: León Canto Ángel Efraín
* Responsable de colaboración: Venegas Guerrero Fatima Alejandra
* Responsable de colaboración: Vázquez García Palemón
* Responsable de calidad: López Martínez Andrés
* Responsable técnico: Hernández Chacón Carlos Alberto


## Licencia

Libre?
